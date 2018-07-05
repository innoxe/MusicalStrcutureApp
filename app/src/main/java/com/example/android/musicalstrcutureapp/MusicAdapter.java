package com.example.android.musicalstrcutureapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by INNOCENZO on 26/03/2018.
 */

public class MusicAdapter extends ArrayAdapter<Music> {



    public MusicAdapter(Context context, ArrayList<Music> musics) {
        super(context, 0, musics);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Music} object located at this position in the list
        Music currentMusic = getItem(position);


        // Find the ID of the image in the ImageView list_item.xml and put the small image
        ImageView imageImageView = (ImageView) listItemView.findViewById(R.id.image);
        int resId = context.getResources().getIdentifier(
                currentMusic.getTrackImage()+"_s",
                "drawable",
                context.getPackageName()
        );


        // Get the image from the currentMusic object and set src on the his ImageView
        imageImageView.setImageResource(resId);

        // Find the ID track_title in the TextView list_item.xml
        TextView trackTextView = (TextView) listItemView.findViewById(R.id.track_title);
        // Get the Track Title from the currentMusic object and set it on the his TextView
        trackTextView.setText(currentMusic.getTrackTitle());

        // Find the ID artist_name in the TextView list_item.xml
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the Artist Name from the currentMusic object and set it on the his TextView
        artistTextView.setText(currentMusic.getArtistName());

        // Find the ID track duration in the TextView list_item.xml
        TextView durationTextView = (TextView) listItemView.findViewById(R.id.track_duration);
        // Get the track duration from the currentMusic object and set it on the his TextView
        durationTextView.setText(currentMusic.getTrackDuration());



        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
