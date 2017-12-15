package uk.co.pembrokemayball.pembrokebiennale;

import android.support.annotation.NonNull;

/**
 * Created by charl on 14/06/2017.
 */

public class WhatsOnItem implements Comparable<WhatsOnItem>{
    public String Title;
    public String Location;
    public String Time;
    public String Description;
    public int startTime;
    public int endTime;

    public WhatsOnItem(String title, String location, String time, String description, int startTime, int endTime) {
        Title = title;
        Location = location;
        Time = time;
        Description = description;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public String getTitle() {
        return Title;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return Location;
    }

    public String getTime() {
        return Time;
    }

    public String getDescription() {
        return Description;
    }


    @Override
    public int compareTo(@NonNull WhatsOnItem o) {
        if (o.getStartTime()== this.startTime) {
            return this.endTime - o.getEndTime();
        }
        return startTime-o.getStartTime();
    }
}
