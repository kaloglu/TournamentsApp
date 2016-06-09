package com.kaloglu.tournaments.databases.structures;

import android.content.ContentValues;
import android.content.Context;

import com.kaloglu.tournaments.models.PlayerModel;

/**
 * Created by kaloglu on 05/06/16.
 */
public class PlayersTable extends BaseTable<PlayerModel> {
    public static final String NAME = "Players";

    public static final String DROP_SCRIPT = "DROP TABLE IF EXISTS " + NAME + ";";

    public static final String CREATE_SCRIPT = "CREATE TABLE " + NAME + " (" +
            " `" + COLUMNS.ID + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
            " `" + COLUMNS.NAME + "` TEXT NOT NULL," +
            " `" + COLUMNS.FAVORITETEAMID + "` INTEGER NOT NULL" +
            " );";

    public static final String INS_DUMMY_DATA = " INSERT INTO `" + NAME + "` " +
            "(" + COLUMNS.ID + " ," + COLUMNS.NAME + ", " + COLUMNS.FAVORITETEAMID + ") " +
            " VALUES " +
            " (1,'kaloglu',1)," +
            " (2,'ceyhun',1)," +
            " (3,'mehmet',2)," +
            " (4,'ersin',3)," +
            " (5,'kadir',4)," +
            " (6,'hüseyin',5);";


    public class COLUMNS extends BaseTable.COLUMNS {
        public static final String ID = "playerId";
        public static final String NAME = "playerName";
        public static final String FAVORITETEAMID = "favoriteTeamId";
    }

    @Override
    ContentValues Data(PlayerModel model) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS.ID, model.getId());
        contentValues.put(COLUMNS.NAME, model.getName());
        contentValues.put(COLUMNS.FAVORITETEAMID, model.getFavoriteTeamId());
        return contentValues;
    }

    @Override
    long Insert(Context context, PlayerModel model) {
        return super.Insert(context, model);
    }
}
