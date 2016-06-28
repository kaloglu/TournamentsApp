package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.adapters.TournamentsAdapter;
import com.kaloglu.tournaments.databases.tables.Tournaments;
import com.kaloglu.tournaments.fragments.edit.TournamentEdit;
import com.kaloglu.tournaments.models.TournamentModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TournamentsFragment extends BaseFragment {

    public TournamentsFragment() {
        super.setShowFlierButton(true);

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

            TournamentsAdapter tournamentsAdapter = new TournamentsAdapter(getContext(), getTournamentList());
            recyclerView.setAdapter(tournamentsAdapter);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        Log.d("sqlitedaoquery",jsonArray.toString());
    }

    @Override
    public void initFlyerButton() {
        super.initFlyerButton();

        flierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TournamentEdit tournamentEdit = new TournamentEdit();
                tournamentEdit.show(getFragmentManager(), "TournamentEdit");
            }
        });
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

    public ArrayList<TournamentModel> getTournamentList() {
        Tournaments tournaments = Tournaments.getInstance(getContext());
        return tournaments.find()
                .sort("tournamentId", "DESC")
                .limit(20)
                .getArray(new TypeToken<ArrayList<TournamentModel>>() {
                });
    }
}
