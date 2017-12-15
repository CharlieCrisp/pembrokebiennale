package uk.co.pembrokemayball.pembrokebiennale;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;

public class MyNotificationPublisher extends BroadcastReceiver {

    public static String NOTIFICATION_ID = "notification_id";
    public static String NOTIFICATION = "notification";

    @Override
    public void onReceive(final Context context, Intent intent) {

        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String type = intent.getStringExtra("type");
        int notificationId = intent.getIntExtra(NOTIFICATION_ID, 0);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(context, WhatsOn.class);
        intent1.putExtra("type", type);
        PendingIntent pIntent = null;
        int iUniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
        pIntent = PendingIntent.getActivity(context, iUniqueId, intent1, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.bird)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        Notification notification = builder.build();
        notificationManager.notify(notificationId, notification);
    }
}
