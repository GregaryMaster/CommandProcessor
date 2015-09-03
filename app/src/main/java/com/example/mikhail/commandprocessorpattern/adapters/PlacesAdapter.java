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
import com.example.mikhail.commandprocessorpattern.model.Place;

import java.util.List;

/**
 * Created by Mikhail on 19.07.2015.
 */
public class PlacesAdapter extends ArrayAdapter<Place>{

    private static class ViewHolder{
        TextView titleText_;
        TextView descriptionText_;
        ImageView icon_;
    }

    public PlacesAdapter(Context context,List<Place> values){
        super(context,R.layout.place_list_item,values);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.place_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.titleText_ = (TextView) convertView.findViewById(R.id.place_title);
            viewHolder.descriptionText_ = (TextView) convertView.findViewById(R.id.place_description);
            viewHolder.icon_ = (ImageView) convertView.findViewById(R.id.place_icon);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleText_.setText(getItem(position).getTitle());
        viewHolder.descriptionText_.setText(getItem(position).getShortDescription());

        if (getItem(position).getIcon() != null ){
            Bitmap bmp1 = BitmapFactory.decodeByteArray(getItem(position).getIcon(), 0, getItem(position).getIcon().length);
            viewHolder.icon_.setImageBitmap(bmp1);
        }

        return convertView;
    }
}
