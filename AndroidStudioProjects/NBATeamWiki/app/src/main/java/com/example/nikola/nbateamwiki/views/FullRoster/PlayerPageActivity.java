package com.example.nikola.nbateamwiki.views.FullRoster;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.example.nikola.nbateamwiki.R;
import com.example.nikola.nbateamwiki.views.TeamInfoPage.TeamInfoFragment;
import com.squareup.picasso.Picasso;

public class PlayerPageActivity extends AppCompatActivity {

    private TextView mPlayerInfo;
    private ImageView mPlayerPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_page);


        Intent intent = getIntent();


        String picUrl = intent.getStringExtra("profilePictureURL");


        String text = intent.getStringExtra("playerInfo");

        setPicture(picUrl);
        setText(text);


    }

    private void setText(String text) {

        mPlayerInfo = findViewById(R.id.player_info_text);
        mPlayerInfo.setText(text);

    }

    private void setPicture(String picUrl) {

mPlayerPicture = findViewById(R.id.player_picture);

        Picasso.with(this)
                .load(picUrl)
                .placeholder(R.drawable.loader)
                .fit()
                .centerCrop().into(mPlayerPicture);


    }


}
