package com.kaloglu.tournaments.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, DatabaseStructure.DBNAME, null, DatabaseStructure.DBVERSION);
    }

    public void FreshDB(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseStructure.DROP_QUERY + DatabaseStructure.Table_Name_Tournaments);
        sqLiteDatabase.execSQL(DatabaseStructure.DROP_QUERY + DatabaseStructure.Table_Name_Teams);
        sqLiteDatabase.execSQL(DatabaseStructure.DROP_QUERY + DatabaseStructure.Table_Name_Players);
        sqLiteDatabase.execSQL(DatabaseStructure.DROP_QUERY + DatabaseStructure.Table_Name_Fixtures);
        sqLiteDatabase.execSQL(DatabaseStructure.DROP_QUERY + DatabaseStructure.Table_Name_Details);
        sqLiteDatabase.execSQL(DatabaseStructure.DROP_QUERY + DatabaseStructure.Table_Name_Cards);
        onCreate(sqLiteDatabase);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseStructure.Create_Tables_Script);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        FreshDB(sqLiteDatabase);
    }
}