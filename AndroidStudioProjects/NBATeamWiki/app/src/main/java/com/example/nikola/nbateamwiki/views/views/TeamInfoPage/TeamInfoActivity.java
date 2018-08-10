package com.example.nikola.nbateamwiki.views.views.TeamInfoPage;

import android.app.Fragment;
import android.os.Bundle;

import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.views.BaseActivity;

public class TeamInfoActivity extends BaseActivity {

    private Fragment mToolbarFragment;
    private Fragment mMainViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);

        mToolbarFragment = setupDrawer();
        mMainViewFragment = setupMainFragment();


    }


    @Override
    public Fragment setupMainFragment() {
        Fragment fragment = TeamInfoFragment.newInstance();

        getFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();

        return fragment;
    }
}
