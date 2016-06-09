package com.kaloglu.tournaments.databases.structures;

import android.content.ContentValues;
import android.content.Context;
import android.provider.BaseColumns;

import com.kaloglu.tournaments.models.CardModel;

/**
 * Created by kaloglu on 05/06/16.
 */
public class CardsTable extends BaseTable<CardModel> {
    public static final String NAME = "Cards";

    public static final String DROP_SCRIPT = "DROP TABLE IF EXISTS " + NAME + ";";

    public static final String CREATE_SCRIPT = " CREATE TABLE " + NAME + " (" +
            " `" + COLUMNS.ID + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
            " `" + COLUMNS.FIXTUREID + "` INTEGER NOT NULL," +
            " `" + COLUMNS.PLAYERID + "` INTEGER NOT NULL," +
            " `" + COLUMNS.COLORTYPE + "` INTEGER NOT NULL DEFAULT 2," +
            " `" + COLUMNS.CARDERNAME + "` TEXT NOT NULL," +
            " FOREIGN KEY(`" + COLUMNS.FIXTUREID + "`) REFERENCES `" + FixturesTable.NAME + "`(`" + FixturesTable.COLUMNS.ID + "`)," +
            " FOREIGN KEY(`" + COLUMNS.PLAYERID + "`) REFERENCES `" + PlayersTable.NAME + "`(`" + PlayersTable.COLUMNS.ID + "`)" +
            " );";

    public static final String INS_DUMMY_DATA = " INSERT INTO `" + NAME + "` " +
            "(" + COLUMNS.ID + " ," + COLUMNS.FIXTUREID + ", " + COLUMNS.PLAYERID + ", " + COLUMNS.COLORTYPE + ", " + COLUMNS.CARDERNAME + ") " +
            " VALUES " +
            " (//NO DUMMY DATA);";


    protected static final class COLUMNS implements BaseColumns {
        public static final String ID = "cardId";
        public static final String FIXTUREID = "fixtureId";
        public static final String PLAYERID = "playerId";
        public static final String COLORTYPE = "colorType";
        public static final String CARDERNAME = "carderName";
    }


    @Override
    ContentValues Data(CardModel model) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS.ID, model.getId());
        contentValues.put(COLUMNS.FIXTUREID, model.getFixtureId());
        contentValues.put(COLUMNS.PLAYERID, model.getPlayerId());
        contentValues.put(COLUMNS.COLORTYPE, model.getColorType());
        contentValues.put(COLUMNS.CARDERNAME, model.getCarderName());
        return contentValues;
    }

    @Override
    long Insert(Context context, CardModel model) {
        return super.Insert(context, model);
    }
}
