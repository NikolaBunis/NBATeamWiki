package com.example.nikola.nbateamwiki.views.MainTeamPage;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.FullRoster.FullRosterActivity;
import com.example.nikola.nbateamwiki.views.Gallery.GalleryActivity;
import com.example.nikola.nbateamwiki.views.TeamInfoPage.TeamInfoActivity;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.google.firebase.storage.FirebaseStorage.getInstance;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainTeamPageFragment extends Fragment {


    private View mTeamInfoButton;
    private View mGalleryButton;
    private View mFullRosterButton;

    public MainTeamPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_team_page_fragment, container, false);

        addBackgroundImage(view);

        mTeamInfoButton = view.findViewById(R.id.team_info_button);
        mTeamInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchTeamInfoActivity();
            }
        });

//trying different codes to initiate onClick events

        mGalleryButton = view.findViewById(R.id.gallery_button);
        mGalleryButton.setOnClickListener(item -> {
            launchGalleryActivity();
        });

        mFullRosterButton = view.findViewById(R.id.full_roster_button);
        mFullRosterButton.setOnClickListener(item -> {
            launchFullRosterActivity();
        });


        return view;

    }

    private void launchFullRosterActivity() {

        Intent intent = new Intent(getActivity(), FullRosterActivity.class);
        startActivity(intent);

    }

    private void launchGalleryActivity() {
        Intent intent = new Intent(getActivity(), GalleryActivity.class);
        startActivity(intent);


    }

    private void launchTeamInfoActivity() {


        Intent intent = new Intent(getActivity(), TeamInfoActivity.class);
        startActivity(intent);

    }

    private void addBackgroundImage(View view) {
        StorageReference gsReference = FirebaseStorage.getInstance()
                .getReferenceFromUrl("gs://nbateamwiki.appspot.com/backgrounds/MainActivityBackground.jpg");

        ImageView imageView = view.findViewById(R.id.background_image);

        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(imageView);

    }

    public static MainTeamPageFragment newInstance() {

        Bundle args = new Bundle();

        MainTeamPageFragment fragment = new MainTeamPageFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
