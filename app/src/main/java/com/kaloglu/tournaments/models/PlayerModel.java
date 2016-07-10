package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class PlayerModel extends BaseModel {
    private long playerId = Long.MAX_VALUE;
    private String playerName;
    private long favoriteTeamId = Long.MAX_VALUE;
    private String favoriteTeam;

    public PlayerModel() {
    }

    public long getId() {
        return playerId;
    }

    public String getName() {
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

    public void setFavoriteTeamId(long favoriteTeamId) {
        this.favoriteTeamId = favoriteTeamId;
    }

    @Override
    public String getSaveableString() {
        return "'" + playerName + "', " + favoriteTeamId + "";
    }

}
