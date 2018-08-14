package com.example.nikola.nbateamwiki.views.FullRoster;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.utils.Player;
import com.example.nikola.nbateamwiki.views.PlayerPageActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullRosterFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mRosterListView;
    private ArrayAdapter<Player> mPlayersAdapter;

    public FullRosterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_full_roster, container, false);


        mRosterListView = view.findViewById(R.id.roster_list);

        mPlayersAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        mPlayersAdapter.add(new Player("TestName", 4, 4));

        mRosterListView.setAdapter(mPlayersAdapter);

         mRosterListView.setOnItemClickListener(this);



        return view;
    }

    public static Fragment newInstance() {
        return new FullRosterFragment();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Player player = mPlayersAdapter.getItem(position);

        Intent intent = new Intent(getContext(), PlayerPageActivity.class);

        intent.putExtra("Current Player", player.getName());

        startActivity(intent);

    }
}
