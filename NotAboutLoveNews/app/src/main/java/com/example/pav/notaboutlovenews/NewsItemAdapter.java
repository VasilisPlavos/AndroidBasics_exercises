package com.example.pav.notaboutlovenews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsItemAdapter extends ArrayAdapter<NewsItem> {



    public NewsItemAdapter(Context context, List<NewsItem> newsItems){
        super(context, 0, newsItems);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.sex_news_list_item, parent, false
            );
        }

        NewsItem currentNewsItem = getItem(position);

        TextView headlineView = (TextView) listItemView.findViewById(R.id.headline);
        headlineView.setText(currentNewsItem.getHeadline());

        TextView sectionView = (TextView) listItemView.findViewById(R.id.sectionName);
        sectionView.setText(currentNewsItem.getSectionName());


        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(currentNewsItem.getWebPublicationDate().toString());


        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(currentNewsItem.getAuthor());


        return listItemView;

    }
}
