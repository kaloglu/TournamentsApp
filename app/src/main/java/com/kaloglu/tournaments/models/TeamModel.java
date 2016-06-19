package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class TeamModel {
    private long teamId;
    private String teamName;

    public long getId() {
        return teamId;
    }

    public String getName() {
        return teamName;
    }

    public void setName(String teamName) {
        this.teamName = teamName;
    }
}
