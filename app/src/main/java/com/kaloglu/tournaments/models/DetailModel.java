package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class DetailModel extends BaseModel{
    private long detailId = Long.MAX_VALUE;
    private long tournamentId = Long.MAX_VALUE;
    private long playerId = Long.MAX_VALUE;
    private long teamId = Long.MAX_VALUE;

    public long getId() {
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

    @Override
    public String getSaveableString() {
        return tournamentId + ", " + playerId + ", " + teamId;
    }
}
