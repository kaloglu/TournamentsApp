package com.kaloglu.tournaments.databases.structures;

import android.content.ContentValues;
import android.content.Context;

import com.kaloglu.tournaments.models.FixtureModel;

/**
 * Created by kaloglu on 05/06/16.
 */
public class FixturesTable extends BaseTable<FixtureModel> {
    public static final String NAME = "Fixtures";

    public static final String DROP_SCRIPT = "DROP TABLE IF EXISTS " + NAME + ";";

    public static final String CREATE_SCRIPT = "CREATE TABLE " + NAME + " (" +
            " `" + COLUMNS.ID + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
            " `" + COLUMNS.TOURNAMENTID + "` INTEGER NOT NULL," +
            " `" + COLUMNS.HOMEPLAYERID + "` INTEGER NOT NULL," +
            " `" + COLUMNS.HOMESCORE + "` INTEGER," +
            " `" + COLUMNS.AWAYSCORE + "` INTEGER," +
            " `" + COLUMNS.AWAYPLAYERID + "` INTEGER NOT NULL," +
            " FOREIGN KEY(`" + COLUMNS.TOURNAMENTID + "`) REFERENCES `" + TournamentsTable.NAME + "`(`" + TournamentsTable.COLUMNS.ID + "`)," +
            " FOREIGN KEY(`" + COLUMNS.HOMEPLAYERID + "`) REFERENCES `" + PlayersTable.NAME + "`(`" + PlayersTable.COLUMNS.ID + "`)," +
            " FOREIGN KEY(`" + COLUMNS.AWAYPLAYERID + "`) REFERENCES `" + PlayersTable.NAME + "`(`" + PlayersTable.COLUMNS.ID + "`)" +
            " );";

    public static final String INS_DUMMY_DATA = " INSERT INTO `" + NAME + "` " +
            "(" + COLUMNS.ID + " ," + COLUMNS.TOURNAMENTID + ", " + COLUMNS.HOMEPLAYERID + ", " + COLUMNS.HOMESCORE + " ," + COLUMNS.AWAYSCORE + ", " + COLUMNS.AWAYPLAYERID + ") " +
            " VALUES " +
            " (1, 1,6,1,6,3)," +
            " (2,1,2,2,0,4)," +
            " (3,1,1,3,1,5)," +
            " (4,1,6,1,0,2)," +
            " (5,1,1,6,2,3)," +
            " (6,1,5,2,2,4)," +
            " (7,1,6,2,1,1)," +
            " (8,1,5,0,1,2)," +
            " (9,1,4,3,5,3)," +
            " (10,1,6,2,4,5)," +
            " (11,1,4,5,5,1)," +
            " (12,1,3,3,2,2)," +
            " (13,1,6,1,3,4)," +
            " (14,1,3,3,1,5)," +
            " (15,1,2,4,3,1)," +
            " (16,1,1,3,2,2)," +
            " (17,1,5,2,2,3)," +
            " (18,1,4,2,1,6)," +
            " (19,1,2,1,4,3)," +
            " (20,1,1,8,2,4)," +
            " (21,1,5,4,0,6)," +
            " (22,1,3,NULL,NULL,4)," +
            " (23,1,2,2,2,5)," +
            " (24,1,1,NULL,NULL,6)," +
            " (25,1,4,NULL,NULL,5)," +
            " (26,1,3,2,1,1)," +
            " (27,1,2,NULL,NULL,6)," +
            " (28,1,5,NULL,NULL,1)," +
            " (29,1,4,NULL,NULL,2)," +
            " (30,1,3,NULL,NULL,6);";


    protected class COLUMNS extends BaseTable.COLUMNS {
        public static final String ID = "playerId";
        public static final String TOURNAMENTID = "tournamentId";
        public static final String HOMEPLAYERID = "homePlayerId";
        public static final String HOMESCORE = "homeScore";
        public static final String AWAYSCORE = "awayScore";
        public static final String AWAYPLAYERID = "awayPlayerId";
    }

    @Override
    ContentValues Data(FixtureModel model) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS.ID, model.getId());
        contentValues.put(COLUMNS.TOURNAMENTID, model.getTournamentId());
        contentValues.put(COLUMNS.HOMEPLAYERID, model.getHomePlayerId());
        contentValues.put(COLUMNS.HOMESCORE, String.valueOf(model.getHomeScore()));
        contentValues.put(COLUMNS.AWAYSCORE, String.valueOf(model.getAwayScore()));
        contentValues.put(COLUMNS.AWAYPLAYERID, model.getAwayPlayerId());

        return contentValues;
    }

    @Override
    long Insert(Context context, FixtureModel model) {
        return super.Insert(context, model);
    }
}