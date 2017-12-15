package uk.co.pembrokemayball.pembrokebiennale;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Map extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = "Map";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: beginning");
        setContentView(R.layout.activity_map);
        Log.d(TAG, "onCreate: continuing");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_map);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu m = navigationView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }
        setFonts();
    }

    private void setFonts() {
        //set toolbar font
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        //set textview fonts
        TextView clickOn = (TextView) findViewById(R.id.clickonmap);
        TextView list1 = (TextView) findViewById(R.id.list1);
        TextView list2 = (TextView) findViewById(R.id.list2);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setTypeface(font);
        clickOn.setTypeface(font);
        list1.setTypeface(font);
        list2.setTypeface(font);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            // Handle the camera action
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }  else if (id == R.id.nav_map)  {
            ///intentionally blank
        }   else if (id == R.id.nav_whats_on) {
            Intent intent = new Intent(this, WhatsOn.class);
            startActivity(intent);
        } else if (id == R.id.nav_ents) {
            Intent intent = new Intent(this, WhatsOn.class);
            intent.putExtra("type", "ents");
            startActivity(intent);
        } else if (id == R.id.nav_food) {
            Intent intent = new Intent(this, WhatsOn.class);
            intent.putExtra("type", "food");
            startActivity(intent);
        } else if (id == R.id.nav_music) {
            Intent intent = new Intent(this, WhatsOn.class);
            intent.putExtra("type", "music");
            startActivity(intent);
        }else if (id == R.id.nav_gen_info) {
            Intent intent = new Intent(this, General.class);
            startActivity(intent);
        }else if (id == R.id.nav_com) {
            Intent intent = new Intent(this, Committee.class);
            startActivity(intent);
        } else if (id == R.id.nav_spon) {
            Intent intent = new Intent(this, Sponsors.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("EXIT", true);
            finish();
            startActivity(intent);
        }
    }

    public void openOrch(View view) {
        Intent intent = new Intent(this, TheOrchard.class);
        startActivity(intent);
    }
    public void openOldLib(View view) {
        Intent intent = new Intent(this, OldLibrary.class);
        startActivity(intent);
    }
    public void openOldCourt(View view) {
        Intent intent = new Intent(this, OldCourt.class);
        startActivity(intent);
    }
    public void openIvyParl(View view) {
        Intent intent = new Intent(this, IvyParlours.class);
        startActivity(intent);
    }
    public void openIvyCourt(View view) {
        Intent intent = new Intent(this, IvyCourt.class);
        startActivity(intent);
    }
    public void openFoundLawn(View view) {
        Intent intent = new Intent(this, FoundressCourt.class);
        startActivity(intent);
    }
    public void openMastGard(View view) {
        Intent intent = new Intent(this, MastersGarden.class);
        startActivity(intent);
    }
    public void openFellowGard(View view) {
        Intent intent = new Intent(this, FellowsGarden.class);
        startActivity(intent);
    }
    public void openNewCourt(View view) {
        Intent intent = new Intent(this, NewCourt.class);
        startActivity(intent);
    }
    public void openRed(View view) {
        Intent intent = new Intent(this, RedBuildingsLawn.class);
        startActivity(intent);
    }
    public void openWren(View view) {
        Intent intent = new Intent(this, WrensChapel.class);
        startActivity(intent);
    }

    @Override
    public void setTitle(CharSequence title) {
       //do somethign
    }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }
}
