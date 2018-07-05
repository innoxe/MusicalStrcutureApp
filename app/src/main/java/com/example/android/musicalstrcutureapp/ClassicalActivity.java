package com.example.android.musicalstrcutureapp;

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

public class ClassicalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        setActionBar();

        // Lists of genre Classical musics
        ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music("Kai Engel","Moonlight Reprise","Irsen's Tale","alb_14891","ccCommunity/Kai_Engel/Irsens_Tale/Kai_Engel_-_04_-_Moonlight_Reprise.mp3","03:01"));
        musics.add(new Music("Kevin MacLeod","Ghost Dance","Classical Sampler","alb_9615","no_curator/Kevin_MacLeod/Classical_Sampler/Kevin_MacLeod_-_Ghost_Dance.mp3","01:13"));
        musics.add(new Music("Lee Maddeford","Le petit jardin (with Les Gauchers Orchestra)","Instrumentals 1","alb_5075","Oddio_Overplay/Lee_Maddeford/Instrumentals_1/Lee_Maddeford_-_09_-_Le_petit_jardin_with_Les_Gauchers_Orchestra.mp3","02:47"));
        musics.add(new Music("Fabrizio Paterlini","Veloma","netBloc Vol. 30: aldartea","alb_7767","blocSonic/Fabrizio_Paterlini/netBloc_Vol_30_aldartea/Fabrizio_Paterlini_-_01_-_Veloma.mp3","02:54"));
        musics.add(new Music("Dexter Britain","Seeing The Future","Creative Commons Vol. 2","alb_11989","ccCommunity/Dexter_Britain/Creative_Commons_Volume_2/Dexter_Britain_-_05_-_Seeing_The_Future.mp3","02:28"));
        musics.add(new Music("Peter Rudenko","Snowing","15 Etudes","alb_11839","ccCommunity/Peter_Rudenko/15_Etudes/Peter_Rudenko_-_12_-_Snowing.mp3","02:22"));
        musics.add(new Music("Dexter Britain","Wonderland (Instrumental)","Creative Commons Vol. 2","alb_11989","ccCommunity/Dexter_Britain/Creative_Commons_Volume_2/Dexter_Britain_-_11_-_Wonderland_Instrumental.mp3","03:20"));
        musics.add(new Music("Dexter Britain","Summers Coming","Creative Commons Vol. 2","alb_11989","ccCommunity/Dexter_Britain/Creative_Commons_Volume_2/Dexter_Britain_-_06_-_Summers_Coming.mp3","03:16"));
        musics.add(new Music("Dexter Britain","Waking Up (Instrumental)","Creative Commons Vol. 2","alb_11989","ccCommunity/Dexter_Britain/Creative_Commons_Volume_2/Dexter_Britain_-_10_-_Waking_Up_Instrumental.mp3","03:40"));
        musics.add(new Music("Dexter Britain","The Time To Run (Finale)","Creative Commons Volume. 5","alb_13062","Music_for_Video/Dexter_Britain/Creative_Commons_Volume_5/Dexter_Britain_-_01_-_The_Time_To_Run_Finale.mp3","06:48"));

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

                Intent trackIntent = new Intent(ClassicalActivity.this, TrackActivity.class);
                trackIntent.putExtra("artistName", artistName_temp);
                trackIntent.putExtra("titleAlbum", titleAlbum_temp);
                trackIntent.putExtra("trackTitle", trackTitle_temp);
                trackIntent.putExtra("trackImage", trackImage_temp);
                trackIntent.putExtra("trackFile", trackFile_temp);
                trackIntent.putExtra("trackDuration", trackDuration_temp);
                trackIntent.putExtra("musicGenre", "Classical");

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
        myAwesomeTextView.setText("Classical List");
    }

}
