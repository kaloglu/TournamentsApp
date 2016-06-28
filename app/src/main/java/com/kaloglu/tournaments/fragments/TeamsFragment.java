package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.adapters.TeamsAdapter;
import com.kaloglu.tournaments.databases.tables.Teams;
import com.kaloglu.tournaments.models.TeamModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsFragment extends BaseFragment {

    private Teams teams;

    public TeamsFragment() {
        super.setShowFlierButton(true);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_teams;
    }

    @Override
    protected void initializeScreen() {
        View rootView = super.getRootView();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.teamList);

        TeamsAdapter teamsAdapter = new TeamsAdapter(getActivity(), getTeamList());
        recyclerView.setAdapter(teamsAdapter);

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

    public ArrayList<TeamModel> getTeamList() {
        teams = Teams.getInstance(getActivity());
        return teams.find()
                .sort("teamName", "ASC")
                .getArray(new TypeToken<ArrayList<TeamModel>>() {
                });
    }
}
