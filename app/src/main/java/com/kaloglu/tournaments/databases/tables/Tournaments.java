package com.kaloglu.tournaments.databases.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.kaloglu.tournaments.databases.dao.SqliteDAO;

/**
 * Created by cihank on 09/06/16.
 */
public class Tournaments extends SqliteDAO {
    private static Tournaments instance;

    private Tournaments(Context context) {
        super(context);
    }

    private Tournaments(SQLiteDatabase db) {
        super(db);
    }

    public static Tournaments getInstance(Context context) {
        return (instance == null) ? instance = new Tournaments(context) : instance;
    }

    public static Tournaments getInstance(SQLiteDatabase db) {
        return (instance == null) ? instance = new Tournaments(db) : instance;
    }

    public static Tournaments getInstance() {
        return instance;
    }
    @Override
    protected void initTable() {
        primaryKey = "tournamentId";
        table_name = "Tournaments";
        fields = new String[]{
                primaryKey,
                "tournamentName",
                "isLeague",
                "hasRevenge",
                "createTS"
        };

        setCreateScript("CREATE TABLE " + table_name + " (" +
                " `" + fields[0] + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                " `" + fields[1] + "` TEXT NOT NULL," +
                " `" + fields[2] + "` INTEGER NOT NULL DEFAULT 1," +
                " `" + fields[3] + "` INTEGER NOT NULL DEFAULT 1," +
                " `" + fields[4] + "` TEXT NOT NULL" +
                " );");
    }
}
