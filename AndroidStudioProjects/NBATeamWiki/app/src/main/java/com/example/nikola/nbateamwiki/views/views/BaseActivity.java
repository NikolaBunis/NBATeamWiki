package com.example.nikola.nbateamwiki.views.views;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.nikola.nbateamwiki.R;

public abstract class BaseActivity extends AppCompatActivity {

public Fragment setupDrawer(){

    Fragment fragment = DrawerAndTitleFragment.newInstance();

    getFragmentManager().beginTransaction().replace(R.id.drawer_toolbar, fragment).commit();

    return fragment;
}

public abstract Fragment setupMainFragment();

}
