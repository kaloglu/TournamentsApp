package com.kaloglu.tournaments.models;

import android.database.Cursor;

/**
 * Created by kaloglu on 23/05/16.
 */
public class TournamentModel extends BaseModel {

    private long tournamentId;
    private String tournamentName;
    private boolean isLeague;
    private boolean hasRevenge;
    private long createTS;

    public TournamentModel() {
    }

    public long getId() {
        return tournamentId;
    }

    public String getName() {
        return tournamentName;
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

    public void setId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public boolean isLeague() {
        return isLeague;
    }

    public boolean hasRevenge() {
        return hasRevenge;
    }


}
