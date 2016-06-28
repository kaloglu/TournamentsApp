package com.kaloglu.tournaments.fragments.edit;


import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.databases.tables.Tournaments;
import com.kaloglu.tournaments.models.TournamentModel;

/**
 * A simple {@link DialogFragment} subclass.
 */
public class TournamentEdit extends BaseEdit {

    private EditText editName;
    private RadioGroup isLeagueRadios, hasRevengeRadios;

    public TournamentEdit() {
        // Required empty public constructor
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.row_tournament_edit;
    }

    @Override
    protected int setTitleResourceID() {
        return R.string.tournamentEdit_title;
    }

    @Override
    protected int setSubmitResourceID() {
        return R.id.tournamentEdit_button_submit;
    }

    @Override
    protected int setCancelResourceID() {
        return R.id.tournamentEdit_button_cancel;
    }

    @Override
    protected void initializeScreen(View view) {
        editName = (EditText) view.findViewById(R.id.tournamentEdit_edit_name);
        isLeagueRadios = (RadioGroup) view.findViewById(R.id.tournamentEdit_radioGroup_isLeague);
        hasRevengeRadios = (RadioGroup) view.findViewById(R.id.tournamentEdit_radioGroup_hasRevenge);

    }

    @Override
    protected void initializeTabBar() {

    }

    @Override
    public void clickSubmitButton() {
        TournamentModel tournamentModel = new TournamentModel();

        tournamentModel.setName(editName.getText().toString());
        tournamentModel.setLeague(getRadiosBoolean(isLeagueRadios, R.string.tournamentEdit_label_league));
        tournamentModel.setHasRevenge(getRadiosBoolean(hasRevengeRadios, R.string.tournamentEdit_label_revenge));

        Tournaments tournaments = Tournaments.getInstance(getContext());
        tournaments.insert(tournamentModel);
    }

}
