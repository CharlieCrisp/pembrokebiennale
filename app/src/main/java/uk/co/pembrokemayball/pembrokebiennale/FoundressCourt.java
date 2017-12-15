package uk.co.pembrokemayball.pembrokebiennale;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FoundressCourt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foundress_court);

        //set toolbar colour
        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.toolbar);
        //set toolbar font
        TextView txt = (TextView) findViewById(R.id.textView);
        TextView found = (TextView) findViewById(R.id.found);
        TextView foundtxt = (TextView) findViewById(R.id.foundtxt);
        TextView nih = (TextView) findViewById(R.id.nihon);
        TextView nihtxt = (TextView) findViewById(R.id.nihtxt);

        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        found.setTypeface(font);
        foundtxt.setTypeface(font);
        nih.setTypeface(font);
        nihtxt.setTypeface(font);
        txt.setTypeface(font);
    }

    public void back(View view) {
        this.finish();
    }
}
