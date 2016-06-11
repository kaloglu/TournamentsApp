package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class DetailModel {
    private long detailId;
    private long tournamentId;
    private long playerId;
    private long teamId;

    public long getDetailId() {
        return detailId;
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
