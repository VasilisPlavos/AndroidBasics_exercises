package com.example.android.cookies;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        String message = "I'm so Full";
        TextView eatCookieText = (TextView) findViewById(R.id.status_text_view);
        eatCookieText.setText(message);

        // TODO: Find a reference to the TextView in the layout. Change the text.
        ImageView eatCookieImage = (ImageView) findViewById(R.id.android_cookie_image_view);
        eatCookieImage.setImageResource(R.drawable.after_cookie);

        Log.i("EnterpriseActivity.java", "Captain's Log, Stardate 43125.8. We have entered a spectacular binary star system in the Kavis Alpha sector on a most critical mission of astrophysical research.");


    }


}