package com.kaloglu.tournaments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.TournamentsAdapter;
import com.kaloglu.tournaments.models.TournamentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TournamentsFragment extends BaseFragment {


    private View rootView;
    private RecyclerView recyclerView;

    public TournamentsFragment() {
        // Required empty public constructor
    }


    @Override
    protected int setResourceID() {
        return R.layout.fragment_tournaments;
    }

    @Override
    protected void initializeScreen() {
        rootView = super.getRootView();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.tournamentList);

        adapter = new TournamentsAdapter(this.getDummyData(),);
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

    public static void getDummyData() {
        List<TournamentModel> tournamentDatas = new ArrayList<>();
        String[] tournaments = {"turnuva 1", "turnuva 2", " turnuva 3"};
        String[] createTS = {"11111111", "22222222", "33333333"};
        boolean[] isLeague = {true, false, true};
        boolean[] hasRevenge = {false, false, true};

        for (int i = 0; i<tournaments.length; i++) {
            TournamentModel tournamentModel= new TournamentModel();
            tournamentModel.setTournamentName(tournaments[i]);
            tournamentModel.setCreateTS(tournaments[i]);
            tournamentDatas.add(tournamentModel);
        }
    }

}
