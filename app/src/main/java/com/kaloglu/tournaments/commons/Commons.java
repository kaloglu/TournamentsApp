package com.kaloglu.tournaments.commons;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.kaloglu.tournaments.MainActivity;
import com.kaloglu.tournaments.R;
import com.kaloglu.tournaments.fragments.BaseFragment;

/**
 * Created by kaloglu on 20/06/16.
 */
public class Commons {
    public static void getFragment(FragmentActivity context, BaseFragment fragment) {
        MainActivity.setActiveFragment(fragment);
        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }
}
