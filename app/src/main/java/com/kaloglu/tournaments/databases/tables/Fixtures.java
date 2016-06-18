package com.kaloglu.tournaments.databases.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.kaloglu.tournaments.databases.dao.SqliteDAO;

/**
 * Created by cihank on 09/06/16.
 */
public class Fixtures extends SqliteDAO {
    private static Fixtures instance;
    private Tournaments tournaments;
    private Players players;


    private Fixtures(Context context) {
        super(context);
    }

    private Fixtures(SQLiteDatabase db) {
        super(db);
    }

    public static Fixtures getInstance(Context context) {
        return (instance == null) ? instance = new Fixtures(context) : instance;
    }

    public static Fixtures getInstance(SQLiteDatabase db) {
        return (instance == null) ? instance = new Fixtures(db) : instance;
    }

    public static Fixtures getInstance() {
        return instance;
    }

    @Override
    protected void initTable() {
        tournaments = Tournaments.getInstance();
        players = Players.getInstance();

        primaryKey = "fixtureId";
        table_name = "Fixtures";
        fields = new String[]{
                primaryKey,
                tournaments.getPrimaryKey(),
                "homePlayerId",
                "homeScore",
                "awayScore",
                "awayPlayerId"
        };
    }

    @Override
    public String getCreateScript() {
        return
                "CREATE TABLE " + table_name + " (" +
                        " `" + fields[0] + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                        " `" + fields[1] + "` INTEGER NOT NULL," +
                        " `" + fields[2] + "` INTEGER NOT NULL," +
                        " `" + fields[3] + "` INTEGER," +
                        " `" + fields[4] + "` INTEGER," +
                        " `" + fields[5] + "` INTEGER NOT NULL," +
                        " FOREIGN KEY(`" + fields[2] + "`) REFERENCES `" + tournaments.getTable() + "`(`" + tournaments.getPrimaryKey() + "`)," +
                        " FOREIGN KEY(`" + fields[3] + "`) REFERENCES `" + players.getTable() + "`(`" + players.getPrimaryKey() + "`)," +
                        " FOREIGN KEY(`" + fields[5] + "`) REFERENCES `" + players.getTable() + "`(`" + players.getPrimaryKey() + "`)" +
                        " );";
    }
}
