package com.kaloglu.tournaments.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.provider.BaseColumns;

import com.kaloglu.tournaments.commons.Enums;
import com.kaloglu.tournaments.databases.DBHelper;

/**
 * Created by kaloglu on 23/05/16.
 */
public class TournamentModel {

    private static final String TABLENAME = "Tournaments";
    private long id;
    private String name;
    public boolean isLeague;
    public boolean hasRevenge;
    private long createTs;
    private String tournamentName;
    private String createTS;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCreateTs() {
        return createTs;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public void setCreateTS(String createTS) {
        this.createTS = createTS;
    }

    public static final class Columns implements BaseColumns {
        public static final String ID = "tournamentId";
        public static final String NAME = "tournamentName";
        public static final String ISLEAGUE = "isLeague";
        public static final String HASREVENGE = "hasRevenge";
        public static final String CREATETS = "createTS";
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.ID, id);
        contentValues.put(Columns.NAME, name);
        contentValues.put(Columns.ISLEAGUE, isLeague);
        contentValues.put(Columns.HASREVENGE, hasRevenge);
        contentValues.put(Columns.CREATETS, getCreateTs());
        return contentValues;
    }

    public Enums.DatabaseResult SaveTournament(Context context) {
        try {
            DBHelper database = new DBHelper(context);
            this.id = database.SaveToDB(TABLENAME, Columns.ID,getContentValues());
            return Enums.DatabaseResult.SUCCESS;
        } catch (SQLiteException se) {
            se.printStackTrace();
            return Enums.DatabaseResult.FAILURE;
        }
    }
}
