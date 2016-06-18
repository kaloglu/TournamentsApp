package com.kaloglu.tournaments.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.models.TournamentModel;

import java.util.ArrayList;

/**
 * Created by kaloglu on 26/05/16.
 */
public class TournamentsAdapter extends RecyclerView.Adapter<TournamentsAdapter.TournamentsViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    ArrayList<TournamentModel> tournamentModelList = new ArrayList<>();

    public TournamentsAdapter(Context context, ArrayList<TournamentModel> tournamentModelList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.tournamentModelList = tournamentModelList;
    }

    @Override
    public TournamentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_tournament, parent, false);
        return new TournamentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TournamentsViewHolder holder, int position) {
        TournamentModel tournamentModel = tournamentModelList.get(position);
        holder.tournamentName.setText(tournamentModel.getName());
        holder.createTS.setText(DateUtils.getRelativeDateTimeString(context, tournamentModel.getCreateTS(), DateUtils.SECOND_IN_MILLIS, DateUtils.YEAR_IN_MILLIS, 0));
        if (tournamentModel.isLeague())
            holder.isLeague.setImageResource(0);

        if (tournamentModel.hasRevenge())
            holder.hasRevenge.setImageResource(0);
    }

    @Override
    public int getItemCount() {
        return tournamentModelList.size();
    }

    public class TournamentsViewHolder extends RecyclerView.ViewHolder {
        TextView tournamentName;
        TextView createTS;
        ImageView isLeague;
        ImageView hasRevenge;

        public TournamentsViewHolder(View itemView) {
            super(itemView);

            tournamentName = (TextView) itemView.findViewById(R.id.tournamentName);
            createTS = (TextView) itemView.findViewById(R.id.createTS);
            isLeague = (ImageView) itemView.findViewById(R.id.isLeagueIcon);
            hasRevenge = (ImageView) itemView.findViewById(R.id.hasRevenegeIcon);
        }
    }
}
