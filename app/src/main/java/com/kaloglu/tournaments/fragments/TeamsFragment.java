package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kaloglu.tournaments.Dummies;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.adapters.TeamsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsFragment extends BaseFragment {

    public TeamsFragment() {
        super.setShowFlyerButton(true);
    }

    @Override
    protected int setResourceID() {
        return R.layout.fragment_teams;
    }

    @Override
    protected void initializeScreen() {
        View rootView = super.getRootView();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.teamList);

        TeamsAdapter teamsAdapter = new TeamsAdapter(getActivity(), Dummies.getDummyTeams());
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

}
