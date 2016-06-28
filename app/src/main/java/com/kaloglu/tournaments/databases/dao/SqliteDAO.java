package com.kaloglu.tournaments.databases.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kaloglu.tournaments.databases.DBHelper;
import com.kaloglu.tournaments.databases.dao.interfaces.ISqliteDAO;
import com.kaloglu.tournaments.models.BaseModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * https://github.com/sreejesh79/android-sqlitedao-demo/tree/master/app/src/main/java/com/kriyatma/sqlitedaodemo/
 */
public abstract class SqliteDAO implements ISqliteDAO {
    private static SqliteDAO instance;
    protected String table_name = "";
    protected String[] fields = new String[]{};
    protected String primaryKey;
    protected String foriegnKey;
    protected List<ForeignKey> foreignKeys = new ArrayList<>();
    protected SQLiteDatabase database;
    protected Cursor queryCursor;
    protected String queryBuilder = "";
    protected String strLimit = "";
    protected String strSort = "";
    protected Gson gson;

    private Boolean isMultiSelect = true;
    private Boolean isWhereStart = false;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private int rowId;

    public SqliteDAO(SQLiteDatabase db) {
        database = db;
        initTable();
    }

    public SqliteDAO(Context context) {
        database = DBHelper.getInstance(context).getWritableDatabase();
        gson = new Gson();
        initTable();
    }

    public ISqliteDAO table(String table) {
        table_name = table;
        return this;
    }

    public ISqliteDAO fields(String... fields) {
        this.fields = fields;
        return this;
    }

    public ISqliteDAO find() {
        String strFields;
        strFields = fieldsToString(fields);
        queryBuilder = "SELECT " + strFields + " FROM " + table_name + " ";
        isMultiSelect = true;
        isWhereStart = false;
        //dispatchEvent(new Event("new event",this));
        return this;
    }

    public ISqliteDAO findOne() {
        String strFields;
        strFields = fieldsToString(fields);
        strLimit = "LIMIT 1";
        queryBuilder = "SELECT " + strFields + " FROM " + table_name + " ";
        isMultiSelect = false;
        isWhereStart = false;
        return this;
    }

    public ISqliteDAO select(ISqliteDAO... daos) {
        queryBuilder = "SELECT ";
        String strFields;
        strFields = fieldsToString(fields, table_name) + ",";

        String strTables = this.table_name;
        Integer mainCounter = 0;
        for (ISqliteDAO dao : daos) {
            SqliteDAO sqliteDAO = (SqliteDAO) dao;

            if (mainCounter < daos.length - 1) {
                strFields += fieldsToString(sqliteDAO.fields, sqliteDAO.table_name) + ",";
                //strFields+=sqliteDAO.table_name+".*"+",";
                //strTables+= sqliteDAO.table_name+",";
            } else {
                strFields += fieldsToString(sqliteDAO.fields, sqliteDAO.table_name);
                //   strFields+=sqliteDAO.table_name+".*";
                //strTables+= sqliteDAO.table_name;
            }
            mainCounter++;
        }
        queryBuilder += strFields + " FROM " + strTables + " ";
        return this;
    }


    public ISqliteDAO select(String selection) {
        queryBuilder = selection + " ";
        return this;
    }

    public ISqliteDAO createJoins(ISqliteDAO... daos) {
        select(daos);
        for (ISqliteDAO dao : daos) {
            join(dao);
        }
        return this;
    }

    public ISqliteDAO save(String values) {

        String fields_str = "";
        Integer counter = 0;
        for (String field : fields) {
//            if (field != primaryKey) {
            if (counter < fields.length - 1) {
                fields_str += field + ",";
            } else {
                fields_str += field;
            }
//            }

            counter++;

        }
        String insertQuery = "INSERT INTO " + table_name + " ( " + fields_str + ") VALUES(" + values + ")";
        Log.d("save", insertQuery);
        database.execSQL(insertQuery);
        return this;
    }

    public ISqliteDAO insert(String... values) {
        Log.d("ISqliteDAO", "insert");
        String strValues = "";
        Integer counter = 0;
        for (String value : values) {
            if (counter < values.length - 1) {
                strValues += "'" + value + "'" + ",";
            } else {
                strValues += "'" + value + "'";
            }
            counter++;
        }
        return this.save(strValues);
    }

    public ISqliteDAO insert(BaseModel model) {
        return this.save(model.getSaveableString());
    }

    public ISqliteDAO update(String[] columns, Object[] values) {
        queryBuilder = "UPDATE " + table_name + " SET ";
        Integer counter = 0;
        for (String column : columns) {
            queryBuilder += column + " = ";
            if (counter < columns.length - 1) {
                queryBuilder += "'" + values[counter].toString() + "'" + ",";
            } else {
                queryBuilder += "'" + values[counter].toString() + "'";
            }
            counter++;
        }
        queryBuilder += " ";
        return this;
    }

    public ISqliteDAO where(String clause) {
        if (!isWhereStart) {
            queryBuilder += "WHERE " + clause + " ";
        } else {
            queryBuilder += "and " + clause + " ";
        }
        isWhereStart = true;
        return this;
    }

    public ISqliteDAO orWhere(String clause) {
        if (!isWhereStart) {
            queryBuilder += clause + " ";
        } else {
            queryBuilder += "or " + clause + " ";
        }
        isWhereStart = true;
        return this;
    }

