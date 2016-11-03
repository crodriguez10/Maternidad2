package com.example.dell.proyecto;

import android.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class Principal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    private String drawerTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navegacion);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abrir, R.string.cerrar);
        drawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.citas:
                callFragment(item, new Citas());
                return true;
            case R.id.ecografias:
                //callFragment(item, new FragmentConsulta());
                return true;
            case R.id.motivos:
                callFragment(item, new Motivos());
                return true;
            case R.id.resultados:
                callFragment(item, new Resultados());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void callFragment(MenuItem item, Fragment frag){
        android.app.FragmentManager fragmentManager = getFragmentManager();
        item.setChecked(true);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.contenido_fragment);
        relativeLayout.removeAllViews();
        fragmentManager.beginTransaction().replace(R.id.contenido_fragment, frag).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
