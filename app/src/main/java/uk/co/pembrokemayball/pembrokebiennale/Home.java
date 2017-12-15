package uk.co.pembrokemayball.pembrokebiennale;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.SubMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
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
        scheduleAlarmNotifications();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            // intentionally blank
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
        } else if (id == R.id.nav_com) {
            Intent intent = new Intent(this, Committee.class);
            startActivity(intent);
        } else if (id == R.id.nav_spon) {
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
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    private void setFonts() {
        Typeface font = Typeface.createFromAsset(getAssets(), "Didot.ttf");
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        TextView map = (TextView) findViewById(R.id.map);
        TextView whatson = (TextView) findViewById(R.id.whatson);
        TextView food = (TextView) findViewById(R.id.food);
        TextView drink = (TextView) findViewById(R.id.drink);
        TextView music = (TextView) findViewById(R.id.music);
        TextView ents = (TextView) findViewById(R.id.ents);
        TextView geninfo = (TextView) findViewById(R.id.geninfo);
        TextView thecom = (TextView) findViewById(R.id.thecom);
        TextView spon = (TextView) findViewById(R.id.ourspon);
        title.setTypeface(font);
        map.setTypeface(font);
        whatson.setTypeface(font);
        food.setTypeface(font);
        drink.setTypeface(font);
        music.setTypeface(font);
        ents.setTypeface(font);
        geninfo.setTypeface(font);
        thecom.setTypeface(font);
        spon.setTypeface(font);
    }

    public void openMap(View view) {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    public void openWhatsOn(View view) {
        Intent intent = new Intent(this, WhatsOn.class);
        startActivity(intent);
    }

    public void openSpon(View view) {
        Intent intent = new Intent(this, Sponsors.class);
        startActivity(intent);
    }

    public void openFood(View view) {
        Intent intent = new Intent(this, WhatsOn.class);
        intent.putExtra("type", "food");
        startActivity(intent);
    }

    public void openDrinks(View view) {
        Intent intent = new Intent(this, WhatsOn.class);
        intent.putExtra("type", "drinks");
        startActivity(intent);
    }

    public void openEnts(View view) {
        Intent intent = new Intent(this, WhatsOn.class);
        intent.putExtra("type", "ents");
        startActivity(intent);
    }

    public void openMusic(View view) {
        Intent intent = new Intent(this, WhatsOn.class);
        intent.putExtra("type", "music");
        startActivity(intent);
    }

    public void openGen(View view) {
        Intent intent = new Intent(this, General.class);
        startActivity(intent);
    }

    public void openComm(View view) {
        Intent intent = new Intent(this, Committee.class);
        startActivity(intent);
    }

    public void scheduleNotification(Context context, String type, int notificationId, String title, String content, int day, int hour, int min) {//delay is after how much time(in millis) from current time you want to schedule the notification
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(System.currentTimeMillis());
        calendar1.set(Calendar.DAY_OF_YEAR, day);
        calendar1.set(Calendar.HOUR_OF_DAY, hour);
        calendar1.set(Calendar.MINUTE, min);
        if (calendar1.getTimeInMillis() > System.currentTimeMillis()) {
            long delay = calendar1.getTimeInMillis() - System.currentTimeMillis();

            Intent intent = new Intent(context, MyNotificationPublisher.class);
            intent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, notificationId);
            intent.putExtra("title", title);
            intent.putExtra("content", content);
            intent.putExtra("type", type);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, notificationId, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            long futureInMillis = SystemClock.elapsedRealtime() + delay;
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
            }
        }
    }

    public void scheduleAlarmNotifications() {
        scheduleNotification(this,"ents", 1, "Kae Kurd", "Comedy headliner KAE KURD in the Hall in 5 minutes.", 172, 21, 55);
        scheduleNotification(this,"food", 2, "Mac n Cheese, Jack's Gelato and more!", "MAC N CHEESE at the Red Buildings, JACK'S GELATO at the Ivy Court and CUPCAKES on the Library Lawn.", 172, 22, 0);
        scheduleNotification(this,"ents", 3, "Dane Baptiste", "Comedy headliner DANE BAPTISTE in the Hall in 5 minutes.", 172, 22, 25);
        scheduleNotification(this,"ents", 4, "Kyla La Grange", "Headliner KYLA LA GRANGE on Main Stage, Bowling Green in 5 minutes.", 172, 22, 35);
        scheduleNotification(this,"food", 5, "Cheese, Wine and Waffles!", "CHEESE and WINE at the Outer Parlour and BELGIUM WAFFLES at the Library Lawn.", 172, 23, 0);
        scheduleNotification(this,"ents", 6, "Loyle Carner", "Headliner LOYLE CARNER on Main Stage, Bowling Green in 5 minutes.", 172, 23,55);
        scheduleNotification(this,"food", 7, "Doughnuts!", "DOUGHNUTS at the Foundress Lawn.", 173, 0, 0);
        scheduleNotification(this,"food", 8, "Breakfast!", "BREAKFAST PASTRIES at the Library Lawn and BACON BUTTIES at the Chapel Crevice.", 173, 2, 0);
    }
}
