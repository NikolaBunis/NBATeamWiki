package com.example.nikola.nbateamwiki.views.views.MainTeamPage;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nikola.nbateamwiki.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.google.firebase.storage.FirebaseStorage.getInstance;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainTeamPageFragment extends Fragment {


    public MainTeamPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main_team_page_fragment, container, false);



        StorageReference gsReference = FirebaseStorage.getInstance()
                .getReferenceFromUrl("gs://nbateamwiki.appspot.com/Golden-State-Warriors-2013-14-Logo-psd95373.png");

        ImageView imageView = view.findViewById(R.id.background_image);

        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(imageView);



        return view;

    }

    public static MainTeamPageFragment newInstance() {

        Bundle args = new Bundle();

        MainTeamPageFragment fragment = new MainTeamPageFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
