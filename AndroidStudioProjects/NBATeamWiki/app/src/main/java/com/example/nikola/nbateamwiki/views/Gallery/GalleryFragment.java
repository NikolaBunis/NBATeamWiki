package com.example.nikola.nbateamwiki.views.Gallery;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.utils.ImageAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);


        final GridView gridview = view.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity()));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent i = new Intent(getContext(), FullImageActivity.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });


        return view;
    }




    private void insertPicture(ImageView imageView, String pictureURL) {
        StorageReference gsReference = FirebaseStorage.getInstance()
                .getReferenceFromUrl(pictureURL);
        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(imageView);
    }

    public static Fragment newInstance() {
        return new GalleryFragment();
    }
}
