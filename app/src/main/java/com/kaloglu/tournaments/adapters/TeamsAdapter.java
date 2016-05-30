package com.kaloglu.tournaments.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.models.TeamModel;

import java.util.ArrayList;

/**
 * Created by kaloglu on 26/05/16.
 */
public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    ArrayList<TeamModel> teamModelList = new ArrayList<>();

    public TeamsAdapter(Context context, ArrayList<TeamModel> teamModelList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.teamModelList = teamModelList;
    }

    @Override
    public TeamsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_team, parent, false);
        TeamsViewHolder teamsViewHolder = new TeamsViewHolder(view);
        return teamsViewHolder;
    }

    @Override
    public void onBindViewHolder(TeamsViewHolder holder, int position) {
        TeamModel teamModel = teamModelList.get(position);
        holder.teamName.setText(teamModel.getName());
    }

    @Override
    public int getItemCount() {
        return teamModelList.size();
    }

    public class TeamsViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;

        public TeamsViewHolder(View itemView) {
            super(itemView);

            teamName = (TextView) itemView.findViewById(R.id.teamName);
        }
    }
}
