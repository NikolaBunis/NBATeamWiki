package com.example.nikola.nbateamwiki.views.views.MainTeamPage;

import android.app.Fragment;
import android.os.Bundle;
import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.views.BaseActivity;

public class MainTeamPageActivity extends BaseActivity {

private Fragment mToolbarFragment;
    private Fragment mMainViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_team_page);

        mToolbarFragment = DrawerAndTitleFragment.newInstance();
        setupDrawer();

        mMainViewFragment = MainTeamPageFragment.newInstance();

        getFragmentManager().beginTransaction().replace(R.id.main_fragment, mMainViewFragment).commit();



    }

    @Override
    public void setupDrawer() {

getFragmentManager().beginTransaction().replace(R.id.drawer_toolbar, mToolbarFragment).commit();


    }
}
