package com.bufeotec.floridarestaurant.MVVM.Views.Activitys;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.bufeotec.floridarestaurant.MVVM.Views.fragments.Principal;
import com.bufeotec.floridarestaurant.MVVM.Views.fragments.SettingsFragment;
import com.bufeotec.floridarestaurant.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bnv_menu;
    public Fragment fragmentactual;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv_menu = findViewById(R.id.bnv_menu);
        bnv_menu.setOnNavigationItemSelectedListener(this);

        setInitialFragment();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();


        switch (item.getItemId()) {
            case R.id.action_foro:
                fragment =  getSupportFragmentManager().findFragmentByTag("Foro");

                if (fragment!=null) {
                    //Toast.makeText(getApplicationContext(),"Existe",Toast.LENGTH_SHORT).show();
                    fragmentTransaction.hide(fragmentactual).show(fragment);
                }else {
                    fragment = new Principal();
                    //Toast.makeText(getApplicationContext(),"Anadido",Toast.LENGTH_SHORT).show();
                    fragmentTransaction.hide(fragmentactual).add(R.id.content_frame, fragment, "Foro");
                }
                fragmentTransaction.commit();
                fragmentactual = fragment;

                break;
            case R.id.action_perfil:
                fragment =  getSupportFragmentManager().findFragmentByTag("Perfil");


                if (fragment!=null) {
                    //Toast.makeText(getApplicationContext(),"Existe",Toast.LENGTH_SHORT).show();
                    fragmentTransaction.hide(fragmentactual).show(fragment);
                }else {
                    fragment = new SettingsFragment();
                    //Toast.makeText(getApplicationContext(),"Anadido",Toast.LENGTH_SHORT).show();
                    fragmentTransaction.hide(fragmentactual).add(R.id.content_frame, fragment, "Perfil");
                }
                fragmentTransaction.commit();
                fragmentactual = fragment;

                break;

        }
        return true;
    }

    private void setInitialFragment() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentactual = new Principal();
        fragmentTransaction.add(R.id.content_frame, fragmentactual,"Foro");
        fragmentTransaction.commit();
    }

    public boolean isOnLine(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return  true;
        }else {
            return false;
        }


    }
}
