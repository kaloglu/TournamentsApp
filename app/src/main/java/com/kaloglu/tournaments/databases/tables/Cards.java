package com.kaloglu.tournaments.databases.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.kaloglu.tournaments.databases.dao.SqliteDAO;

/**
 * Created by cihank on 09/06/16.
 */
public class Cards extends SqliteDAO {
    private static Cards instance;

    private Cards(Context context) {
        super(context);
    }

    private Cards(SQLiteDatabase db) {
        super(db);
    }

    public static Cards getInstance(Context context) {
        return (instance == null) ? instance = new Cards(context) : instance;
    }

    public static Cards getInstance(SQLiteDatabase db) {
        return (instance == null) ? instance = new Cards(db) : instance;
    }

    public static Cards getInstance() {
        return instance;
    }

    @Override
    protected void initTable() {
        Fixtures fixtures = Fixtures.getInstance();
        Players players = Players.getInstance();

        primaryKey = "cardId";
        table_name = "Cards";
        fields = new String[]{
                primaryKey,
                fixtures.getPrimaryKey(),
                players.getPrimaryKey(),
                "colorType",
                "carderName"
        };

        setCreateScript("CREATE TABLE " + table_name + " (" +
                " `" + fields[0] + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                " `" + fields[1] + "` INTEGER NOT NULL," +
                " `" + fields[2] + "` INTEGER NOT NULL," +
                " `" + fields[3] + "` INTEGER NOT NULL DEFAULT 2," +
                " `" + fields[4] + "` TEXT NOT NULL," +
                " FOREIGN KEY(`" + fields[1] + "`) REFERENCES `" + fixtures.getTable() + "`(`" + fixtures.getPrimaryKey() + "`)," +
                " FOREIGN KEY(`" + fields[2] + "`) REFERENCES `" + players.getTable() + "`(`" + players.getPrimaryKey() + "`)" +
                " );");
    }
}
