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
//import com.kaloglu.tournaments.databases.tables.Cards;
//import com.kaloglu.tournaments.models.CardModel;
//
//import java.util.ArrayList;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class CardsFragment extends BaseFragment {
//
//    private Cards cards;
//
//    public CardsFragment() {
//        super.setShowFlyerButton(true);
//
//    }
//
//    @Override
//    protected int setResourceID() {
//        return R.layout.fragment_cards;
//    }
//
//    @Override
//    protected void initializeScreen() {
//        View rootView = super.getRootView();
//        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id);
//        if (getActivity() != null) {
//
//            CardsAdapter cardsAdapter = new CardsAdapter(getActivity(), getCardList());
//            recyclerView.setAdapter(cardsAdapter);
//        }
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
////        Log.d("sqlitedaoquery",jsonArray.toString());
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
//    public ArrayList<CardModel> getCardList() {
//        cards = Cards.getInstance(getActivity());
//        return cards.find()
//                .sort("cardId", "DESC")
//                .limit(20)
//                .getArray(new TypeToken<ArrayList<CardModel>>() {
//                });
//    }
//}
