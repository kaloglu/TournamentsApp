package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class TeamModel extends BaseModel {
    private long teamId = Long.MAX_VALUE;
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

    @Override
    public String getSaveableString() {
        return "'" + teamName + "'";
    }

    @Override
    public String toString() {
        return teamName;
    }
}
