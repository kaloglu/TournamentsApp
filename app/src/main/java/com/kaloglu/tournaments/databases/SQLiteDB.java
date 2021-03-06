package com.kaloglu.tournaments.databases;

/**
 * Created by cihank on 15/03/16.
 */
public class SQLiteDB {
}


/**
 *  Create Scripts...
 */

/*

 CREATE TABLE Tournaments (
 `tournamentId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
 `tournamentName`  TEXT NOT NULL,
 `isLeague`  INTEGER NOT NULL DEFAULT 1,
 `hasRevenge`  INTEGER NOT NULL DEFAULT 1,
 `createTs`  TEXT NOT NULL
 );

 CREATE TABLE Teams (
 `teamId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
 `teamName`  TEXT NOT NULL
 );
 CREATE TABLE Players (
 `playerId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
 `playerName`  TEXT NOT NULL UNIQUE,
 `favoriteTeamId`  INTEGER NOT NULL,
 FOREIGN KEY(`favoriteTeamId`) REFERENCES `Teams`(`teamId`)
 );
 CREATE TABLE Fixtures (
 `fixtureId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
 `tournamentId`  INTEGER NOT NULL,
 `homePlayerId`  INTEGER NOT NULL,
 `homeScore`  INTEGER,
 `awayScore`  INTEGER,
 `awayPlayerId`  INTEGER NOT NULL,
 FOREIGN KEY(`tournamentId`) REFERENCES `Tournaments`(`tournamentId`),
 FOREIGN KEY(`homePlayerId`) REFERENCES `Players`(`playerId`),
 FOREIGN KEY(`awayPlayerId`) REFERENCES `Players`(`playerId`)
 );
 CREATE TABLE Details (
 `detailId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
 `tournamentId`  INTEGER NOT NULL,
 `playerId`  INTEGER NOT NULL,
 `teamId`  INTEGER NOT NULL,
 FOREIGN KEY(`tournamentId`) REFERENCES `Tournaments`(`tournamentId`),
 FOREIGN KEY(`playerId`) REFERENCES `Players`(`playerId`),
 FOREIGN KEY(`teamId`) REFERENCES `Teams`(`teamId`)
 );
 CREATE TABLE Cards (
 `cardId`  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
 `fixtureId`  INTEGER NOT NULL,
 `playerId`  INTEGER NOT NULL,
 `colorType`  INTEGER NOT NULL DEFAULT 2,
 `carderName`  TEXT NOT NULL,
 FOREIGN KEY(`fixtureId`) REFERENCES `Fixtures`(`fixtureId`),
 FOREIGN KEY(`playerId`) REFERENCES `Players`(`playerId`)
 );
*/

 /**
 *      Insert Scripts
 */

 /*

 INSERT INTO `Tournaments` (tournamentId,tournamentName,isLeague,hasRevenge,createTs) VALUES (1,'Turnuva1',1,1,'2016-03-19 00:00');
 INSERT INTO `Teams` (teamId,teamName) VALUES (1,'Bayern Munich'),
 (2,'Chelsea'),
 (3,'Paris SG'),
 (4,'Juventus'),
 (5,'Real Madrid'),
 (6,'Liverpool');
 INSERT INTO `Players` (playerId,playerName,favoriteTeamId) VALUES (1,'kaloglu',1),
 (2,'ceyhun',1),
 (3,'mehmet',2),
 (4,'ersin',3),
 (5,'kadir',4),
 (6,'hüseyin',5);
 INSERT INTO `Details` (detailId,tournamentId,playerId,teamId) VALUES (1,1,1,1),
 (2,1,2,1),
 (3,1,3,2),
 (4,1,4,3),
 (5,1,5,4),
 (6,1,6,5);
 INSERT INTO `Fixtures` (fixtureId,tournamentId,homePlayerId,homeScore,awayScore,awayPlayerId) VALUES (1,1,6,1,6,3),
 (2,1,2,2,0,4),
 (3,1,1,3,1,5),
 (4,1,6,1,0,2),
 (5,1,1,6,2,3),
 (6,1,5,2,2,4),
 (7,1,6,2,1,1),
 (8,1,5,0,1,2),
 (9,1,4,3,5,3),
 (10,1,6,2,4,5),
 (11,1,4,5,5,1),
 (12,1,3,3,2,2),
 (13,1,6,1,3,4),
 (14,1,3,3,1,5),
 (15,1,2,4,3,1),
 (16,1,1,3,2,2),
 (17,1,5,2,2,3),
 (18,1,4,2,1,6),
 (19,1,2,1,4,3),
 (20,1,1,8,2,4),
 (21,1,5,4,0,6),
 (22,1,3,NULL,NULL,4),
 (23,1,2,2,2,5),
 (24,1,1,NULL,NULL,6),
 (25,1,4,NULL,NULL,5),
 (26,1,3,2,1,1),
 (27,1,2,NULL,NULL,6),
 (28,1,5,NULL,NULL,1),
 (29,1,4,NULL,NULL,2),
 (30,1,3,NULL,NULL,6);

 COMMIT;


 */


