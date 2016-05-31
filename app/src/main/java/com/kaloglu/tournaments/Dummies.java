package com.kaloglu.tournaments;

import com.kaloglu.tournaments.models.FixtureModel;
import com.kaloglu.tournaments.models.PlayerModel;
import com.kaloglu.tournaments.models.ScoreTableModel;
import com.kaloglu.tournaments.models.TeamModel;
import com.kaloglu.tournaments.models.TournamentModel;

import java.util.ArrayList;

/**
 * Created by kaloglu on 29/05/16.
 */
public class Dummies {

    public static ArrayList<TournamentModel> getDummyTournaments() {
        ArrayList<TournamentModel> tournamentDatas = new ArrayList<>();
        String[] tournaments = {"Turnuva 1", "Turnuva 2", " Turnuva 3"};
        String[] createTS = {"-2107659420", "-2107659420", "-2107659420"};
        boolean[] isLeague = {true, false, true};
        boolean[] hasRevenge = {false, false, true};

        for (int i = 0; i < tournaments.length; i++) {
            TournamentModel tournamentModel = new TournamentModel();
            tournamentModel.setName(tournaments[i]);
            tournamentModel.setCreateTS(Long.parseLong(createTS[i]));
            tournamentModel.setLeague(isLeague[i]);
            tournamentModel.setHasRevenge(hasRevenge[i]);
            tournamentDatas.add(tournamentModel);
        }

        return tournamentDatas;
    }

    public static ArrayList<PlayerModel> getDummyPlayers() {
        ArrayList<PlayerModel> playerDatas = new ArrayList<>();
        String[] players = {"Player 1", "Player 2", " Player 3"};
        String[] favoriteTeams = {"Team 1", "Team 2", "Team 3"};

        for (int i = 0; i < players.length; i++) {
            PlayerModel playerModel = new PlayerModel();
            playerModel.setName(players[i]);
            playerModel.setFavoriteTeam(favoriteTeams[1]);
            playerDatas.add(playerModel);
        }

        return playerDatas;
    }

    public static ArrayList<TeamModel> getDummyTeams() {
        ArrayList<TeamModel> teamDatas = new ArrayList<>();
        String[] teams = {"Team 1", "Team 2", " Team 3"};

        for (int i = 0; i < teams.length; i++) {
            TeamModel teamModel = new TeamModel();
            teamModel.setName(teams[i]);
            teamDatas.add(teamModel);
        }

        return teamDatas;
    }

    public static ArrayList<FixtureModel> getDummyFixtures() {
        ArrayList<FixtureModel> fixtureModels = new ArrayList<>();
        String[] tournaments = {"Turnuva 1", "Turnuva 1", " Turnuva 1","Turnuva 1", "Turnuva 1", " Turnuva 1"};
        String[] homePlayers = {"Player 1", "Player 1", "Player 2", "Player 3", "Player 3", "Player 2"};
        String[] awayPlayers = {"Player 2", "Player 3", "Player 3", "Player 1", "Player 2", "Player 1"};
        String[] homeScores = {"1", "1", "2", "3", "3", "2"};
        String[] awayScores = {"2", "3", "3", "1", "2", "1"};

        for (int i = 0; i < homePlayers.length; i++) {
            FixtureModel fixtureModel = new FixtureModel();
            fixtureModel.setTournamentName(tournaments[i]);
            fixtureModel.setHomePlayerName(homePlayers[i]);
            fixtureModel.setAwayPlayerName(awayPlayers[i]);
            fixtureModel.setHomeScore(homeScores[i]);
            fixtureModel.setAwayScore(awayScores[i]);
            fixtureModels.add(fixtureModel);
        }

        return fixtureModels;
    }

    public static ArrayList<ScoreTableModel> getDummyScoreTable() {
        ArrayList<ScoreTableModel> standingDatas = new ArrayList<>();
        String[] no = {"1.", "2.", "3."};
        String[] playerNames = {"Player 3", "Player 2", "Player 1"};
        String[] played = {"4", "4", "4"};
        String[] won = {"4", "2", "0"};
        String[] draw = {"0", "0", "0"};
        String[] loss = {"0", "2", "4"};
        String[] forced = {"12", "8", "4"};
        String[] allowed = {"6", "8", "10"};
        String[] diff = {"6", "0", "-4"};
        String[] point = {"12", "6", "0"};
        for (int i = 0; i < playerNames.length; i++) {
            ScoreTableModel scoreTableModel = new ScoreTableModel();
            scoreTableModel.setNo(no[i]);
            scoreTableModel.setPlayerName(playerNames[i]);
            scoreTableModel.setPlayed(played[i]);
            scoreTableModel.setWon(won[i]);
            scoreTableModel.setDraw(draw[i]);
            scoreTableModel.setLost(loss[i]);
            scoreTableModel.setForced(forced[i]);
            scoreTableModel.setAllowed(allowed[i]);
            scoreTableModel.setDiff(diff[i]);
            scoreTableModel.setPoint(point[i]);
            standingDatas.add(scoreTableModel);
        }

        return standingDatas;
    }
}
