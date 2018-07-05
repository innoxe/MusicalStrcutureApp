package com.example.android.musicalstrcutureapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        setActionBar();

        // Lists of genre Pop musics
        ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music("Jahzzar","Siesta","Traveller's Guide","alb_11355","no_curator/Jahzzar/Travellers_Guide_Excerpt/Jahzzar_-_05_-_Siesta.mp3","02:19"));
        musics.add(new Music("The Kyoto Connection","Hachiko (The Faithtful Dog)","Wake Up","alb_14345","ccCommunity/The_Kyoto_Connection/Wake_Up/The_Kyoto_Connection_-_09_-_Hachiko_The_Faithtful_Dog.mp3","03:05"));
        musics.add(new Music("Waylon Thornton","Favorite Secrets","Mystery Club","alb_8371","no_curator/Mystery_Club/02_-_Favorite_Secrets.mp3","01:15"));
        musics.add(new Music("Silence Is Sexy","Holiday (instrumental)","Antique Instrumentals","alb_15618","ccCommunity/Silence_Is_Sexy/Antique_Instrumentals/Silence_Is_Sexy_-_01_-_Holiday_instrumental.mp3","04:34"));
        musics.add(new Music("Jahzzar","Take Me Higher","Tumbling Dishes Like Old-Man's Wishes","alb_16163","Music_for_Video/Jahzzar/Tumbling_Dishes_Like_Old-Mans_Wishes/Jahzzar_-_10_-_Take_Me_Higher.mp3","02:55"));
        musics.add(new Music("Jahzzar","Little Chance","Tumbling Dishes Like Old-Man's Wishes","alb_16163","Music_for_Video/Jahzzar/Tumbling_Dishes_Like_Old-Mans_Wishes/Jahzzar_-_07_-_Little_Chance.mp3","03:57"));
        musics.add(new Music("Holy Coast","The Beach! The Beach!","Self Titled","alb_8378","no_curator/Holy_Coast/Self_Titled/Holy_Coast_-_08_-_The_Beach_The_Beach.mp3","02:16"));
        musics.add(new Music("David Szesztay","Cheese","Commercial","alb_20211","Music_for_Video/David_Szesztay/Commercial/David_Szesztay_-_Cheese.mp3","00:31"));
        musics.add(new Music("Jahzzar","Green Lights","Tumbling Dishes Like Old-Man's Wishes","alb_16163","Music_for_Video/Jahzzar/Tumbling_Dishes_Like_Old-Mans_Wishes/Jahzzar_-_02_-_Green_Lights.mp3","02:58"));
        musics.add(new Music("Lame Drivers","Frozen Egg","Flexi-Book EP (preview)","alb_12299","WFMU/Lame_Drivers/Flexi-Book_EP_preview/Lame_Drivers_-_01_-_Frozen_Egg.mp3","02:11"));

        // Create an {@link MusicAdapter}, whose data source is a list of {@link music}s.
        MusicAdapter adapter = new MusicAdapter(this, musics);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link MusicAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Music} in the list.
        listView.setAdapter(adapter);


        // Prepare the data and start activity for the single music track
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Music selectedTrack = (Music) parent.getItemAtPosition(position);
                String artistName_temp = selectedTrack.getArtistName();
                String titleAlbum_temp = selectedTrack.getTitleAlbum();
                String trackTitle_temp = selectedTrack.getTrackTitle();
                String trackImage_temp = selectedTrack.getTrackImage();
                String trackDuration_temp = selectedTrack.getTrackDuration();
                String trackFile_temp = selectedTrack.getTrackFile();

                Intent trackIntent = new Intent(PopActivity.this, TrackActivity.class);
                trackIntent.putExtra("artistName", artistName_temp);
                trackIntent.putExtra("titleAlbum", titleAlbum_temp);
                trackIntent.putExtra("trackTitle", trackTitle_temp);
                trackIntent.putExtra("trackImage", trackImage_temp);
                trackIntent.putExtra("trackFile", trackFile_temp);
                trackIntent.putExtra("trackDuration", trackDuration_temp);
                trackIntent.putExtra("musicGenre", "Pop");

                startActivity(trackIntent);
            }
        });
    }

    /*
     * Method that set custom action bar and relative title and events
     */
    public void setActionBar(){
        android.support.v7.widget.Toolbar actionBarToolbar;
        // Get widget toolbar ID
        actionBarToolbar = findViewById(R.id.my_toolbar);
        //Set back return arrow
        actionBarToolbar.setNavigationIcon(R.drawable.back_arrow);
        actionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Set the title of toolbar
        TextView myAwesomeTextView = (TextView)findViewById(R.id.list_title);
        myAwesomeTextView.setText("Pop List");
    }

}
