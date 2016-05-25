package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class PlayerModel {
    private long id;
    private String name;
    private long favoriteTeamId;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getFavoriteTeamId() {
        return favoriteTeamId;
    }
}
