package com.bufeotec.floridarestaurant.MVVM.Views.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bufeotec.floridarestaurant.R;


public class Principal extends Fragment {


    private TabLayout tabLayout;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    public ViewPager mViewPager;

    private  static int[] imgIds = {
            R.drawable.home_rojo,
            R.drawable.reservas_rojo,
            R.drawable.info_rojo,
            R.drawable.review_rojo
    };

    private  static int[] imgBordeIds = {
            R.drawable.home_azul,
            R.drawable.reservas_azul,
            R.drawable.info_azul,
            R.drawable.review_azul
    };



    public Principal() {
    }




    TextView tituloApp,login;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pricipal, container, false);


        tituloApp = view.findViewById(R.id.tituloApp);
        login = view.findViewById(R.id.login);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        mViewPager = view.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout =  view.findViewById(R.id.tabs);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home_rojo).setText("CARTA"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.reservas_azul).setText("RESERVAS"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.info_azul).setText("INFO"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.review_azul).setText("REVIEWS"));

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) tab.setCustomView(R.layout.custom_tabs);
        }

        /*for(int i=0;i<4;i++) {
            tabLayout.addTab(tabLayout.newTab(). setIcon(imgBordeIds[i]).setText(tituloIds[i]) );
        }*/


        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                tab.setIcon(imgIds[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(imgBordeIds[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.getSelectedTabPosition();



        return view;
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment  = null;

            switch (position){
                case 0:
                    fragment = new FragmentRestaurant();
                    break;
                case 1:
                    fragment = new ReservarMesaFragment();
                    break;
                case 2:
                    fragment = new InfoFragment();
                    break;
                case 3:
                    fragment = new Reviewsfragment();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

    }

}
