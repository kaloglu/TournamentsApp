package com.kaloglu.tournaments.databases.dao.interfaces;

import android.database.sqlite.SQLiteDatabase;

import org.json.JSONObject;

/**
 * Created by kaloglu on 11/06/16.
 */
public interface ICreateTable {
    ICreateTable table(String name);

    ICreateTable field(String name, JSONObject attributes);
    ICreateTable foreignKey(String name, JSONObject attributes);

    String getQueryString();

    void execute(SQLiteDatabase database);
}
