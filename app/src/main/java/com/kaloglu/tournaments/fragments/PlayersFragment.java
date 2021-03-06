package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.adapters.PlayersAdapter;
import com.kaloglu.tournaments.databases.tables.Players;
import com.kaloglu.tournaments.fragments.edit.PlayerEdit;
import com.kaloglu.tournaments.fragments.edit.TournamentEdit;
import com.kaloglu.tournaments.models.PlayerModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayersFragment extends BaseFragment {

    private Players players;

    public PlayersFragment() {
        super.setShowFlierButton(true);
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_players;
    }

    @Override
    protected void initializeScreen() {
        View rootView = super.getRootView();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.playerList);

        PlayersAdapter playersAdapter = new PlayersAdapter(getActivity(), getPlayerList());
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

    @Override
    public void initFlyerButton() {
        super.initFlyerButton();

        flierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerEdit playerEdit = new PlayerEdit();
                playerEdit.show(getFragmentManager(), "PlayerEdit");
            }
        });
    }

    public ArrayList<PlayerModel> getPlayerList() {
        players = Players.getInstance(getActivity());
        return players.find().sort("playerName", "ASC").getArray(new TypeToken<ArrayList<PlayerModel>>() {
        });
    }
}
