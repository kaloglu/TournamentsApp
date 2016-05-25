package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class DetailModel {
    private long id;
    private long tournamentId;
    private long playerId;
    private long teamId;

    public long getId() {
        return id;
    }

    public long getTournamentId() {
        return tournamentId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public long getTeamId() {
        return teamId;
    }
}
