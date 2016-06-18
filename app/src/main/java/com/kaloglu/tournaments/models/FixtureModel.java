package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class FixtureModel {
    private long fixtureId;
    private long tournamentId;
    private long homePlayerId;
    private String homeScore;
    private String awayScore;
    private long awayPlayerId;
    private String homePlayerName;
    private String awayPlayerName;

    public long getFixtureId() {
        return fixtureId;
    }

    public long getTournamentId() {
        return tournamentId;
    }

    public long getHomePlayerId() {
        return homePlayerId;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public long getAwayPlayerId() {
        return awayPlayerId;
    }

    public void setHomePlayerName(String homePlayerName) {
        this.homePlayerName = homePlayerName;
    }

    public void setAwayPlayerName(String awayPlayerName) {
        this.awayPlayerName = awayPlayerName;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    public String getHomePlayerName() {
        return homePlayerName;
    }

    public String getAwayPlayerName() {
        return awayPlayerName;
    }
}
