package com.example.android.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView profilePictureImageView = (ImageView) findViewById(R.id.profile_picture);
        profilePictureImageView.setImageResource(R.drawable.buildings);

        TextView nameTextView = (TextView) findViewById(R.id.name);
        nameTextView.setText("Jessica");

        TextView birthdayTextView = (TextView) findViewById(R.id.birthday);
        birthdayTextView.setText("9/24/1996");

        TextView countryTextView = (TextView) findViewById(R.id.country);
        countryTextView.setText("Greece");

    }
}
