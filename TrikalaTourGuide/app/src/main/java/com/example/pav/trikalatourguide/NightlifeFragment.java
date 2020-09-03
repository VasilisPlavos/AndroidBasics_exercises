package com.example.pav.trikalatourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NightlifeFragment extends Fragment {

    public NightlifeFragment(){
        // empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.eleven, R.string.eleven_description));
        places.add(new Place(R.string.skala, R.string.skala_description));
        places.add(new Place(R.string.kripti, R.string.kripti_description));
        places.add(new Place(R.string.madragora, R.string.madragora_description));

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
