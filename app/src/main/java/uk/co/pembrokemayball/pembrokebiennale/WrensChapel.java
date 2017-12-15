package uk.co.pembrokemayball.pembrokebiennale;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WrensChapel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrens_chapel);

        //set toolbar colour
        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.toolbar);
        //set toolbar font
        TextView txt = (TextView) findViewById(R.id.textView);
        TextView wrenTitle = (TextView) findViewById(R.id.found);
        TextView wrentxt = (TextView) findViewById(R.id.wrentxt);
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        wrenTitle.setTypeface(font);
        wrentxt.setTypeface(font);
        txt.setTypeface(font);
    }

    public void back(View view) {
        this.finish();
    }
}
