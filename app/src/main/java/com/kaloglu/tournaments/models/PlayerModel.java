package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class PlayerModel {
    private long playerId;
    private String name;
    private long favoriteTeamId;
    private String favoriteTeam;

    public PlayerModel() {
    }

    public long getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public long getFavoriteTeamId() {
        return favoriteTeamId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteTeam(String favoriteTeam) {
        this.favoriteTeam = favoriteTeam;
    }

    public String getFavoriteTeam() {
        return favoriteTeam;
    }
}
