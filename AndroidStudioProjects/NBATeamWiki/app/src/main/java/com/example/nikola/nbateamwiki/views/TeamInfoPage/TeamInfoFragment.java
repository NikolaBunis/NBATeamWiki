package com.example.nikola.nbateamwiki.views.TeamInfoPage;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.utils.TextHolder;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamInfoFragment extends Fragment {


    public TeamInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_info, container, false);


addPicture(view);

addText(view);






        return view;
    }

    private void addText(View view) {
       FirebaseFirestore db = FirebaseFirestore.getInstance();
        final String[] text = new String[1];
        TextView textView = view.findViewById(R.id.team_info_text);

        db.collection("texts")
                .document("hqpuiHeV1lVRJNbD6HA8")
                .get()
                .addOnCompleteListener(task -> {
                    DocumentSnapshot doc = task.getResult();

                    TextHolder obj =  doc.toObject(TextHolder.class);

                    text[0] = obj.getText();

                    textView.setText(text[0]);
                });





    }

    private void addPicture(View view) {
        StorageReference gsReference = FirebaseStorage.getInstance()
                .getReferenceFromUrl("gs://nbateamwiki.appspot.com/TeamInfoPic1.jpg");

        ImageView imageView = view.findViewById(R.id.team_info_picture);

        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(imageView);

    }

    public static Fragment newInstance() {
        return new TeamInfoFragment();
    }

}
