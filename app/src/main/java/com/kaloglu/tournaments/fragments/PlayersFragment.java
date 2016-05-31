package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kaloglu.tournaments.Dummies;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.adapters.PlayersAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayersFragment extends BaseFragment {

    public PlayersFragment() {
        super.setShowFlyerButton(true);
    }

    @Override
    protected int setResourceID() {
        return R.layout.fragment_players;
    }

    @Override
    protected void initializeScreen() {
        View rootView = super.getRootView();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.playerList);

        PlayersAdapter playersAdapter = new PlayersAdapter(getActivity(),  Dummies.getDummyPlayers());
        recyclerView.setAdapter(playersAdapter);

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
