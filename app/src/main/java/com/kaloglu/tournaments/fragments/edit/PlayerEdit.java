package com.kaloglu.tournaments.fragments.edit;


import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.gson.reflect.TypeToken;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.databases.tables.Players;
import com.kaloglu.tournaments.databases.tables.Teams;
import com.kaloglu.tournaments.models.PlayerModel;
import com.kaloglu.tournaments.models.TeamModel;

import java.util.ArrayList;

/**
 * A simple {@link DialogFragment} subclass.
 */
public class PlayerEdit extends BaseEdit implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, View.OnFocusChangeListener {

    private EditText editName;
    private AutoCompleteTextView autoCompleteFavoriteTeam;
    private TeamModel favoriteTeamModel;

    public PlayerEdit() {
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.row_player_edit;
    }

    @Override
    protected int setTitleResourceID() {
        return R.string.playerEdit_title;
    }

    @Override
    protected int setSubmitResourceID() {
        return R.id.playerEdit_button_submit;
    }

    @Override
    protected int setCancelResourceID() {
        return R.id.playerEdit_button_cancel;
    }

    @Override
    protected void initializeScreen(View view) {
        editName = (EditText) view.findViewById(R.id.playerEdit_edit_name);

        autoCompleteFavoriteTeam = (AutoCompleteTextView) view.findViewById(R.id.playerEdit_autoComplete_favoriteTeam);
        autoCompleteFavoriteTeam.setOnFocusChangeListener(this);
        autoCompleteFavoriteTeam.setOnItemClickListener(this);
        autoCompleteFavoriteTeam.setOnItemSelectedListener(this);

        ArrayList<TeamModel> teamModels = Teams.getInstance(getContext()).find().getArray(new TypeToken<ArrayList<TeamModel>>(){});
        ArrayAdapter<TeamModel> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, teamModels);
        autoCompleteFavoriteTeam.setAdapter(adapter);
    }


    @Override
    protected void initializeTabBar() {

    }

    @Override
    public void clickSubmitButton() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setName(editName.getText().toString());
        if (!isNull(favoriteTeamModel.getId())) {
            playerModel.setFavoriteTeamId(favoriteTeamModel.getId());
            playerModel.setFavoriteTeam(favoriteTeamModel.getName());
        } else playerModel.setFavoriteTeam(getContext().getString(R.string.not_selected));

        Players.getInstance(getContext()).insert(playerModel);

        super.clickSubmitButton();
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String currentTeamName = autoCompleteFavoriteTeam.getText().toString();
        if (!currentTeamName.isEmpty() && (favoriteTeamModel == null || !currentTeamName.equals(favoriteTeamModel.getName()))) {
            favoriteTeamModel = new TeamModel();
            favoriteTeamModel.setName(currentTeamName);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ArrayAdapter adapter = (ArrayAdapter) autoCompleteFavoriteTeam.getAdapter();
        if (adapter != null) favoriteTeamModel = (TeamModel) adapter.getItem(position);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String currentTeamName = autoCompleteFavoriteTeam.getText().toString();
        if (!currentTeamName.isEmpty() && (favoriteTeamModel == null || !currentTeamName.equals(favoriteTeamModel.getName()))) {
            favoriteTeamModel = new TeamModel();
            favoriteTeamModel.setName(currentTeamName);
        }
    }
}
