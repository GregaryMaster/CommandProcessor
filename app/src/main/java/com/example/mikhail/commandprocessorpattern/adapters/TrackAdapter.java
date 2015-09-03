package com.example.mikhail.commandprocessorpattern.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mikhail.commandprocessorpattern.R;
import com.example.mikhail.commandprocessorpattern.model.Track;

import java.util.List;

/**
 * Created by Mikhail on 19.07.2015.
 */
public class TrackAdapter extends ArrayAdapter<Track>{

    private static class ViewHolder{
        TextView titleText_;
        TextView descriptionText_;
        TextView durationText_;
        TextView lengthText_;
        ImageView icon_;
    }

    public TrackAdapter(Context context,List<Track> values){
        super(context,R.layout.track_list_item,values);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.track_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.titleText_ = (TextView) convertView.findViewById(R.id.track_title);
            viewHolder.descriptionText_ = (TextView) convertView.findViewById(R.id.track_description);
            viewHolder.durationText_ = (TextView) convertView.findViewById(R.id.track_duration);
            viewHolder.lengthText_ = (TextView) convertView.findViewById(R.id.track_length);
            viewHolder.icon_ = (ImageView) convertView.findViewById(R.id.track_icon);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleText_.setText(getItem(position).getTitle());
        viewHolder.descriptionText_.setText(getItem(position).getDescription());
        viewHolder.durationText_.setText(Double.toString(getItem(position).getDuration()));
        viewHolder.lengthText_.setText(Integer.toString(getItem(position).getLength()));

        if (getItem(position).getIcon()!= null) {
            Bitmap bmp1 = BitmapFactory.decodeByteArray(getItem(position).getIcon(), 0, getItem(position).getIcon().length);
            viewHolder.icon_.setImageBitmap(bmp1);
        }

        return convertView;
    }
}
