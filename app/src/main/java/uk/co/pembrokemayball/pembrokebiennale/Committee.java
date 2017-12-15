package uk.co.pembrokemayball.pembrokebiennale;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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
import android.view.View;
import android.widget.TextView;

public class Committee extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_comm);
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
        } else if (id == R.id.nav_gen_info) {
            Intent intent = new Intent(this, General.class);
            startActivity(intent);
        }else if (id == R.id.nav_spon) {
            Intent intent = new Intent(this, Sponsors.class);
            startActivity(intent);
        }
        //TODO else if etc

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    private void setFonts() {
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        TextView committee = (TextView) findViewById(R.id.committee);
        TextView pres = (TextView) findViewById(R.id.pres);
        TextView shad = (TextView) findViewById(R.id.shad);
        TextView vice = (TextView) findViewById(R.id.vice);
        TextView matt = (TextView) findViewById(R.id.matt);
        TextView tres = (TextView) findViewById(R.id.tres);
        TextView myfan = (TextView) findViewById(R.id.myfan);
        TextView infra = (TextView) findViewById(R.id.infra);
        TextView alex = (TextView) findViewById(R.id.alex);
        TextView des = (TextView) findViewById(R.id.des);
        TextView oli = (TextView) findViewById(R.id.oli);
        TextView staff = (TextView) findViewById(R.id.staff);
        TextView amy = (TextView) findViewById(R.id.amy);
        TextView music = (TextView) findViewById(R.id.music);
        TextView harry = (TextView) findViewById(R.id.harry);
        TextView decor = (TextView) findViewById(R.id.decor);
        TextView emily = (TextView) findViewById(R.id.emily);
        TextView nonmus = (TextView) findViewById(R.id.nonmus);
        TextView milly = (TextView) findViewById(R.id.milly);
        TextView foodcomm = (TextView) findViewById(R.id.foodcomm);
        TextView gina = (TextView) findViewById(R.id.gina);
        TextView ticketing = (TextView) findViewById(R.id.ticketing);
        TextView matev = (TextView) findViewById(R.id.matev);
        TextView drinkcomm = (TextView) findViewById(R.id.drinkcomm);
        TextView mich = (TextView) findViewById(R.id.mich);
        committee.setTypeface(font);
        title.setTypeface(font);
        pres.setTypeface(font);
        shad.setTypeface(font);
        vice.setTypeface(font);
        matt.setTypeface(font);
        tres.setTypeface(font);
        myfan.setTypeface(font);
        infra.setTypeface(font);
        alex.setTypeface(font);
        des.setTypeface(font);
        oli.setTypeface(font);
        staff.setTypeface(font);
        amy.setTypeface(font);
        music.setTypeface(font);
        harry.setTypeface(font);
        decor.setTypeface(font);
        emily.setTypeface(font);
        nonmus.setTypeface(font);
        milly.setTypeface(font);
        foodcomm.setTypeface(font);
        gina.setTypeface(font);
        ticketing.setTypeface(font);
        matev.setTypeface(font);
        drinkcomm.setTypeface(font);
        mich.setTypeface(font);
    }
}