/**
 *   Queries
 */

/*
    Fixtures Q.

    select
fixtureId as 'Match',
(select tournamentName from Tournaments where Tournaments.tournamentId=Fixtures.tournamentId) as 'Tournament',
(select playerName || ' (' || (select teamName from Teams left outer join Details on (Teams.teamId=Details.teamId) where Details.tournamentId=Fixtures.tournamentId and Details.playerId=Players.playerId) ||  ')'   from Players where Players.playerId=Fixtures.homePlayerId) as 'Home', homeScore,
awayScore, (select playerName || ' (' || (select teamName from Teams left outer join Details on (Teams.teamId=Details.teamId) where Details.tournamentId=Fixtures.tournamentId and Details.playerId=Players.playerId) ||  ')' from Players where Players.playerId=Fixtures.awayPlayerId) as 'away'

from Fixtures --where awayPlayerId=3
 */

/*
    Standings Q.

select
(select Tournaments.tournamentName from Tournaments where Tournaments.tournamentId=Details.tournamentId) as 'Tournament',
(select Players.playerName from Players where Players.playerId=Details.playerId) ||  '(' || (select Teams.teamName from Teams where Teams.teamId=Details.teamId) || ')' as 'Player',
(select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and (Fixtures.homePlayerId=Details.playerId or Fixtures.awayPlayerId=Details.playerId) and homeScore is not null and awayScore is not null) as 'G',
(select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore>awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore>homeScore))) as 'W',
(select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore=awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore=homeScore))) as 'D',
(select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore<awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore<homeScore))) as 'L',
(select sum(case Details.playerId when Fixtures.homePlayerId then homeScore else awayScore end) from Fixtures where Fixtures.tournamentId = Details.tournamentId and (Fixtures.homePlayerId=Details.playerId or Fixtures.awayPlayerId=Details.playerId)) as 'GF',
(select sum(case Details.playerId when Fixtures.awayPlayerId then homeScore else awayScore end) from Fixtures where Fixtures.tournamentId = Details.tournamentId and (Fixtures.homePlayerId=Details.playerId or Fixtures.awayPlayerId=Details.playerId)) as 'GA',
(select sum(case Details.playerId when Fixtures.homePlayerId then homeScore else awayScore end) - sum(case Details.playerId when Fixtures.awayPlayerId then homeScore else awayScore end) from Fixtures where Fixtures.tournamentId = Details.tournamentId and (Fixtures.homePlayerId=Details.playerId or Fixtures.awayPlayerId=Details.playerId)) as 'GD',
((select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore>awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore>homeScore))) *3)  + (select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore=awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore=homeScore)))as 'P'
 from Details

 order by P desc
 */
