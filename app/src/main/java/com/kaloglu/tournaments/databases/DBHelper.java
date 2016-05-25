package com.kaloglu.tournaments.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DBHelper extends Database {

    private final SQLiteDatabase database;

    public DBHelper(Context context) {
        super(context);
        database = getWritableDatabase();
    }

    public long SaveToDB(String tableName, String keyColumnName, ContentValues contentValues) {
        if (contentValues == null) {
            throw new SQLiteException("[" + tableName + "] => ContenValues cannot be null!");
        }

        if (contentValues.get(keyColumnName) == null || contentValues.get(keyColumnName).toString().equals("")) {
            return database.insertOrThrow(tableName, null, contentValues);
        }else
            return database.update(tableName,contentValues,keyColumnName + "=" +contentValues.get(keyColumnName),null);
    }

}