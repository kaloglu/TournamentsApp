package com.kaloglu.tournaments.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.models.PlayerModel;

import java.util.ArrayList;

/**
 * Created by kaloglu on 26/05/16.
 */
public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder> {

    private final LayoutInflater inflater;
    ArrayList<PlayerModel> playerModelList = new ArrayList<>();

    public PlayersAdapter(Context context, ArrayList<PlayerModel> playerModelList) {
        inflater = LayoutInflater.from(context);
        this.playerModelList = playerModelList;
    }

    @Override
    public PlayersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_player, parent, false);
        return new PlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayersViewHolder holder, int position) {
        PlayerModel playerModel = playerModelList.get(position);
        holder.playerName.setText(playerModel.getName());
        holder.favoriteTeamName.setText(playerModel.getFavoriteTeam());
    }

    @Override
    public int getItemCount() {
        return playerModelList.size();
    }

    public class PlayersViewHolder extends RecyclerView.ViewHolder {
        TextView playerName;
        TextView favoriteTeamName;

        public PlayersViewHolder(View itemView) {
            super(itemView);

            playerName = (TextView) itemView.findViewById(R.id.playerName);
            favoriteTeamName = (TextView) itemView.findViewById(R.id.favoriteTeam);
        }
    }
}
