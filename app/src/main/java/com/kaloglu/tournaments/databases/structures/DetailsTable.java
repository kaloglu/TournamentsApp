package com.kaloglu.tournaments.databases.structures;

import android.content.ContentValues;
import android.content.Context;

import com.kaloglu.tournaments.models.DetailModel;

/**
 * Created by kaloglu on 05/06/16.
 */
public class DetailsTable extends BaseTable<DetailModel> {
    public static final String NAME = "Details";

    public static final String DROP_SCRIPT = "DROP TABLE IF EXISTS " + NAME + ";";

    public static final String CREATE_SCRIPT = "CREATE TABLE " + NAME + " (" +
            " `" + COLUMNS.ID + "`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
            " `" + COLUMNS.TOURNAMENTID + "`  INTEGER NOT NULL," +
            " `" + COLUMNS.PLAYERID + "`  INTEGER NOT NULL," +
            " `" + COLUMNS.TEAMID + "`  INTEGER NOT NULL," +
            " FOREIGN KEY(`" + COLUMNS.TOURNAMENTID + "`) REFERENCES `" + TournamentsTable.NAME + "`(`" + TournamentsTable.COLUMNS.ID + "`)," +
            " FOREIGN KEY(`" + COLUMNS.PLAYERID + "`) REFERENCES `" + DetailsTable.NAME + "`(`" + PlayersTable.COLUMNS.ID + "`)," +
            " FOREIGN KEY(`" + COLUMNS.TEAMID + "`) REFERENCES `" + TeamsTable.NAME + "`(`" + TeamsTable.COLUMNS.ID + "`)" +

            " );";

    public static final String INS_DUMMY_DATA = " INSERT INTO `" + NAME + "` " +
            "(" + COLUMNS.ID + " ," + COLUMNS.TOURNAMENTID + ", " + COLUMNS.PLAYERID + ", " + COLUMNS.TEAMID + ") " +
            " VALUES " +
            " (1,1,1,1)," +
            " (2,1,2,1)," +
            " (3,1,3,2)," +
            " (4,1,4,3)," +
            " (5,1,5,4)," +
            " (6,1,6,5);";


    public class COLUMNS extends BaseTable.COLUMNS {
        public static final String ID = "modelId";
        public static final String TOURNAMENTID = "tournamentId";
        public static final String PLAYERID = "playerId";
        public static final String TEAMID = "teamId";

    }

    @Override
    ContentValues Data(DetailModel model) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS.ID, model.getId());
        contentValues.put(COLUMNS.TOURNAMENTID, model.getTournamentId());
        contentValues.put(COLUMNS.PLAYERID, model.getPlayerId());
        contentValues.put(COLUMNS.TEAMID, model.getTeamId());

        return contentValues;
    }

    @Override
    long Insert(Context context, DetailModel model) {
        return super.Insert(context, model);
    }
}
