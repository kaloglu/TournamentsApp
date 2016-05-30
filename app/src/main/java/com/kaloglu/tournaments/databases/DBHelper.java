package com.kaloglu.tournaments.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.kaloglu.tournaments.models.PlayerModel;
import com.kaloglu.tournaments.models.TournamentModel;

import java.util.ArrayList;

public class DBHelper extends Database {

    private final SQLiteDatabase database;
    private final boolean isWritable;

    public DBHelper(Context context, boolean isWritable) {
        super(context);
        this.isWritable = isWritable;

        if (isWritable)
            database = getWritableDatabase();
        else
            database = getReadableDatabase();


    }

    public DBHelper(Context context) {
        super(context);
        this.isWritable = false;

        database = getReadableDatabase();
    }

    public long SaveToDB(String tableName, String keyColumnName, ContentValues contentValues) {
        if (!isWritable)
            throw new SQLiteException("you cannot save for DB is readble at now!");

        if (contentValues == null) {
            throw new SQLiteException("[" + tableName + "] => ContenValues cannot be null!");
        }

        if (contentValues.get(keyColumnName) == null || contentValues.get(keyColumnName).toString().equals("")) {
            return database.insertOrThrow(tableName, null, contentValues);
        } else
            return database.update(tableName, contentValues, keyColumnName + "=" + contentValues.get(keyColumnName), null);
    }

    public ArrayList<TournamentModel> getTournamentsFromDB() {
        String selectQuery = "select * FROM " + DatabaseStructure.Table_Name_Tournaments +
                " ORDER BY createTS DESC" +
                " LIMIT 20";

        Log.e("DB", "QUERY: " + selectQuery);
        ArrayList<TournamentModel> tournamentModels = new ArrayList<>();
        if (database.isOpen()) {
            Cursor cursor = database.rawQuery(selectQuery, null);
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    tournamentModels.add(new TournamentModel(cursor));
                } while (cursor.moveToNext());
            }
            database.close();
        }
        return tournamentModels;
    }
public ArrayList<PlayerModel> getPlayersFromDB() {
        String selectQuery = "select * FROM " + DatabaseStructure.Table_Name_Players;

        Log.e("DB", "QUERY: " + selectQuery);
        ArrayList<PlayerModel> playerModels = new ArrayList<>();
        if (database.isOpen()) {
            Cursor cursor = database.rawQuery(selectQuery, null);
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    playerModels.add(new PlayerModel(cursor));
                } while (cursor.moveToNext());
            }
            database.close();
        }
        return playerModels;
    }

}