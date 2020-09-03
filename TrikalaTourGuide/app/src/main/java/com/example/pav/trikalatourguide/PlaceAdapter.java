package com.example.pav.trikalatourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Context context, ArrayList<Place> places){
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        placeTextView.setText(currentPlace.getPlaceTitleId());
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        descriptionTextView.setText(currentPlace.getPlaceDescriptionId());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentPlace.hasImage()){
            imageView.setImageResource(currentPlace.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
