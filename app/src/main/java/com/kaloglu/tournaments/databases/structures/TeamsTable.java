package com.kaloglu.tournaments.databases.structures;

import android.content.ContentValues;
import android.content.Context;

import com.kaloglu.tournaments.models.TeamModel;

/**
 * Created by kaloglu on 05/06/16.
 */
public class TeamsTable extends BaseTable<TeamModel> {
    public static final String NAME = "Teams";

    public static final String DROP_SCRIPT = "DROP TABLE IF EXISTS " + NAME + ";";

    public static final String CREATE_SCRIPT = "CREATE TABLE " + NAME + " (" +
            " `" + COLUMNS.ID + "` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
            " `" + COLUMNS.NAME + "` TEXT NOT NULL" +
            " );";

    public static final String INS_DUMMY_DATA = " INSERT INTO `" + NAME + "` " +
            "(" + COLUMNS.ID + " ," + COLUMNS.NAME + ") " +
            " VALUES " +
            " (1,'Bayern Munich')," +
            " (2,'Chelsea')," +
            " (3,'Paris SG')," +
            " (4,'Juventus')," +
            " (5,'Real Madrid')," +
            " (6,'Liverpool');";

    public class COLUMNS extends BaseTable.COLUMNS {
        public static final String ID = "teamId";
        public static final String NAME = "teamName";
    }

    @Override
    ContentValues Data(TeamModel model) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMNS.ID, model.getId());
        contentValues.put(COLUMNS.NAME, model.getName());

        return contentValues;
    }

    @Override
    long Insert(Context context, TeamModel model) {
        return super.Insert(context, model);
    }
}
