package com.kaloglu.tournaments.databases.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.kaloglu.tournaments.databases.dao.SqliteDAO;

/**
 * Created by cihank on 09/06/16.
 */
public class Details extends SqliteDAO {
    private static Details instance;

    private Details(Context context) {
        super(context);
    }

    private Details(SQLiteDatabase db) {
        super(db);
    }

    public static Details getInstance(Context context) {
        return (instance == null) ? instance = new Details(context) : instance;
    }

    public static Details getInstance(SQLiteDatabase db) {
        return (instance == null) ? instance = new Details(db) : instance;
    }

    public static Details getInstance() {
        return instance;
    }

    @Override
    protected void initTable() {
        Tournaments tournaments = Tournaments.getInstance();
        Players players = Players.getInstance();
        Teams teams = Teams.getInstance();

        primaryKey = "detailId";
        table_name = "Details";
        fields = new String[]{
                primaryKey,
                tournaments.getPrimaryKey(),
                players.getPrimaryKey(),
                teams.getPrimaryKey()
        };

        setCreateScript("CREATE TABLE " + table_name + " (" +
                " `" + fields[0] + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                " `" + fields[1] + "` INTEGER NOT NULL," +
                " `" + fields[2] + "` INTEGER NOT NULL," +
                " `" + fields[3] + "` INTEGER NOT NULL," +
                " FOREIGN KEY(`" + fields[1] + "`) REFERENCES `" + tournaments.getTable() + "`(`" + tournaments.getPrimaryKey() + "`)," +
                " FOREIGN KEY(`" + fields[2] + "`) REFERENCES `" + players.getTable() + "`(`" + players.getPrimaryKey() + "`)," +
                " FOREIGN KEY(`" + fields[3] + "`) REFERENCES `" + teams.getTable() + "`(`" + players.getPrimaryKey() + "`)" +
                " );");
    }
}
