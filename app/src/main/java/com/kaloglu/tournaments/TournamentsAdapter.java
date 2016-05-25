package com.kaloglu.tournaments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.kaloglu.tournaments.models.TournamentModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by kaloglu on 26/05/16.
 */
public class TournamentsAdapter extends RecyclerView.Adapter<TournamentsAdapter.TournamentsViewHolder> {

    private final LayoutInflater inflater;
    List<TournamentModel> tournamentModelList= Collections.emptyList();

    public TournamentsAdapter(Context context, List<TournamentModel> tournamentModelList) {

        inflater = LayoutInflater.from(context);
        this.tournamentModelList = tournamentModelList;
    }

    @Override
    public TournamentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tournament_row, parent, false);
        TournamentsViewHolder tournamentsViewHolder = new TournamentsViewHolder(view);
        return tournamentsViewHolder ;
    }

    @Override
    public void onBindViewHolder(TournamentsViewHolder holder, int position) {
        TournamentModel tournamentModel=tournamentModelList.get(position);
        holder.tournamentName.setText(tournamentModel.getName());
        holder.createTS.setText(String.valueOf(tournamentModel.getCreateTs()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TournamentsViewHolder extends RecyclerView.ViewHolder {
        TextView tournamentName;
        TextView createTS;
        CheckBox isLeague;
        CheckBox hasRevenge;

        public TournamentsViewHolder(View itemView) {
            super(itemView);

            tournamentName = (TextView) itemView.findViewById(R.id.tournamentName);
            createTS = (TextView) itemView.findViewById(R.id.createTS);
            isLeague = (CheckBox) itemView.findViewById(R.id.isLeague);
            hasRevenge = (CheckBox) itemView.findViewById(R.id.hasRevenge);
        }
    }
}
