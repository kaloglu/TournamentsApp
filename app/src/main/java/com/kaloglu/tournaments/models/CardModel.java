package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class CardModel {
    private long id;
    private long fixtureId;
    private long playerId;
    private int colorType;
    private String carderName;

    public long getId() {
        return id;
    }

    public long getFixtureId() {
        return fixtureId;
    }

    public long getPlayerId() {
        return playerId;
    }


    public int getColorType() {
        return colorType;
    }

    public String getCarderName() {
        return carderName;
    }
}
