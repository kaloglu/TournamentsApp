package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class FixtureModel {
    private long id;
    private long tournamentId;
    private long homePlayerId;
    private int homeScore;
    private int awayScore;
    private long awayPlayerId;

    public long getId() {
        return id;
    }

    public long getTournamentId() {
        return tournamentId;
    }

    public long getHomePlayerId() {
        return homePlayerId;
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
}
