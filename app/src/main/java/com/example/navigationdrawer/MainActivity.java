package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;

    NavigationView navigationView;
    TextView header_title;
    View headerView;
    ImageView imageheader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        materialToolbar = findViewById(R.id.materialToolbar);

        navigationView = findViewById(R.id.navigationView);
        headerView = navigationView.getHeaderView(0);
        header_title = headerView.findViewById(R.id.header_title);
        imageheader = headerView.findViewById(R.id.imageheader);

        // Load the default fragment
        loadFragment(new Fragmentfirst());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawerLayout, materialToolbar, R.string.drawer_close, R.string.drawer_open);

        drawerLayout.addDrawerListener(toggle);

        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.profile)
                    Toast.makeText(MainActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if (itemId == R.id.mosharaf_dental) {
                    Fragmentfirst.Web_url = "https://mosharaf-dental.netlify.app/";
                    loadFragment(new Fragmentfirst());
                } else if (itemId == R.id.Mostafiz_dental) {
                    Fragmentfirst.Web_url = "https://mostafizursdental.com/";
                    loadFragment(new Fragmentfirst());
                } else if (itemId == R.id.second_fragment) {
                    loadFragment(new FragmentSecond());
                } else if (itemId == R.id.third_fragment) {
                    loadFragment(new FragmentThird());
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}