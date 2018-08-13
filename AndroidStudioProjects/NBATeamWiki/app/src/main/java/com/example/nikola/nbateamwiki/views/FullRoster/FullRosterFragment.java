package com.example.nikola.nbateamwiki.views.FullRoster;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikola.nbateamwiki.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullRosterFragment extends Fragment {


    public FullRosterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_full_roster, container, false);






        return view;
    }

    public static Fragment newInstance() {
        return new FullRosterFragment();
    }
}
