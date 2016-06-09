package com.kaloglu.tournaments.databases.tables;

import android.content.Context;

import com.kaloglu.tournaments.databases.dao.SqliteDAO;

/**
 * Created by cihank on 09/06/16.
 */
public class Tournaments extends SqliteDAO {
    private static Tournaments instance;


    public static Tournaments getInstance(Context context) {

        if (instance==null){
            instance = new Tournaments(context);
        }
        return instance;
    }

    private Tournaments(Context context) {
        super(context);
        primaryKey = "tournamentId";
        table_name = "Tournaments";
        fields = new String[]{
                primaryKey,
                "tournamentName",
                "isLeague",
                "hasRevenge"
        };
    }
}
