package com.sancheztech.mascota;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sancheztech.mascota.adaptadores.MascotaAdapter;
import com.sancheztech.mascota.adaptadores.PageAdapter;
import com.sancheztech.mascota.fragment.PerfilFragment;
import com.sancheztech.mascota.fragment.RecylerViewFragment;
import com.sancheztech.mascota.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        toolbar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPage();


        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
    }

    private void setUpViewPage()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new  ArrayList<Fragment>();

        fragments.add(new RecylerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_mascota, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_contacto:
                Intent intentContacto = new Intent(this, ContactoActivity.class);
                startActivityForResult(intentContacto, 1);
                return  true;
            case R.id.action_acercaDe:
                Intent intentAcercaDe = new Intent(this, AcercaDeActivity.class);
                startActivityForResult(intentAcercaDe, 2);
                return true;
            case R.id.menu_rankin:
                Intent intent = new Intent(this, RankinActivity.class);
                startActivityForResult(intent, 0);
                return true;
            default:
                return  false;
        }
    }
}