    public ISqliteDAO limit(Integer limit) {
        if (isMultiSelect) {
            strLimit = "LIMIT " + limit.toString() + " ";
        }
        return this;
    }

    public ISqliteDAO sort(String field, String sortby) {
        strSort = "ORDER BY " + field;
        if (!sortby.equals(""))
            strSort += " " + sortby + " ";
        return this;
    }

    public ISqliteDAO join(ISqliteDAO dao) {
        SqliteDAO sqliteDAO = (SqliteDAO) dao;
        String onStr = "";
        Log.d("in join", sqliteDAO.table_name);
        join(sqliteDAO.table_name);
        if (this.foreignKeys.size() > 0) {
            String fk = getFK(sqliteDAO.table_name);
            onStr = this.table_name + "." + fk + "=" + sqliteDAO.table_name + "." + sqliteDAO.primaryKey;
        } else if (this.foriegnKey != null && !this.foriegnKey.equals("")) {
            onStr = this.table_name + "." + this.foriegnKey + "=" + sqliteDAO.table_name + "." + sqliteDAO.primaryKey;
        }
        on(onStr);
        //queryBuilder += on(onStr);
        //Log.d("in join queryBuilder ",sqliteDAO.table_name);

        return this;
    }

    public ISqliteDAO join(String table) {
        Log.d("in string join", table);
        queryBuilder += "INNER JOIN " + table + " ";
        Log.d("in string join", queryBuilder);
        return this;
    }

    public ISqliteDAO leftJoin(String table) {
        queryBuilder += "LEFT JOIN " + table + " ";
        return this;
    }

    public ISqliteDAO on(String on) {
        queryBuilder += "ON " + on + " ";
        return this;
    }

    public ISqliteDAO execute() {
        queryBuilder += strSort;
        queryBuilder += strLimit;
        Log.d("queryBuilder", queryBuilder);
        queryCursor = database.rawQuery(queryBuilder, null);
        return this;
    }

    public ISqliteDAO execute(String queryString) {
        queryBuilder = queryString;
        queryCursor = database.rawQuery(queryBuilder, null);
        return this;
    }

    public void execSql() {
        Log.d("queryBuilder", queryBuilder);
        database.execSQL(queryBuilder);
    }

    public Cursor cursor() {
        return queryCursor;
    }

    public ISqliteDAO json() {
        jsonObject = cur2json(queryCursor);
        return this;
    }

    public ISqliteDAO jsonList() {
        jsonArray = cur2jsonList(queryCursor);
        return this;
    }

    @Override
    public <T> T getObject(Class<T> classOfT) {
        execute().json();
        return gson.fromJson(jsonObject.toString(), classOfT);
    }

    @Override
    public <T, V> ArrayList<T> getArray(TypeToken<V> typeToken) {
        execute().jsonList();
        return gson.fromJson(jsonArray.toString(), typeToken.getType());
    }

    @Override
    public String getDropScript() {
        return "DROP TABLE IF EXISTS " + table_name + ";";
    }

    public String getTable() {
        return table_name;
    }

    public String[] getFields() {
        return fields;
    }

    public String getFK(String table) {
        String fk = "";
        for (ForeignKey fkObj : foreignKeys) {
            if (fkObj.getTableName().equals(table)) {
                fk = fkObj.getForiegnKey();
                break;
            }
        }
        return fk;
    }

    public JSONObject cur2json(Cursor cursor) {
        JSONObject rowObject = new JSONObject();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int totalColumn = cursor.getColumnCount();
            for (int i = 0; i < totalColumn; i++) {
                if (cursor.getColumnName(i) != null) {
                    try {
                        rowObject.put(cursor.getColumnName(i),
                                cursor.getString(i));
                    } catch (Exception e) {
                        Log.d("cur2json", e.getMessage());
                    }
                }
            }
            cursor.moveToNext();
        }

        cursor.close();
        return rowObject;
    }

    public JSONArray cur2jsonList(Cursor cursor) {
        JSONArray jsonArray = new JSONArray();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int totalColumn = cursor.getColumnCount();
            JSONObject rowObject = new JSONObject();
            for (int i = 0; i < totalColumn; i++) {
                if (cursor.getColumnName(i) != null) {
                    try {
                        rowObject.put(cursor.getColumnName(i),
                                cursor.getString(i));
                    } catch (Exception e) {
                        Log.d("cur2json", e.getMessage());
                    }
                }
            }
            cursor.moveToNext();
            jsonArray.put(rowObject);
        }

        cursor.close();
        return jsonArray;
    }


    public String fieldsToString(String... fields) {
        String strFields = "";

        if (fields.length > 0) {
            Integer counter = 0;
            for (String field : fields) {
                if (counter < fields.length - 1) {
                    strFields += field + ",";
                } else {
                    strFields += field;
                }
                counter++;
            }
        } else {
            strFields = "*";
        }

        return strFields;
    }

    public String fieldsToString(String[] fields, String tableName) {
        String strFields = "";
        Integer counter = 0;
        if (fields.length > 0) {
            for (String field : fields) {
                if (counter < fields.length - 1) {
                    strFields += tableName + "." + field + ",";
                } else {
                    strFields += tableName + "." + field;
                }
                counter++;
            }
        } else {
            strFields += tableName + ".*";
        }

        return strFields;
    }

    protected abstract void initTable();

    public String getPrimaryKey() {
        return primaryKey;
    }

    public String getCreateScript() {
        initTable();
        return "";
    }

}
