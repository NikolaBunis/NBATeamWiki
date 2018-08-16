package com.example.nikola.nbateamwiki.views.StartingFive;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.MainTeamPage.MainTeamPageFragment;
import com.example.nikola.nbateamwiki.views.base.BaseActivity;

public class StartingFiveActivity extends BaseActivity {

    private Fragment mToolbarFragment;

    private Fragment mMainViewFragment;
    public static final long IDENTIFIER = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_five);

        mToolbarFragment = setupDrawer();
        mMainViewFragment = setupMainFragment();

    }

    @Override
    public Fragment setupMainFragment() {
        Fragment fragment = StartingFiveFragment.newInstance();

        getFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();

        return fragment;
    }

    @Override
    public long getIdentifier() {
        return IDENTIFIER;
    }
}
