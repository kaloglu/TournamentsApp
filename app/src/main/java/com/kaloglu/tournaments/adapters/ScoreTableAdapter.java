package com.kaloglu.tournaments.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.models.ScoreTableModel;

import java.util.ArrayList;

/**
 * Created by kaloglu on 26/05/16.
 */
public class ScoreTableAdapter extends RecyclerView.Adapter<ScoreTableAdapter.ScoreTableViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    ArrayList<ScoreTableModel> ScoreTableModelList = new ArrayList<>();

    public ScoreTableAdapter(Context context, ArrayList<ScoreTableModel> ScoreTableModelList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.ScoreTableModelList = ScoreTableModelList;
    }

    @Override
    public ScoreTableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_score_table, parent, false);
        ScoreTableViewHolder scoreTableViewHolder = new ScoreTableViewHolder(view);
        return scoreTableViewHolder;
    }

    @Override
    public void onBindViewHolder(ScoreTableViewHolder holder, int position) {
        ScoreTableModel ScoreTableModel = ScoreTableModelList.get(position);
        holder.no.setText(ScoreTableModel.getNo());
        holder.playerName.setText(ScoreTableModel.getPlayerName());
        holder.played.setText(ScoreTableModel.getPlayed());
        holder.won.setText(ScoreTableModel.getWon());
        holder.draw.setText(ScoreTableModel.getDraw());
        holder.lost.setText(ScoreTableModel.getLost());
        holder.forced.setText(ScoreTableModel.getForced());
        holder.allowed.setText(ScoreTableModel.getAllowed());
        holder.diff.setText(ScoreTableModel.getDiff());
        holder.point.setText(ScoreTableModel.getPoint());
    }

    @Override
    public int getItemCount() {
        return ScoreTableModelList.size();
    }

    public class ScoreTableViewHolder extends RecyclerView.ViewHolder {
        TextView no;
        TextView playerName;
        TextView played;
        TextView won;
        TextView draw;
        TextView lost;
        TextView forced;
        TextView allowed;
        TextView diff;
        TextView point;

        public ScoreTableViewHolder(View itemView) {
            super(itemView);

            no = (TextView) itemView.findViewById(R.id.orderCount);
            playerName = (TextView) itemView.findViewById(R.id.teamName);
            played = (TextView) itemView.findViewById(R.id.played);
            won = (TextView) itemView.findViewById(R.id.won);
            draw = (TextView) itemView.findViewById(R.id.draw);
            lost = (TextView) itemView.findViewById(R.id.lost);
            forced = (TextView) itemView.findViewById(R.id.forced);
            allowed = (TextView) itemView.findViewById(R.id.allowed);
            diff = (TextView) itemView.findViewById(R.id.differential);
            point = (TextView) itemView.findViewById(R.id.point);
        }
    }
}
