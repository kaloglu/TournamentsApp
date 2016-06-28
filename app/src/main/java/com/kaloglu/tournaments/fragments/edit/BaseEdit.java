package com.kaloglu.tournaments.fragments.edit;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link DialogFragment} subclass.
 */
public abstract class BaseEdit extends DialogFragment implements View.OnClickListener {

    private int layoutResourceID, titleResourceID;
    private static int submitResourceId;
    private static int cancelResourceId;

    protected abstract int setLayoutResourceID();

    protected abstract int setTitleResourceID();

    protected abstract int setSubmitResourceID();

    protected abstract int setCancelResourceID();

    protected abstract void initializeScreen(View view);

    protected abstract void initializeTabBar();

    protected abstract void clickSubmitButton();

    protected void clickCancelButton() {
        this.dismiss();
    }

    public BaseEdit() {
        layoutResourceID = setLayoutResourceID();
        titleResourceID = setTitleResourceID();
        submitResourceId = setSubmitResourceID();
        cancelResourceId = setCancelResourceID();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(layoutResourceID, container, false);
        getDialog().setTitle(titleResourceID);

        Button submit = (Button) view.findViewById(submitResourceId);
        Button cancel = (Button) view.findViewById(cancelResourceId);

        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);

        onFragmentCreateView(view);
        return view;
    }

    private void onFragmentCreateView(View view) {

        initializeScreen(view);
        initializeTabBar();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == submitResourceId)
            clickSubmitButton();
        if (v.getId() == cancelResourceId)
            clickCancelButton();
    }

    /**
     * Note: That is for just checking correct one. If the checkone is @checkResourceId return true otherwise return always false;
     *
     * @param radioGroup
     * @param checkResourceId
     * @return
     */
    public boolean getRadiosBoolean(RadioGroup radioGroup, int checkResourceId) {
        RadioButton choosen = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        return ((choosen != null) && choosen.getText().equals(getResources().getString(checkResourceId)));
    }
}
