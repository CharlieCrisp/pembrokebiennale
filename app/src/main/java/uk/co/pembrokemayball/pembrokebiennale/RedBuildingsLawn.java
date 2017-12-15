package uk.co.pembrokemayball.pembrokebiennale;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RedBuildingsLawn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_buildings_lawn);

        //set toolbar colour
        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.toolbar);
        //set toolbar font
        TextView txt = (TextView) findViewById(R.id.textView);
        TextView orchTitle = (TextView) findViewById(R.id.found);
        TextView orchtxt = (TextView) findViewById(R.id.foundtxt);
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        orchTitle.setTypeface(font);
        orchtxt.setTypeface(font);
        txt.setTypeface(font);
    }

    public void back(View view) {
        this.finish();
    }
}
