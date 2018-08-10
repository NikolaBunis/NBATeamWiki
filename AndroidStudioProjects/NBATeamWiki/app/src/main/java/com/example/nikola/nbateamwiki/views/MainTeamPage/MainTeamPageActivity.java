package com.example.nikola.nbateamwiki.views.MainTeamPage;

import android.app.Fragment;
import android.os.Bundle;

import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.base.BaseActivity;

public class MainTeamPageActivity extends BaseActivity {

    private Fragment mToolbarFragment;
    private Fragment mMainViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_team_page);

        mToolbarFragment = setupDrawer();
        mMainViewFragment = setupMainFragment();




    }


    @Override
    public Fragment setupMainFragment() {

        Fragment fragment = MainTeamPageFragment.newInstance();

        getFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();

        return fragment;
    }
}
