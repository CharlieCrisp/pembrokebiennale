package uk.co.pembrokemayball.pembrokebiennale;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by charl on 14/06/2017.
 */

public class ListAdapter extends ArrayAdapter<WhatsOnItem> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<WhatsOnItem> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.itemlistrow, null);
        }

        WhatsOnItem p = getItem(position);

        if (p != null) {
            Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Didot.ttf");
            TextView tt1 = (TextView) v.findViewById(R.id.item_title);
            TextView tt2 = (TextView) v.findViewById(R.id.location);
            TextView tt3 = (TextView) v.findViewById(R.id.timing);
            TextView tt4 = (TextView) v.findViewById(R.id.description);

            if (tt1 != null) {
                tt1.setText(p.getTitle());
                tt1.setTypeface(font, Typeface.BOLD);
            }

            if (tt2 != null) {
                tt2.setText(p.getLocation());
                tt2.setTypeface(font);
            }

            if (tt3 != null) {
                tt3.setText(p.getTime());
                tt3.setTypeface(font);
            }
            if (tt4 != null) {
                tt4.setText(p.getDescription());
                tt4.setTypeface(font);
            }
        }

        return v;
    }

}