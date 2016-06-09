package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.adapters.TournamentsAdapter;
import com.kaloglu.tournaments.databases.DBHelper;
import com.kaloglu.tournaments.databases.tables.Tournaments;
import com.kaloglu.tournaments.models.TournamentModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TournamentsFragment extends BaseFragment {

    private Tournaments tournaments;

    public TournamentsFragment() {
        super.setShowFlyerButton(true);
    }

    @Override
    protected int setResourceID() {
        return R.layout.fragment_tournaments;
    }

    @Override
    protected void initializeScreen() {
        View rootView = super.getRootView();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.tournamentList);

        TournamentsAdapter tournamentsAdapter = new TournamentsAdapter(getActivity(), new DBHelper(getContext()).getTournamentsFromDB());
        recyclerView.setAdapter(tournamentsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tournaments = Tournaments.getInstance(getContext());
        TournamentModel tournamentModel = tournaments.find()
                .sort("tournamentId","DESC")
                .limit(1)
                .execute()
                .json()
                .getObject(TournamentModel.class);
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

}
