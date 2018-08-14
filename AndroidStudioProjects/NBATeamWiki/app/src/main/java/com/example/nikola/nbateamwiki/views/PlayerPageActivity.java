package com.example.nikola.nbateamwiki.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nikola.nbateamwiki.R;

public class PlayerPageActivity extends AppCompatActivity {

    private TextView mPlayerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_page);


        Intent intent = getIntent();

        String playerToDisplay = intent.getStringExtra("Current player");

        mPlayerInfo = findViewById(R.id.player_info);
        mPlayerInfo.setText(playerToDisplay);



    }
}
