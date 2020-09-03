package com.example.pav.trikalatourguide;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RecommendedFragment extends Fragment {

    public RecommendedFragment(){
        // empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.meteora, R.string.meteora_description, R.drawable.meteora));
        places.add(new Place(R.string.pertouli, R.string.pertouli_description, R.drawable.pertouli));
        places.add(new Place(R.string.plastira, R.string.plastira_description, R.drawable.plastira));
        places.add(new Place(R.string.trikala, R.string.trikala_description, R.drawable.trikala));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Place place = places.get(position);
            }
        });
        return rootView;
    }
}
