package com.kaloglu.tournaments.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.models.FixtureModel;

import java.util.ArrayList;

/**
 * Created by kaloglu on 26/05/16.
 */
public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    ArrayList<FixtureModel> fixtureModelList = new ArrayList<>();

    public FixturesAdapter(Context context, ArrayList<FixtureModel> fixtureModelList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.fixtureModelList = fixtureModelList;
    }

    @Override
    public FixturesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_fixture, parent, false);
        FixturesViewHolder fixturesViewHolder = new FixturesViewHolder(view);
        return fixturesViewHolder;
    }

    @Override
    public void onBindViewHolder(FixturesViewHolder holder, int position) {
        FixtureModel fixtureModel = fixtureModelList.get(position);
        holder.no.setText((position+1)+"");
        holder.homePlayer.setText(fixtureModel.getHomePlayerName());
        holder.awayPlayer.setText(fixtureModel.getAwayPlayerName());
        holder.homeScore.setText(fixtureModel.getHomeScore());
        holder.awayScore.setText(fixtureModel.getAwayScore());
    }

    @Override
    public int getItemCount() {
        return fixtureModelList.size();
    }

    public class FixturesViewHolder extends RecyclerView.ViewHolder {
        TextView no;
        TextView homePlayer;
        TextView awayPlayer;
        EditText homeScore;
        EditText awayScore;

        public FixturesViewHolder(View itemView) {
            super(itemView);

            no = (TextView) itemView.findViewById(R.id.no);
            homePlayer = (TextView) itemView.findViewById(R.id.homeTeamName);
            awayPlayer = (TextView) itemView.findViewById(R.id.awayTeamName);
            homeScore = (EditText) itemView.findViewById(R.id.homeScore);
            awayScore = (EditText) itemView.findViewById(R.id.awayScore);
        }
    }
}
