package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class PlayerModel {
    private long playerId;
    private String playerName;
    private long favoriteTeamId;
    private String favoriteTeam;

    public PlayerModel() {
    }

    public long getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public long getFavoriteTeamId() {
        return favoriteTeamId;
    }

    public void setName(String playerName) {
        this.playerName = playerName;
    }

    public void setFavoriteTeam(String favoriteTeam) {
        this.favoriteTeam = favoriteTeam;
    }

    public String getFavoriteTeam() {
        return favoriteTeam;
    }
}
