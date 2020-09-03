package com.example.pav.trikalatourguide;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CafeFragment extends Fragment {
    public CafeFragment(){
        // empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create list of Cafe places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.barrouge, R.string.barrouge_description));
        places.add(new Place(R.string.eightball, R.string.eightball_description));
        places.add(new Place(R.string.kataraktis, R.string.kataraktis_description));
        places.add(new Place(R.string.sante, R.string.sante_description));

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
