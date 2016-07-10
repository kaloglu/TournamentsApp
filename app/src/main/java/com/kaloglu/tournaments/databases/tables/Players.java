package com.kaloglu.tournaments.databases.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.kaloglu.tournaments.databases.dao.SqliteDAO;

/**
 * Created by cihank on 09/06/16.
 */
public class Players extends SqliteDAO {
    private static Players instance;
    private Teams teams;

    private Players(Context context) {
        super(context);
    }

    private Players(SQLiteDatabase db) {
        super(db);
    }

    public static Players getInstance(Context context) {
        return (instance == null) ? instance = new Players(context) : instance;
    }

    public static Players getInstance(SQLiteDatabase db) {
        return (instance == null) ? instance = new Players(db) : instance;
    }

    public static Players getInstance() {
        if (instance == null) throw new NullPointerException("instance not initialized yet!");
        return instance;
    }

    @Override
    protected void initTable() {
        teams = Teams.getInstance();
        primaryKey = "playerId";
        table_name = "Players";
        fields = new String[]{primaryKey, "playerName", "favoriteTeamId"};
    }

    @Override
    public String getCreateScript() {
        return "CREATE TABLE " + table_name + " (" +
                " `" + fields[0] + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                " `" + fields[1] + "` TEXT NOT NULL," +
                " `" + fields[2] + "` INTEGER NOT NULL," +
                " FOREIGN KEY(`" + fields[2] + "`) REFERENCES `" + teams.getTable() + "`(`" + teams.getPrimaryKey() + "`)" +
                " );";
    }
}
