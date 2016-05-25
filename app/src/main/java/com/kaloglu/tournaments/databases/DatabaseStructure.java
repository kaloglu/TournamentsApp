package com.kaloglu.tournaments.databases;

import android.content.ContentValues;
import android.provider.BaseColumns;

import com.kaloglu.tournaments.models.CardModel;
import com.kaloglu.tournaments.models.DetailModel;
import com.kaloglu.tournaments.models.FixtureModel;
import com.kaloglu.tournaments.models.PlayerModel;
import com.kaloglu.tournaments.models.TeamModel;
import com.kaloglu.tournaments.models.TournamentModel;

/**
 * Created by kaloglu on 23/05/16.
 */
public class DatabaseStructure {

    protected static final String DBNAME = "Tournaments";
    protected static final int DBVERSION = 1;

    static final String Table_Name_Tournaments = "Tournaments";
    static final String Table_Name_Teams = "Teams";
    static final String Table_Name_Players = "Players";
    static final String Table_Name_Fixtures = "Fixtures";
    static final String Table_Name_Details = "Details";
    static final String Table_Name_Cards = "Cards";

    protected static final String DROP_QUERY = "DROP TABLE IF EXISTS ";
    protected static final String Create_Tables_Script =
            "" +
                    "CREATE TABLE " + Table_Name_Tournaments + " (" +
                    " `tournamentId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    " `tournamentName`  TEXT NOT NULL," +
                    " `isLeague`  INTEGER NOT NULL DEFAULT 1," +
                    " `hasRevenge`  INTEGER NOT NULL DEFAULT 1," +
                    " `createTs`  TEXT NOT NULL" +
                    " );" +

                    "CREATE TABLE " + Table_Name_Teams + " (" +
                    " `teamId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    " `teamName`  TEXT NOT NULL" +
                    " );" +

                    " CREATE TABLE " + Table_Name_Players + " (" +
                    " `playerId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    " `playerName`  TEXT NOT NULL UNIQUE," +
                    " `favoriteTeamId`  INTEGER NOT NULL," +
                    " FOREIGN KEY(`favoriteTeamId`) REFERENCES `" + Table_Name_Teams + "`(`teamId`)" +
                    " );" +

                    " CREATE TABLE " + Table_Name_Fixtures + " (" +
                    " `fixtureId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    " `tournamentId`  INTEGER NOT NULL," +
                    " `homePlayerId`  INTEGER NOT NULL," +
                    " `homeScore`  INTEGER," +
                    " `awayScore`  INTEGER," +
                    " `awayPlayerId`  INTEGER NOT NULL," +
                    " FOREIGN KEY(`tournamentId`) REFERENCES `" + Table_Name_Tournaments + "`(`tournamentId`)," +
                    " FOREIGN KEY(`homePlayerId`) REFERENCES `" + Table_Name_Players + "`(`playerId`)," +
                    " FOREIGN KEY(`awayPlayerId`) REFERENCES `" + Table_Name_Players + "`(`playerId`)" +
                    " );" +

                    " CREATE TABLE " + Table_Name_Details + " (" +
                    " `detailId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    " `tournamentId`  INTEGER NOT NULL," +
                    " `playerId`  INTEGER NOT NULL," +
                    " `teamId`  INTEGER NOT NULL," +
                    " FOREIGN KEY(`tournamentId`) REFERENCES `" + Table_Name_Tournaments + "`(`tournamentId`)," +
                    " FOREIGN KEY(`playerId`) REFERENCES `" + Table_Name_Players + "`(`playerId`)," +
                    " FOREIGN KEY(`teamId`) REFERENCES `" + Table_Name_Teams + "`(`teamId`)" +
                    " );" +

