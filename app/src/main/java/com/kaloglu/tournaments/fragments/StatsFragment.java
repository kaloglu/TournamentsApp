//package com.kaloglu.tournaments.fragments;
//
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//
//import com.google.gson.reflect.TypeToken;
//import com.kaloglu.tournaments.R;
//import com.kaloglu.tournaments.adapters.StatsAdapter;
//import com.kaloglu.tournaments.databases.tables.Stats;
//import com.kaloglu.tournaments.models.StatModel;
//
//import java.util.ArrayList;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class StatsFragment extends BaseFragment {
//
//    private Stats stats;
//
//    public StatsFragment() {
//        super.setShowFlyerButton(true);
//    }
//
//    @Override
//    protected int setResourceID() {
//        return R.layout.fragment_players;
//    }
//
//    @Override
//    protected void initializeScreen() {
//        View rootView = super.getRootView();
//        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.playerList);
//
//        StatsAdapter playersAdapter = new StatsAdapter(getActivity(), getStatList());
//        recyclerView.setAdapter(playersAdapter);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//    }
//
//    @Override
//    protected void initializeTabBar() {
//
//    }
//
//    @Override
//    protected void fragmentCreated(Bundle savedInstanceState) {
//
//    }
//
//    @Override
//    protected void onFragmentBeingDestroyed() {
//
//    }
//
//    @Override
//    protected void onResumeFragment() {
//
//    }
//
//    public ArrayList<StatModel> getStatList() {
//        players = Stats.getInstance(getActivity());
//        return players.find()
//                .sort("playerName", "ASC")
//                .getArray(new TypeToken<ArrayList<StatModel>>() {
//                });
//    }
//}
