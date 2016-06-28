package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.adapters.ScoreTableAdapter;
import com.kaloglu.tournaments.databases.dao.SqliteDAO;
import com.kaloglu.tournaments.models.ScoreTableModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreTableFragment extends BaseFragment {

    public ScoreTableFragment() {
        super.setShowFlierButton(false);

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_tournaments;
    }

    @Override
    protected void initializeScreen() {
        View rootView = super.getRootView();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.tournamentList);
        if (getActivity() != null) {

            ScoreTableAdapter scoreTableAdapter = new ScoreTableAdapter(getActivity(), getScoreTableList());
            recyclerView.setAdapter(scoreTableAdapter);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        Log.d("sqlitedaoquery",jsonArray.toString());
    }

    @Override
    protected void initializeTabBar() {

    }

    @Override
    protected void fragmentCreated(Bundle savedInstanceState) {

    }

    @Override
    protected void onFragmentBeingDestroyed() {

    }

    @Override
    protected void onResumeFragment() {

    }

    public ArrayList<ScoreTableModel> getScoreTableList() {
        SqliteDAO scoreTableDatas = new SqliteDAO(getContext()) {
            @Override
            protected void initTable() {

            }

            @Override
            public String getCreateScript() {
                return null;
            }
        };
        String sqlQuery = "select " +
                "(select Players.playerName from Players where Players.playerId=Details.playerId) ||  '(' || (select Teams.teamName from Teams where Teams.teamId=Details.teamId) || ')' as 'playerName', " +
                "(select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and (Fixtures.homePlayerId=Details.playerId or Fixtures.awayPlayerId=Details.playerId) and homeScore is not null and awayScore is not null) as 'played', " +
                "(select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore>awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore>homeScore))) as 'won', " +
                "(select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore=awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore=homeScore))) as 'draw', " +
                "(select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore<awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore<homeScore))) as 'lost', " +
                "(select sum(case Details.playerId when Fixtures.homePlayerId then homeScore else awayScore end) from Fixtures where Fixtures.tournamentId = Details.tournamentId and (Fixtures.homePlayerId=Details.playerId or Fixtures.awayPlayerId=Details.playerId)) as 'forced', " +
                "(select sum(case Details.playerId when Fixtures.awayPlayerId then homeScore else awayScore end) from Fixtures where Fixtures.tournamentId = Details.tournamentId and (Fixtures.homePlayerId=Details.playerId or Fixtures.awayPlayerId=Details.playerId)) as 'allowed', " +
                "(select sum(case Details.playerId when Fixtures.homePlayerId then homeScore else awayScore end) - sum(case Details.playerId when Fixtures.awayPlayerId then homeScore else awayScore end) from Fixtures where Fixtures.tournamentId = Details.tournamentId and (Fixtures.homePlayerId=Details.playerId or Fixtures.awayPlayerId=Details.playerId)) as 'diff', " +
                "((select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore>awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore>homeScore))) *3)  + (select count(Fixtures.fixtureId) from Fixtures where Fixtures.tournamentId = Details.tournamentId and ((Fixtures.homePlayerId=Details.playerId and homeScore=awayScore) or (Fixtures.awayPlayerId=Details.playerId and awayScore=homeScore)))as 'points' " +
                " from Details order by points desc";

        return scoreTableDatas.select(sqlQuery).getArray(new TypeToken<ArrayList<ScoreTableModel>>() {
        });
    }
}
