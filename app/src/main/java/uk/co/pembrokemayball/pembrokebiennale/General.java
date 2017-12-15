package uk.co.pembrokemayball.pembrokebiennale;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

/**
 * Created by charl on 14/06/2017.
 */

public class General extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_general);
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
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }
        setFonts();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            // Handle the camera action
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        } else if (id == R.id.nav_map) {
            Intent intent = new Intent(this, Map.class);
            startActivity(intent);
        } else if (id == R.id.nav_whats_on) {
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
        } else if (id == R.id.nav_com) {
            Intent intent = new Intent(this, Committee.class);
            startActivity(intent);
        }else if (id == R.id.nav_spon) {
            Intent intent = new Intent(this, Sponsors.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    private void setFonts() {
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        TextView ass = (TextView) findViewById(R.id.ass);
        TextView assbody = (TextView) findViewById(R.id.assbody);
        TextView cloak = (TextView) findViewById(R.id.cloak);
        TextView cloakbody = (TextView) findViewById(R.id.cloakmain);
        TextView adm = (TextView) findViewById(R.id.adm);
        TextView admbody = (TextView) findViewById(R.id.admmain);
        TextView fire = (TextView) findViewById(R.id.fire);
        TextView firebody = (TextView) findViewById(R.id.firemain);
        TextView smok = (TextView) findViewById(R.id.smok);
        TextView smokbody = (TextView) findViewById(R.id.smokmain);
        TextView photo = (TextView) findViewById(R.id.photo);
        TextView photobody = (TextView) findViewById(R.id.photomain);
        TextView light = (TextView) findViewById(R.id.light);
        TextView lightbody = (TextView) findViewById(R.id.lightmain);
        TextView food = (TextView) findViewById(R.id.foodall);
        TextView foodbody = (TextView) findViewById(R.id.foodallmain);
        TextView app = (TextView) findViewById(R.id.appcont);
        TextView appbody = (TextView) findViewById(R.id.appcontmain);
        TextView header = (TextView) findViewById(R.id.toolbar_title);
        header.setTypeface(font);
        ass.setTypeface(font);
        ass.setTextSize(25);
        assbody.setTypeface(font);
        cloak.setTypeface(font);
        cloak.setTextSize(25);
        cloakbody.setTypeface(font);
        adm.setTypeface(font);
        adm.setTextSize(25);
        admbody.setTypeface(font);
        fire.setTypeface(font);
        fire.setTextSize(25);
        firebody.setTypeface(font);
        smok.setTypeface(font);
        smok.setTextSize(25);
        smokbody.setTypeface(font);
        photo.setTypeface(font);
        photo.setTextSize(25);
        photobody.setTypeface(font);
        light.setTypeface(font);
        light.setTextSize(25);
        lightbody.setTypeface(font);
        food.setTypeface(font);
        food.setTextSize(25);
        foodbody.setTypeface(font);
        app.setTypeface(font);
        app.setTextSize(25);
        appbody.setTypeface(font);
    }
}
