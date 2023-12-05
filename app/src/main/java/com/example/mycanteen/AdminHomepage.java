package com.example.mycanteen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.mycanteen.Adapters.MainAdapter;
import com.example.mycanteen.Models.MainModel;
import com.example.mycanteen.databinding.ActivityMain2Binding;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import static com.example.mycanteen.loginJava.LOGINEMAIL;
import static com.example.mycanteen.signupJava.SIGNUPEMAIL;

public class AdminHomepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static String EMAIL;
    orderDBhelper OrderDB;
    ActivityMain2Binding binding;
    String emailid;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(LOGINEMAIL!="")
        {
            EMAIL=LOGINEMAIL;
        }
        else
        {
            EMAIL=SIGNUPEMAIL;
        }

        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.chickenchop,"Chicken Chop","8"));
        list.add(new MainModel(R.drawable.fishandchips,"Fish and Chips","8"));
        list.add(new MainModel(R.drawable.friedrice,"Fried rice","5"));
        list.add(new MainModel(R.drawable.nasilemak,"Nasi Lemak","2"));
        list.add(new MainModel(R.drawable.nasigorengpaprik,"Nasi Goreng Paprik","7"));
        list.add(new MainModel(R.drawable.nescafeais,"Nescafe Ais","2"));
        list.add(new MainModel(R.drawable.watermelonjuice,"Watermelon juice","5"));
        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        drawerLayout=findViewById(R.id.drawableLayout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(AdminHomepage.this);
    }

    public void onBackPressed(){
        DrawerLayout drawer=findViewById(R.id.drawableLayout);
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home: break; case R.id.nav_cart:
                Intent intent2=new Intent(AdminHomepage.this,cartJava.class);
                startActivity(intent2);
                break;
            case R.id.nav_profile:
                Intent intent=new Intent(AdminHomepage.this,accountJava.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                Intent intent3=new Intent(AdminHomepage.this,MainActivity.class);
                startActivity(intent3);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}

