package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class FixtureModel extends BaseModel{
    private long fixtureId = Long.MAX_VALUE;
    private long tournamentId = Long.MAX_VALUE;
    private long homePlayerId = Long.MAX_VALUE;
    private int homeScore;
    private int awayScore;
    private long awayPlayerId = Long.MAX_VALUE;
    private String homePlayerName;
    private String awayPlayerName;

    public long getId() {
        return fixtureId;
    }

    public long getTournamentId() {
        return tournamentId;
    }

    public long getHomePlayerId() {
        return homePlayerId;
    }

    public void setHomePlayerId(long homePlayerId) {
        this.homePlayerId = homePlayerId;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public long getAwayPlayerId() {
        return awayPlayerId;
    }

    public void setAwayPlayerId(long awayPlayerId) {
        this.awayPlayerId = awayPlayerId;
    }

    public void setHomePlayerName(String homePlayerName) {
        this.homePlayerName = homePlayerName;
    }

    public void setAwayPlayerName(String awayPlayerName) {
        this.awayPlayerName = awayPlayerName;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getHomePlayerName() {
        return homePlayerName;
    }

    public String getAwayPlayerName() {
        return awayPlayerName;
    }

    @Override
    public String getSaveableString() {
        return tournamentId + ", " + homePlayerId + ", " + homeScore + ", " + awayScore + ", " + awayPlayerId;
    }
}