                    " CREATE TABLE " + Table_Name_Cards + " (" +
                    " `cardId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    " `fixtureId`  INTEGER NOT NULL," +
                    " `playerId`  INTEGER NOT NULL," +
                    " `colorType`  INTEGER NOT NULL DEFAULT 2," +
                    " `carderName`  TEXT NOT NULL," +
                    " FOREIGN KEY(`fixtureId`) REFERENCES `" + Table_Name_Fixtures + "`(`fixtureId`)," +
                    " FOREIGN KEY(`playerId`) REFERENCES `" + Table_Name_Players + "`(`playerId`)" +
                    " );" +
                    "" +
                    "" +
                    " INSERT INTO `Tournaments` (tournamentId,tournamentName,isLeague,hasRevenge,createTs) VALUES (1,'Turnuva1',1,1,'2016-03-19 00:00');" +
                    " INSERT INTO `Teams` (teamId,teamName) VALUES (1,'Bayern Munich')," +
                    " (2,'Chelsea')," +
                    " (3,'Paris SG')," +
                    " (4,'Juventus')," +
                    " (5,'Real Madrid')," +
                    " (6,'Liverpool');" +
                    " INSERT INTO `Players` (playerId,playerName,favoriteTeamId) VALUES (1,'kaloglu',1)," +
                    " (2,'ceyhun',1)," +
                    " (3,'mehmet',2)," +
                    " (4,'ersin',3)," +
                    " (5,'kadir',4)," +
                    " (6,'hüseyin',5);" +
                    " INSERT INTO `Details` (detailId,tournamentId,playerId,teamId) VALUES (1,1,1,1)," +
                    " (2,1,2,1)," +
                    " (3,1,3,2)," +
                    " (4,1,4,3)," +
                    " (5,1,5,4)," +
                    " (6,1,6,5);" +
                    " INSERT INTO `Fixtures` (fixtureId,tournamentId,homePlayerId,homeScore,awayScore,awayPlayerId) VALUES (1,1,6,1,6,3)," +
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



    public static final class Table_Teams
            implements BaseColumns {
        public static final String ID = "teamId";
        public static final String NAME = "teamName";
    }

    public static final class Table_Players
            implements BaseColumns {
        public static final String ID = "playerId";
        public static final String NAME = "playerName";
        public static final String FAVORITETEAMID = "favoriteTeamId";
    }

    public static final class Table_Fixtures
            implements BaseColumns {
        public static final String ID = "fixtureId";
        public static final String TOURNAMENTID = "tournamentId";
        public static final String HOMEPLAYERID = "homePlayerId";
        public static final String HOMESCORE = "homeScore";
        public static final String AWAYSCORE = "awayScore";
        public static final String AWAYPLAYERID = "awayPlayerId";
    }

    public static final class Table_Details
            implements BaseColumns {
        public static final String ID = "detailId";
        public static final String TOURNAMENTID = "tournamentId";
        public static final String PLAYERID = "playerId";
        public static final String TEAMID = "teamId";
    }

    public static final class Table_Cards
            implements BaseColumns {
        public static final String ID = "cardId";
        public static final String FIXTUREID = "fixtureId";
        public static final String PLAYERID = "playerId";
        public static final String COLORTYPE = "colorType";
        public static final String CARDERNAME = "carderName";
    }



    static ContentValues TeamsData(TeamModel team) {
        ContentValues teamContent = new ContentValues();
        teamContent.put(Table_Teams.ID, team.getId());
        teamContent.put(Table_Teams.NAME, team.getName());
        return teamContent;
    }

    static ContentValues PlayersData(PlayerModel player) {
        ContentValues playerContent = new ContentValues();
        playerContent.put(Table_Players.ID, player.getId());
        playerContent.put(Table_Players.NAME, player.getName());
        playerContent.put(Table_Players.FAVORITETEAMID, player.getFavoriteTeamId());
        return playerContent;
    }

    static ContentValues FixturesData(FixtureModel fixture) {
        ContentValues fixtureContent = new ContentValues();
        fixtureContent.put(Table_Fixtures.ID, fixture.getId());
        fixtureContent.put(Table_Fixtures.TOURNAMENTID, fixture.getTournamentId());
        fixtureContent.put(Table_Fixtures.HOMEPLAYERID, fixture.getHomePlayerId());
        fixtureContent.put(Table_Fixtures.HOMESCORE, String.valueOf(fixture.getHomeScore()));
        fixtureContent.put(Table_Fixtures.AWAYSCORE, String.valueOf(fixture.getAwayScore()));
        fixtureContent.put(Table_Fixtures.AWAYPLAYERID, fixture.getAwayPlayerId());
        return fixtureContent;
    }

    static ContentValues DetailsData(DetailModel detail) {
        ContentValues detailContent = new ContentValues();
        detailContent.put(Table_Details.ID, detail.getId());
        detailContent.put(Table_Details.TOURNAMENTID, detail.getTournamentId());
        detailContent.put(Table_Details.PLAYERID, detail.getPlayerId());
        detailContent.put(Table_Details.TEAMID, detail.getTeamId());
        return detailContent;
    }

    static ContentValues CardsData(CardModel card) {
        ContentValues cardContent = new ContentValues();
        cardContent.put(Table_Cards.ID, card.getId());
        cardContent.put(Table_Cards.FIXTUREID, card.getFixtureId());
        cardContent.put(Table_Cards.PLAYERID, card.getPlayerId());
        cardContent.put(Table_Cards.COLORTYPE, String.valueOf(card.getColorType()));
        cardContent.put(Table_Cards.CARDERNAME, card.getCarderName());
        return cardContent;
    }

}
