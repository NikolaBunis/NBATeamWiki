package com.example.nikola.nbateamwiki.views.FullRoster;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.TeamInfoPage.TeamInfoFragment;
import com.example.nikola.nbateamwiki.views.base.BaseActivity;

public class FullRosterActivity extends BaseActivity {

    private Fragment mToolbarFragment;
    private Fragment mMainViewFragment;

    public static final long IDENTIFIER = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_roster);


        mToolbarFragment = setupDrawer();
        mMainViewFragment = setupMainFragment();





    }

    @Override
    public Fragment setupMainFragment() {

        Fragment fragment = FullRosterFragment.newInstance();

        getFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();

        return fragment;
    }

    @Override
    public long getIdentifier() {
        return IDENTIFIER;
    }
}
