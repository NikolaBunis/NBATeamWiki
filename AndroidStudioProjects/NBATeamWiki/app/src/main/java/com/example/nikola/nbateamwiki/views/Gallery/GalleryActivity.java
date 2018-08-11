package com.example.nikola.nbateamwiki.views.Gallery;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.MainTeamPage.MainTeamPageFragment;
import com.example.nikola.nbateamwiki.views.base.BaseActivity;

public class GalleryActivity extends BaseActivity {

    public static final long IDENTIFIER = 3;
    private Fragment mToolbarFragment;
    private Fragment mMainViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mToolbarFragment = setupDrawer();
        mMainViewFragment = setupMainFragment();


    }

    @Override
    public Fragment setupMainFragment() {
        Fragment fragment = GalleryFragment.newInstance();

        getFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();

        return fragment;
    }

    @Override
    public long getIdentifier() {
        return IDENTIFIER;
    }
}
