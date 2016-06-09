package com.kaloglu.tournaments.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.kaloglu.tournaments.databases.structures.PlayersTable;

/**
 * Created by kaloglu on 23/05/16.
 */
public class PlayerModel {
    private long id;
    private String name;
    private long favoriteTeamId;
    private String favoriteTeam;

    public PlayerModel() {
    }

    public PlayerModel(Cursor paramCursor) {
        id = paramCursor.getLong(paramCursor.getColumnIndex(PlayersTable.COLUMNS.ID));
        name = paramCursor.getString(paramCursor.getColumnIndex(PlayersTable.COLUMNS.NAME));
        favoriteTeamId = paramCursor.getInt(paramCursor.getColumnIndex(PlayersTable.COLUMNS.FAVORITETEAMID));
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
