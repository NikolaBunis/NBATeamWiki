package com.example.nikola.nbateamwiki.views.FavouritePlayer;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.utils.Player;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritePlayerFragment extends Fragment {

    private FirebaseFirestore mDb = FirebaseFirestore.getInstance();
    private ArrayAdapter<String> mPlayerNamesAdapter;
    private Spinner mDynamicSpinner;
    private ImageView mPlayerPicture;
    final private String[] mPictureURL = new String[1];

    public FavouritePlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite_player, container, false);

        addBackgroundImage(view);

        establishPlayer(view);

        setSpinner(view);


        return view;
    }

    private void establishPlayer(View view) {

        mPlayerPicture = view.findViewById(R.id.player_picture);

        getCurrentPicture();


    }

    private void getCurrentPicture() {


        mDb.collection("favourite_Player")
                .document("currentFavouritePlayer")
                .get()
                .addOnCompleteListener(task -> {
                    DocumentSnapshot doc = task.getResult();

                    Player obj = doc.toObject(Player.class);


                    insertPicture(mPlayerPicture, obj.profilePictureURL);


                });


    }

    private void setSpinner(View view) {
        mDynamicSpinner = view.findViewById(R.id.dynamic_spinner);

        mPlayerNamesAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_dropdown_item);

        addPlayerNamesFromDb();

        mDynamicSpinner.setAdapter(mPlayerNamesAdapter);

        mDynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void addPlayerNamesFromDb() {

        mDb.collection("roster").get()
                .addOnCompleteListener(task -> {
                    List<Player> players = task.getResult()
                            .toObjects(Player.class);

                    for (Player player : players) {
                        mPlayerNamesAdapter.add(player.name);
                    }
                });

    }


    private void insertPicture(ImageView imageView, String profilePictureURL) {
        StorageReference gsReference = FirebaseStorage.getInstance()
                .getReferenceFromUrl(profilePictureURL);
        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(imageView);
    }

    private void addBackgroundImage(View view) {
        StorageReference gsReference = FirebaseStorage.getInstance()
                .getReferenceFromUrl("gs://nbateamwiki.appspot.com/backgrounds/StartingFiveBackground.png");

        ImageView imageView = view.findViewById(R.id.background_image);

        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(imageView);

    }

    public static Fragment newInstance() {
        return new FavouritePlayerFragment();
    }
}
