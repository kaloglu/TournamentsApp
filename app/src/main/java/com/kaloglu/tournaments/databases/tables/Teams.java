package com.kaloglu.tournaments.databases.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.kaloglu.tournaments.databases.dao.SqliteDAO;

/**
 * Created by cihank on 09/06/16.
 */
public class Teams extends SqliteDAO {
    private static Teams instance;

    private Teams(Context context) {
        super(context);
    }

    private Teams(SQLiteDatabase db) {
        super(db);
    }

    public static Teams getInstance(Context context) {
        return (instance == null) ? instance = new Teams(context) : instance;
    }

    public static Teams getInstance(SQLiteDatabase db) {
        return (instance == null) ? instance = new Teams(db) : instance;
    }

    public static Teams getInstance() {
        return instance;
    }

    @Override
    protected void initTable() {
        primaryKey = "teamId";
        table_name = "Teams";
        fields = new String[]{
                primaryKey,
                "teamName"
        };
    }

    @Override
    public String getCreateScript() {
        return
                "CREATE TABLE " + table_name + " (" +
                        " `" + fields[0] + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                        " `" + fields[1] + "` TEXT NOT NULL" +
                        " );";
    }
}
