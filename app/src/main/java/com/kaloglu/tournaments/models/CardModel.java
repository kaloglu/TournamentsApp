package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 23/05/16.
 */
public class CardModel extends BaseModel {
    private long cardId = Long.MAX_VALUE;
    private long fixtureId = Long.MAX_VALUE;
    private long playerId = Long.MAX_VALUE;
    private int colorType;
    private String carderName;

    public long getCardId() {
        return cardId;
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

    @Override
    public String getSaveableString() {
        return fixtureId + ", " + playerId + ", " + colorType + ", '" + carderName + "'";
    }
}
