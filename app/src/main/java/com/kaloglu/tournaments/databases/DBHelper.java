package com.kaloglu.tournaments.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.kaloglu.tournaments.databases.tables.Cards;
import com.kaloglu.tournaments.databases.tables.Details;
import com.kaloglu.tournaments.databases.tables.Fixtures;
import com.kaloglu.tournaments.databases.tables.Players;
import com.kaloglu.tournaments.databases.tables.Teams;
import com.kaloglu.tournaments.databases.tables.Tournaments;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper ourInstance = null;

    private SQLiteDatabase database;
    private Tournaments tournaments;
    private Teams teams;
    private Players players;
    private Fixtures fixtures;
    private Details details;
    private Cards cards;

    public static DBHelper getInstance(Context context) {
        if (null == ourInstance) {
            ourInstance = new DBHelper(context);
        }
        return ourInstance;
    }

    public static DBHelper getInstance() {
        if (null == ourInstance) {
            throw new IllegalArgumentException("Parameter context missing");
        }
        return ourInstance;
    }

    public DBHelper(Context context) {
        super(context, DatabaseStructure.DBNAME, null, DatabaseStructure.DBVERSION);
    }

    public void FreshDB(SQLiteDatabase sqLiteDatabase) {
        database.execSQL(tournaments.getDropScript());
        database.execSQL(teams.getDropScript());
        database.execSQL(players.getDropScript());
        database.execSQL(fixtures.getDropScript());
        database.execSQL(details.getDropScript());
        database.execSQL(cards.getDropScript());

        onCreate(sqLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        FreshDB(sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("onCreate", "in create SQLiteDatabase1");
        database = db;

        tournaments = Tournaments.getInstance(database);
        teams = Teams.getInstance(database);
        players = Players.getInstance(database);
        fixtures = Fixtures.getInstance(database);
        details = Details.getInstance(database);
        cards = Cards.getInstance(database);

        initialize();
    }

    protected void initialize() {
        database.execSQL(tournaments.getCreateScript());
        database.execSQL(teams.getCreateScript());
        database.execSQL(players.getCreateScript());
        database.execSQL(fixtures.getCreateScript());
        database.execSQL(details.getCreateScript());
        database.execSQL(cards.getCreateScript());

        //CreateDummyDatas...
        runDummyCreator();
    }

    private void runDummyCreator() {
        //Tournaments...
        tournaments.insert("1", "Turnuva1111", "1", "1", "1465684911");

        //Teams...
        teams.insert("1", "Bayern Munich");
        teams.insert("2", "Chelsea");
        teams.insert("3", "Paris SG");
        teams.insert("4", "Juventus");
        teams.insert("5", "Real Madrid");
        teams.insert("6", "Liverpool);");

        //Players...
        players.insert("1", "kaloglu", "1");
        players.insert("2", "ceyhun", "1");
        players.insert("3", "mehmet", "2");
        players.insert("4", "ersin", "3");
        players.insert("5", "kadir", "4");
        players.insert("6", "hüseyin", "5");

        //Fixtures...

        fixtures.insert("1", "1", "6", "1", "6", "3");
        fixtures.insert("2", "1", "2", "2", "0", "4");
        fixtures.insert("3", "1", "1", "3", "1", "5");
        fixtures.insert("4", "1", "6", "1", "0", "2");
        fixtures.insert("5", "1", "1", "6", "2", "3");
        fixtures.insert("6", "1", "5", "2", "2", "4");
        fixtures.insert("7", "1", "6", "2", "1", "1");
        fixtures.insert("8", "1", "5", "0", "1", "2");
        fixtures.insert("9", "1", "4", "3", "5", "3");
        fixtures.insert("10", "1", "6", "2", "4", "5");
        fixtures.insert("11", "1", "4", "5", "5", "1");
        fixtures.insert("12", "1", "3", "3", "2", "2");
        fixtures.insert("13", "1", "6", "1", "3", "4");
        fixtures.insert("14", "1", "3", "3", "1", "5");
        fixtures.insert("15", "1", "2", "4", "3", "1");
        fixtures.insert("16", "1", "1", "3", "2", "2");
        fixtures.insert("17", "1", "5", "2", "2", "3");
        fixtures.insert("18", "1", "4", "2", "1", "6");
        fixtures.insert("19", "1", "2", "1", "4", "3");
        fixtures.insert("20", "1", "1", "8", "2", "4");
        fixtures.insert("21", "1", "5", "4", "0", "6");
        fixtures.insert("22", "1", "3", "NULL", "NULL", "4");
        fixtures.insert("23", "1", "2", "2", "2", "5");
        fixtures.insert("24", "1", "1", "NULL", "NULL", "6");
        fixtures.insert("25", "1", "4", "NULL", "NULL", "5");
        fixtures.insert("26", "1", "3", "2", "1", "1");
        fixtures.insert("27", "1", "2", "NULL", "NULL", "6");
        fixtures.insert("28", "1", "5", "NULL", "NULL", "1");
        fixtures.insert("29", "1", "4", "NULL", "NULL", "2");
        fixtures.insert("30", "1", "3", "NULL", "NULL", "6");

        //Details...

        details.insert("1", "1", "1", "1");
        details.insert("2", "1", "2", "1");
        details.insert("3", "1", "3", "2");
        details.insert("4", "1", "4", "3");
        details.insert("5", "1", "5", "4");
        details.insert("6", "1", "6", "5");

        //Cards...

    }

}