package com.kaloglu.tournaments.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
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
    private boolean isLeague;
    private boolean hasRevenge;
    private long createTS;

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
        contentValues.put(Columns.CREATETS, getCreateTS());
        return contentValues;
    }

    public TournamentModel() {
    }

    public TournamentModel(Cursor paramCursor) {
        id = paramCursor.getLong(paramCursor.getColumnIndex(Columns.ID));
        name = paramCursor.getString(paramCursor.getColumnIndex(Columns.NAME));
        isLeague = (paramCursor.getInt(paramCursor.getColumnIndex(Columns.ISLEAGUE)) == 1);
        hasRevenge = (paramCursor.getInt(paramCursor.getColumnIndex(Columns.HASREVENGE)) == 1);
        createTS = paramCursor.getLong(paramCursor.getColumnIndex(Columns.CREATETS));
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setLeague(boolean league) {
        isLeague = league;
    }

    public void setHasRevenge(boolean hasRevenge) {
        this.hasRevenge = hasRevenge;
    }

    public void setCreateTS(long createTS) {
        this.createTS = createTS;
    }

    public long getCreateTS() {
        return createTS;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLeague() {
        return isLeague;
    }

    public boolean hasRevenge() {
        return hasRevenge;
    }

    public Enums.DatabaseResult SaveTournament(Context context) {
        try {
            DBHelper database = new DBHelper(context, true);
            this.id = database.SaveToDB(TABLENAME, Columns.ID, getContentValues());
            return Enums.DatabaseResult.SUCCESS;
        } catch (SQLiteException se) {
            se.printStackTrace();
            return Enums.DatabaseResult.FAILURE;
        }
    }
}
