package com.kaloglu.tournaments.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kaloglu.tournaments.databases.structures.CardsTable;
import com.kaloglu.tournaments.databases.structures.DetailsTable;
import com.kaloglu.tournaments.databases.structures.FixturesTable;
import com.kaloglu.tournaments.databases.structures.PlayersTable;
import com.kaloglu.tournaments.databases.structures.TeamsTable;
import com.kaloglu.tournaments.databases.structures.TournamentsTable;
import com.kaloglu.tournaments.models.TeamModel;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, DatabaseStructure.DBNAME, null, DatabaseStructure.DBVERSION);

    }

    public void FreshDB(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TournamentsTable.DROP_SCRIPT);
        sqLiteDatabase.execSQL(PlayersTable.DROP_SCRIPT);
        sqLiteDatabase.execSQL(TeamsTable.DROP_SCRIPT);
        sqLiteDatabase.execSQL(FixturesTable.DROP_SCRIPT);
        sqLiteDatabase.execSQL(DetailsTable.DROP_SCRIPT);
        sqLiteDatabase.execSQL(CardsTable.DROP_SCRIPT);

        onCreate(sqLiteDatabase);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TournamentsTable.CREATE_SCRIPT);
        sqLiteDatabase.execSQL(TournamentsTable.INS_DUMMY_DATA);

        sqLiteDatabase.execSQL(PlayersTable.CREATE_SCRIPT);
        sqLiteDatabase.execSQL(PlayersTable.INS_DUMMY_DATA);

        sqLiteDatabase.execSQL(TeamsTable.CREATE_SCRIPT);
        sqLiteDatabase.execSQL(TeamsTable.INS_DUMMY_DATA);

        sqLiteDatabase.execSQL(FixturesTable.CREATE_SCRIPT);
        sqLiteDatabase.execSQL(FixturesTable.INS_DUMMY_DATA);

        sqLiteDatabase.execSQL(DetailsTable.CREATE_SCRIPT);
        sqLiteDatabase.execSQL(DetailsTable.INS_DUMMY_DATA);

        sqLiteDatabase.execSQL(CardsTable.CREATE_SCRIPT);
//        sqLiteDatabase.execSQL(CardsTable.INS_DUMMY_DATA);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        FreshDB(sqLiteDatabase);
    }
}