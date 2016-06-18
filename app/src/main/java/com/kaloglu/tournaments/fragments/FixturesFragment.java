package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.adapters.FixturesAdapter;
import com.kaloglu.tournaments.databases.tables.Fixtures;
import com.kaloglu.tournaments.models.FixtureModel;
import com.kaloglu.tournaments.models.ScoreTableModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FixturesFragment extends BaseFragment {

    private Fixtures fixtures;

    public FixturesFragment() {
        super.setShowFlyerButton(true);
    }

    @Override
    protected int setResourceID() {
        return R.layout.fragment_fixtures;
    }

    @Override
    protected void initializeScreen() {
        View rootView = super.getRootView();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fixtureList);

        FixturesAdapter fixturesAdapter = new FixturesAdapter(getActivity(), getFixtureList());
        recyclerView.setAdapter(fixturesAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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

    public ArrayList<FixtureModel> getFixtureList() {
        fixtures = Fixtures.getInstance(getActivity());
        String sqlQuery="select "+
                "fixtureId, " +
                "homePlayerId, " +
                "(select playerName || ' (' || (select teamName from Teams left outer join Details on (Teams.teamId=Details.teamId) where Details.tournamentId=Fixtures.tournamentId and Details.playerId=Players.playerId) ||  ')'   from Players where Players.playerId=Fixtures.homePlayerId) as 'homePlayerName', " +
                "homeScore,"+
                "awayScore, " +
                "awayPlayerId, " +
                "(select playerName || ' (' || (select teamName from Teams left outer join Details on (Teams.teamId=Details.teamId) where Details.tournamentId=Fixtures.tournamentId and Details.playerId=Players.playerId) ||  ')' from Players where Players.playerId=Fixtures.awayPlayerId) as 'awayPlayerName'"+

        "from Fixtures";
        return fixtures.select(sqlQuery).getArray(new TypeToken<ArrayList<FixtureModel>>() {});
    }
}
