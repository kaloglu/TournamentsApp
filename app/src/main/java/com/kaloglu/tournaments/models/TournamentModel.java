package com.kaloglu.tournaments.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.provider.BaseColumns;

import com.kaloglu.tournaments.commons.Enums;
import com.kaloglu.tournaments.databases.DBHelper;
import com.kaloglu.tournaments.databases.structures.TournamentsTable;

/**
 * Created by kaloglu on 23/05/16.
 */
public class TournamentModel extends BaseModel {

    private static final String TABLENAME = "Tournaments";
    private long id;
    private String name;
    private boolean isLeague;
    private boolean hasRevenge;
    private long createTS;

    public TournamentModel() {
    }

    public TournamentModel(Cursor paramCursor) {
        id = paramCursor.getLong(paramCursor.getColumnIndex(TournamentsTable.COLUMNS.ID));
        name = paramCursor.getString(paramCursor.getColumnIndex(TournamentsTable.COLUMNS.NAME));
        isLeague = (paramCursor.getInt(paramCursor.getColumnIndex(TournamentsTable.COLUMNS.ISLEAGUE)) == 1);
        hasRevenge = (paramCursor.getInt(paramCursor.getColumnIndex(TournamentsTable.COLUMNS.HASREVENGE)) == 1);
        createTS = paramCursor.getLong(paramCursor.getColumnIndex(TournamentsTable.COLUMNS.CREATETS));
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


}
