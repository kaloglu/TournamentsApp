package com.kaloglu.tournaments.databases.structures;

import android.content.ContentValues;
import android.content.Context;

import com.kaloglu.tournaments.models.TournamentModel;

/**
 * Created by kaloglu on 05/06/16.
 */
public class TournamentsTable extends BaseTable<TournamentModel> {
    public static final String NAME = "Tournaments";

    public static final String DROP_SCRIPT = "DROP TABLE IF EXISTS " + NAME + ";";

    public static final String CREATE_SCRIPT = "CREATE TABLE " + NAME + " (" +
            " `" + COLUMNS.ID + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
            " `" + COLUMNS.NAME + "` TEXT NOT NULL," +
            " `" + COLUMNS.ISLEAGUE + "` INTEGER NOT NULL DEFAULT 1," +
            " `" + COLUMNS.HASREVENGE + "` INTEGER NOT NULL DEFAULT 1," +
            " `" + COLUMNS.CREATETS + "` TEXT NOT NULL" +
            " );";

    public static final String INS_DUMMY_DATA = " INSERT INTO `" + NAME + "` " +
            "(" + COLUMNS.ID + "," + COLUMNS.NAME + "," + COLUMNS.ISLEAGUE + "," + COLUMNS.HASREVENGE + "," + COLUMNS.CREATETS + ") " +
            "VALUES " +
            "(1,'Turnuva1111',1,1,'2016-03-19 00:00');";


    public class COLUMNS extends BaseTable.COLUMNS {
        public static final String ID = "tournamentId";
        public static final String NAME = "tournamentName";
        public static final String ISLEAGUE = "isLeague";
        public static final String HASREVENGE = "hasRevenge";
        public static final String CREATETS = "createTS";
    }

    @Override
    ContentValues Data(TournamentModel model) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS.ID, model.getId());
        contentValues.put(COLUMNS.NAME, model.getName());
        contentValues.put(COLUMNS.ISLEAGUE, model.isLeague());
        contentValues.put(COLUMNS.HASREVENGE, model.hasRevenge());
        contentValues.put(COLUMNS.CREATETS, model.getCreateTS());
        return contentValues;
    }

    @Override
    long Insert(Context context, TournamentModel model) {
        return super.Insert(context, model);
    }
}
