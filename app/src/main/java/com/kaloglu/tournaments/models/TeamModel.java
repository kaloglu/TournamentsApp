package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class TeamModel {
    private long playerId;
    private String teamName;

    public long getPlayerId() {
        return playerId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
