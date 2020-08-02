package com.plavos.insurance.plavosinsurance;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.text.Layout;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    // TODO: this is a TODO thing! Check down left at the TODO tab :)
    // TODO: Things to Remember: 1. Ctrl+Shift+A searching... 2. Search "Android Monitor" this can do Screen/Video Capture 3. Ctrl+Shift+V = Copy/Paste History

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void goToWebsite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://insurance.plavos.com"));
        startActivity(browserIntent);
    }

    public void getFreeQuote(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://athns.typeform.com/to/R6KZhX?fullname=%20&product=androidApp"));
        startActivity(browserIntent);
    }

    public void goToGoogleBusiness(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://g.co/kgs/C9jsXS"));
        startActivity(browserIntent);
    }

    public void clickToCall(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+306978892178"));
        startActivity(callIntent);
    }

    public void sendEmail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:plavosinsurance@gmail.com"));
        startActivity(emailIntent);
    }

    public void goToLinkedIn(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://vasilis.plavos.com"));
        startActivity(browserIntent);
    }
}
