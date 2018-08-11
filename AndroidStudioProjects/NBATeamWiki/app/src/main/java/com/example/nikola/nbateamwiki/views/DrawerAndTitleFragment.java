package com.example.nikola.nbateamwiki.views;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.Gallery.GalleryActivity;
import com.example.nikola.nbateamwiki.views.MainTeamPage.MainTeamPageActivity;
import com.example.nikola.nbateamwiki.views.TeamInfoPage.TeamInfoActivity;
import com.example.nikola.nbateamwiki.views.base.BaseActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import javax.net.ssl.HostnameVerifier;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerAndTitleFragment extends Fragment {


    private Toolbar mDrawer;

    public DrawerAndTitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drawer_and_title, container, false);


        mDrawer = view.findViewById(R.id.drawer_toolbar);

        setupDrawer();


        return view;
    }

    public static DrawerAndTitleFragment newInstance() {

        return new DrawerAndTitleFragment();


    }

    public void setupDrawer() {

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(MainTeamPageActivity.IDENTIFIER).withName("Home");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(TeamInfoActivity.IDENTIFIER).withName("Team Info");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Gallery");
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Full Roster");
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Your starting 5");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(getActivity())
                .withToolbar(mDrawer)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new PrimaryDrawerItem(),
                        item3,
                        new PrimaryDrawerItem(),
                        item4,
                        new PrimaryDrawerItem(),
                        item5,
                        new PrimaryDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        long identifier = drawerItem.getIdentifier();


                        if (identifier == MainTeamPageActivity.IDENTIFIER) {
                            //the below checks if the drawer fragment is in the activity that is being clicked on
                            //in a very clunky way, but the only one I could think of, might need optimisation or at least
                            //moving the if-else logic in a method.
                            if (getActivity().getClass().equals(MainTeamPageActivity.class))
                                return false;

                            else {
                                Intent intent = new Intent(getContext(), MainTeamPageActivity.class);

                                startActivity(intent);
                                return true;
                            }
                        } else if (identifier == TeamInfoActivity.IDENTIFIER) {
                            if (getActivity().getClass().equals(TeamInfoActivity.class))
                                return false;
                            else {
                                Intent intent = new Intent(getContext(), TeamInfoActivity.class);

                                startActivity(intent);
                                return true;
                            }
                        }

                        else if (identifier == GalleryActivity.IDENTIFIER) {
                            if (getActivity().getClass().equals(GalleryActivity.class))
                                return false;
                            else {
                                Intent intent = new Intent(getContext(), GalleryActivity.class);

                                startActivity(intent);
                                return true;
                            }
                        }

                        return false;

                    }
                })
                .build();


    }


}
