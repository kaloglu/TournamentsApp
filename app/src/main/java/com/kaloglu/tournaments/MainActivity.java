package com.kaloglu.tournaments;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kaloglu.tournaments.commons.Commons;
import com.kaloglu.tournaments.fragments.BaseFragment;
import com.kaloglu.tournaments.fragments.FixturesFragment;
import com.kaloglu.tournaments.fragments.PlayersFragment;
import com.kaloglu.tournaments.fragments.ScoreTableFragment;
import com.kaloglu.tournaments.fragments.TeamsFragment;
import com.kaloglu.tournaments.fragments.TournamentsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static BaseFragment activeFragment;
    private static long tournamentId;

    public static void setActiveFragment(BaseFragment activeFragment) {
        MainActivity.activeFragment = activeFragment;
        MainActivity.setTournamentId(activeFragment.getTournamentId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //Set Fragment initiallity
        activeFragment = new TournamentsFragment();
        Commons.getFragment(MainActivity.this,activeFragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_tournament:
                activeFragment = new TournamentsFragment();
                break;
            case R.id.nav_fixture:
                activeFragment = new FixturesFragment();
                activeFragment.setTournamentId(tournamentId);
                break;
            case R.id.nav_player:
                activeFragment = new PlayersFragment();
                break;
            case R.id.nav_score_table:
                activeFragment = new ScoreTableFragment();
                activeFragment.setTournamentId(tournamentId);
                break;
            case R.id.nav_team:
                activeFragment = new TeamsFragment();
                break;
            default:
                break;
        }

        Commons.getFragment(MainActivity.this,activeFragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    public static void setTournamentId(long tournamentId) {
        MainActivity.tournamentId = tournamentId;
    }
}
