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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by charl on 14/06/2017.
 */

public class WhatsOn extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener{
    private static final String TAG = "WhatsOn";
    ListAdapter listAdapter = null;
    SeekBar seek = null;
    String[] ITEMS = {"DRINKS", "FOOD", "ENTS", "MUSIC"};
    Spinner spinner = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatson);
        seek = (SeekBar) findViewById(R.id.seekBar);
        ListView listView = (ListView) findViewById(R.id.listwhaton);
        ArrayList<WhatsOnItem> mList = new ArrayList( Arrays.asList(WhatsOnInfoContainer.drinks));
        Collections.sort(mList);
        listAdapter = new ListAdapter(this, R.layout.itemlistrow, mList);
        listView.setAdapter(listAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_whatson);
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
        spinner = (Spinner) findViewById(R.id.what_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.my_spinner, ITEMS) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                Typeface externalFont=Typeface.createFromAsset(getAssets(), "Didot.ttf");
                ((TextView) v).setTypeface(externalFont);

                return v;
            }


            public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
                View v =super.getDropDownView(position, convertView, parent);

                Typeface externalFont=Typeface.createFromAsset(getAssets(), "Didot.ttf");
                ((TextView) v).setTypeface(externalFont);

                return v;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        setDrinks();
                        break;
                    case 1:
                        setFood();
                        break;
                    case 2:
                        setEnts();
                        break;
                    case 3:
                        setMusic();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
        setFonts();
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (listAdapter != null && seek != null) {
                    final int time = seek.getProgress() + 9;
                    ArrayList<WhatsOnItem> list = null;
                    switch(spinner.getSelectedItemPosition()) {
                        case 0 :
                            list = new ArrayList<>(Arrays.asList(WhatsOnInfoContainer.drinks));
                            break;
                        case 1:
                            list = new ArrayList<>(Arrays.asList(WhatsOnInfoContainer.food));
                            break;
                        case 2:
                            list = new ArrayList<>(Arrays.asList(WhatsOnInfoContainer.ents));
                            break;
                        case 3:
                            list = new ArrayList<>(Arrays.asList(WhatsOnInfoContainer.music));
                            break;
                    }
                    ArrayList<WhatsOnItem> goodList = new ArrayList<>();
                    for (WhatsOnItem woi : list) {
                        if (woi.getEndTime() >= time){
                            goodList.add(woi);
                        }
                    }
                    Collections.sort(goodList);
                    listAdapter.clear();
                    listAdapter.addAll(goodList);
                    listAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Intent intent = getIntent();
        //check for intent
        if (intent != null) {
            String txt = intent.getStringExtra("type");
            if (txt != null) {
                switch (txt) {
                    case "drinks":
                        setDrinks();
                        break;
                    case "food":
                        setFood();
                        break;
                    case "ents":
                        setEnts();
                        break;
                    case "music":
                        setMusic();
                        break;
                }
            }
        }
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
            //intentionally blank
        }else if (id == R.id.nav_ents) {
            setEnts();
        } else if (id == R.id.nav_food) {
            setFood();
        } else if (id == R.id.nav_music) {
            setMusic();
        }else if (id == R.id.nav_gen_info) {
            Intent intent = new Intent(this, General.class);
            startActivity(intent);
        }else if (id == R.id.nav_com) {
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
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    private void setFonts() {
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        TextView nine = (TextView) findViewById(R.id.ninepm);
        TextView eleven = (TextView) findViewById(R.id.elevenpm);
        TextView one = (TextView) findViewById(R.id.oneam);
        TextView three = (TextView) findViewById(R.id.threeam);
        TextView five = (TextView) findViewById(R.id.fiveam);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setTypeface(font);
        nine.setTypeface(font);
        eleven.setTypeface(font);
        one.setTypeface(font);
        three.setTypeface(font);
        five.setTypeface(font);
    }

    private void setDrinks() {
        if (listAdapter != null && seek != null) {
            final int time = seek.getProgress() + 9;
            ArrayList<WhatsOnItem> list = new ArrayList<>(Arrays.asList(WhatsOnInfoContainer.drinks));
            ArrayList<WhatsOnItem> goodList = new ArrayList<>();
            for (WhatsOnItem woi : list) {
                if (woi.getEndTime() >= time){
                    goodList.add(woi);
                }
            }
            Collections.sort(goodList);
            listAdapter.clear();
            listAdapter.addAll(goodList);
            listAdapter.notifyDataSetChanged();
            spinner.setSelection(0);
        }
    }
    private void setFood() {
        if (listAdapter != null && seek != null) {
            final int time = seek.getProgress() + 9;
            ArrayList<WhatsOnItem> list = new ArrayList<>(Arrays.asList(WhatsOnInfoContainer.food));
            ArrayList<WhatsOnItem> goodList = new ArrayList<>();
            for (WhatsOnItem woi : list) {
                if (woi.getEndTime() >= time){
                    goodList.add(woi);
                }
            }
            listAdapter.clear();
            Collections.sort(goodList);
            listAdapter.addAll(goodList);
            listAdapter.notifyDataSetChanged();
            spinner.setSelection(1);
        }
    }
    private void setEnts() {
        if (listAdapter != null && seek != null) {
            final int time = seek.getProgress() + 9;
            ArrayList<WhatsOnItem> list = new ArrayList<>(Arrays.asList(WhatsOnInfoContainer.ents));
            ArrayList<WhatsOnItem> goodList = new ArrayList<>();
            for (WhatsOnItem woi : list) {
                if (woi.getEndTime() >= time){
                    goodList.add(woi);
                }
            }
            Collections.sort(goodList);
            listAdapter.clear();
            listAdapter.addAll(goodList);
            listAdapter.notifyDataSetChanged();
            spinner.setSelection(2);
        }
    }
    private void setMusic() {
        if (listAdapter != null && seek != null) {
            final int time = seek.getProgress() + 9;
            ArrayList<WhatsOnItem> list = new ArrayList<>(Arrays.asList(WhatsOnInfoContainer.music));
            ArrayList<WhatsOnItem> goodList = new ArrayList<>();
            for (WhatsOnItem woi : list) {
                if (woi.getEndTime() >= time){
                    goodList.add(woi);
                }
            }
            Collections.sort(goodList);
            listAdapter.clear();
            listAdapter.addAll(goodList);
            listAdapter.notifyDataSetChanged();
            spinner.setSelection(3);
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        switch(pos) {
            case 0:
                setDrinks();
                break;
            case 1:
                setFood();
                break;
            case 2:
                setEnts();
                break;
            case 3:
                setMusic();
                break;
            default:
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
