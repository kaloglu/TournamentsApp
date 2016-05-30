package com.kaloglu.tournaments.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

/**
 * Created by kaloglu on 23/05/16.
 */
public class PlayerModel {
    private long id;
    private String name;
    private long favoriteTeamId;
    private String favoriteTeam;

    public static final class Columns implements BaseColumns {
        public static final String ID = "playerId";
        public static final String NAME = "playerName";
        public static final String FAVORITETEAMID = "favoriteTeamId";
    }
    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.ID, id);
        contentValues.put(Columns.NAME, name);
        contentValues.put(Columns.FAVORITETEAMID, favoriteTeamId);
        return contentValues;
    }

    public PlayerModel() {
    }
    public PlayerModel(Cursor paramCursor) {
        id = paramCursor.getLong(paramCursor.getColumnIndex(Columns.ID));
        name = paramCursor.getString(paramCursor.getColumnIndex(Columns.NAME));
    }

    public long getId() {
        return id;
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
