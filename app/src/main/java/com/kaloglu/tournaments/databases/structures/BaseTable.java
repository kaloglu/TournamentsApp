package com.kaloglu.tournaments.databases.structures;

import android.content.ContentValues;
import android.content.Context;
import android.provider.BaseColumns;

import com.kaloglu.tournaments.databases.DBHelper;

/**
 * Created by kaloglu on 05/06/16.
 */
public class BaseTable<T> {
    public static final String CREATE_SCRIPT = "CREATE TABLE";
    public static final String NAME = "NAME";
    public static final String DROP_SCRIPT = "DROP TABLE ... IF EXIST ";

    protected abstract static class COLUMNS implements BaseColumns {
        public static final String ID = null;
    }

    ContentValues Data(T model) {
        return null;
    }

    long Insert(Context context, T model) {
        DBHelper database = new DBHelper(context, true);
        return database.SaveToDB(NAME, COLUMNS.ID, Data(model));
    }
}
