package com.example.pav.trikalatourguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumFragment extends Fragment {

    public MuseumFragment(){
        // empty constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.tsitsani_museum, R.string.tsitsani_museum_description));
        places.add(new Place(R.string.historical_sport_museum, R.string.historical_sport_museum_description));
        places.add(new Place(R.string.photography_museum, R.string.photography_museum_description));
        places.add(new Place(R.string.milos, R.string.milos_description));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = places.get(position);
            }
        });

        return rootView;
    }
}
