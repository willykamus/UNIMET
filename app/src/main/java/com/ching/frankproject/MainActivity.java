package com.ching.frankproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ching.frankproject.fragments.FlujogramaFragment;
import com.ching.frankproject.fragments.HomeFragment;
import com.ching.frankproject.fragments.MessagesListFragment;
import com.ching.frankproject.fragments.ScheduleFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String MESSAGES_FRAGMENT_TAG = "MESSAGE_FRAGMENT";
    private static final String SCHEDULE_FRAGMENT_TAG = "SCHEDULE_FRAGMENT";
    private static final String FLUJOGRAMA_FRAGMENT_TAG = "FLUJOGRAMA_FRAGMENT";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        if(savedInstanceState==null){

            HomeFragment homeFragment = new HomeFragment();

            Context context = getApplicationContext();

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,homeFragment);
            fragmentTransaction.commit();

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.messages:
                //Toast.makeText(this,"This launch the messages feature",Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_bottom,R.anim.exit_to_bottom,R.anim.enter_from_bottom,R.anim.exit_to_bottom);
                fragmentTransaction.add(R.id.fragment_container, new MessagesListFragment(),MESSAGES_FRAGMENT_TAG).commit();
                fragmentTransaction.addToBackStack(null);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    private void initialize() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_key),Context.MODE_PRIVATE);
        String name = preferences.getString("firstName","Not found!");
        String carnet = preferences.getString("carnet","Not found!");

        navigationView = findViewById(R.id.nav_menu);

        View navView = navigationView.getHeaderView(0);

        TextView nameTV = navView.findViewById(R.id.nameTV);
        TextView carnetTV = navView.findViewById(R.id.carnetTV);

        nameTV.setText(name);
        carnetTV.setText("Carnet: #"+carnet);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_bottom,R.anim.enter_from_left,R.anim.exit_to_bottom);

                switch (menuItem.getItemId()) {

                    case R.id.nav_horario:
                        toolbar.setTitle("Horario");
//                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.replace(R.id.fragment_container, new ScheduleFragment(),SCHEDULE_FRAGMENT_TAG).commit();
                        break;

                    case R.id.nav_flujograma:
                        toolbar.setTitle("Flujograma");
//                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.replace(R.id.fragment_container, new FlujogramaFragment(),FLUJOGRAMA_FRAGMENT_TAG).commit();
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(getApplicationContext(),"Logging out",Toast.LENGTH_LONG).show();
                        break;

                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        drawerLayout = findViewById(R.id.main_drawer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
