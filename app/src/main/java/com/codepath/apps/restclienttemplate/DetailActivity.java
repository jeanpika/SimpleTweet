package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    ImageView ivProfileImage;
    TextView tvBody;
    TextView tvScreenName;
    TextView rvTimestamp;
    Tweet tweet;
    Toolbar toolbar;

    // User can tap a tweet to display a "detailed" view of that tweet (2 points)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle(null);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvBody = findViewById(R.id.tvBody);
        tvScreenName = findViewById(R.id.tvScreenName);
        rvTimestamp = findViewById(R.id.rvTimestamp);

        Tweet twitter = Parcels.unwrap(getIntent().getParcelableExtra("twitter"));

        tvBody.setText(twitter.body);
        tvScreenName.setText(twitter.user.screenName);
        Glide.with(this).load(twitter.user.profileImageUrl).into(ivProfileImage);
    }
}