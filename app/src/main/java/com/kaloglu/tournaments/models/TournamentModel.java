package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class TournamentModel extends BaseModel {

    private long tournamentId = Long.MAX_VALUE;
    private String tournamentName;
    private boolean isLeague;
    private boolean hasRevenge;
    private long createTS = Long.MAX_VALUE;

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


    @Override
    public String getSaveableString() {
        return "'" + tournamentName + "', '" + isLeague + "', '" + hasRevenge + "', '" + NullCheck(createTS, System.currentTimeMillis()) + "'";
    }

}
