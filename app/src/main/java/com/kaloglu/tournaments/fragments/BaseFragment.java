package com.kaloglu.tournaments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaloglu.tournaments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    private Context context;
    private int resourceID;
    private View rootView;
    private boolean showFlyerButton=false;
    protected long tournamentId;

    protected abstract int setResourceID();

    protected abstract void initializeScreen();

    protected abstract void initializeTabBar();

    protected abstract void fragmentCreated(Bundle savedInstanceState);

    protected abstract void onFragmentBeingDestroyed();

    protected abstract void onResumeFragment();

    public void onFragmentCreateView() {
        initializeScreen();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        resourceID = setResourceID();

         FloatingActionButton flyerButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        if (showFlyerButton)
            flyerButton.setVisibility(View.VISIBLE);
        else
            flyerButton.setVisibility(View.GONE);

        super.onCreate(savedInstanceState);
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(resourceID, container, false);
        context = rootView.getContext();
        this.rootView = rootView;
        onFragmentCreateView();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fragmentCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        initializeTabBar();
        onResumeFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onFragmentBeingDestroyed();
    }

    public View getRootView() {
        return rootView;
    }

    public void setShowFlyerButton(boolean showFlyerButton) {
        this.showFlyerButton = showFlyerButton;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public long getTournamentId() {
        return tournamentId;
    }
}
