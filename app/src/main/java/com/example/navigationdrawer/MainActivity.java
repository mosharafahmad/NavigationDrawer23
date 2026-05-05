package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
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
    /*    EdgeToEdge.enable(this);  */
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        materialToolbar = findViewById(R.id.materialToolbar);

        navigationView = findViewById(R.id.navigationView);
        headerView = navigationView.getHeaderView(0);
        header_title = headerView.findViewById(R.id.header_title);
        imageheader = headerView.findViewById(R.id.imageheader);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new Fragmentfirst());
        fragmentTransaction.commit();



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(

         MainActivity.this, drawerLayout,materialToolbar,R.string.drawer_close,R.string.drawer_open);

      drawerLayout.addDrawerListener(toggle);


      materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem item) {

             if (item.getItemId()==R.id.profile)
             Toast.makeText(MainActivity.this, "Hellow", Toast.LENGTH_SHORT).show();

              return true;
          }
      });







       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

           if (menuItem.getItemId()==R.id.mosharaf_dental){

              Fragmentfirst.Web_url = "https://mosharaf-dental.netlify.app/";
               FragmentManager fm = getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fm.beginTransaction();
               fragmentTransaction.replace(R.id.frameLayout, new Fragmentfirst());
               fragmentTransaction.commit();

               drawerLayout.closeDrawer(GravityCompat.START);

           } else if (menuItem.getItemId()==R.id.Mostafiz_dental) {

               Fragmentfirst.Web_url = "https://mostafizursdental.com/";
               FragmentManager fm = getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fm.beginTransaction();
               fragmentTransaction.replace(R.id.frameLayout, new Fragmentfirst());
               fragmentTransaction.commit();
               drawerLayout.closeDrawer(GravityCompat.START);

           }
               return true;
           }
       });


      /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });    */
    }
}