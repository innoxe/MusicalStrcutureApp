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

public class RockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        setActionBar();

        // Lists of genre Rock musics
        ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music("Jahzzar","The last ones","Smoke Factory","alb_11354","no_curator/Jahzzar/Smoke_Factory_Excerpt/Jahzzar_-_01_-_The_last_ones.mp3","03:00"));
        musics.add(new Music("Silence Is Sexy","Holiday (instrumental)","Antique Instrumentals","alb_15618","ccCommunity/Silence_Is_Sexy/Antique_Instrumentals/Silence_Is_Sexy_-_01_-_Holiday_instrumental.mp3","04:34"));
        musics.add(new Music("Lame Drivers","Frozen Egg","Flexi-Book EP (preview)","alb_12299","WFMU/Lame_Drivers/Flexi-Book_EP_preview/Lame_Drivers_-_01_-_Frozen_Egg.mp3","02:11"));
        musics.add(new Music("Black Math","Suck City","Phantom Power","alb_5743","no_curator/Black_Math/Phantom_Power/Black_Math_-_03_-_Suck_City.mp3","02:04"));
        musics.add(new Music("John Wesley Coleman","Tequila 10 Seconds","Live at WFMU's Cherry Blossom Clinic 10/9/2010","alb_7528","WFMU/John_Wesley_Coleman/Live_at_WFMUs_Cherry_Blossom_Clinic_1092010/John_Wesley_Coleman_-_07_-_Tequila_10_Seconds.mp3","00:22"));
        musics.add(new Music("Roberto Billi","Sfioro","Modernamente Demodé","alb_11184","WFMU/Roberto_Billi/Modernamente_Demod/Roberto_Billi_-_01_-_Sfioro.mp3","04:05"));
        musics.add(new Music("Seth Partridge","Sing We Now Of Christmas","Yuletide Entertainments (2012)","alb_15667","WFMU/Seth_Partridge/Yuletide_Entertainments_2012/Seth_Partridge_-_03_-_Sing_We_Now_Of_Christmas.mp3","03:40"));
        musics.add(new Music("Jahzzar","Last Dance","Blinded by Dust","alb_11371","no_curator/Jahzzar/Blinded_by_Dust_Excerpt/Jahzzar_-_16_-_Last_Dance.mp3","03:00"));
        musics.add(new Music("Jahzzar","Look inside","Smoke Factory","alb_11354","no_curator/Jahzzar/Smoke_Factory_Excerpt/Jahzzar_-_04_-_Look_inside.mp3","03:43"));
        musics.add(new Music("Jahzzar","Roads that burned our boots","Blinded by Dust","alb_11371","no_curator/Jahzzar/Blinded_by_Dust_Excerpt/Jahzzar_-_01_-_Roads_that_burned_our_boots.mp3","03:10"));

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

                Intent trackIntent = new Intent(RockActivity.this, TrackActivity.class);
                trackIntent.putExtra("artistName", artistName_temp);
                trackIntent.putExtra("titleAlbum", titleAlbum_temp);
                trackIntent.putExtra("trackTitle", trackTitle_temp);
                trackIntent.putExtra("trackImage", trackImage_temp);
                trackIntent.putExtra("trackFile", trackFile_temp);
                trackIntent.putExtra("trackDuration", trackDuration_temp);
                trackIntent.putExtra("musicGenre", "Rock");

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
        myAwesomeTextView.setText("Rock List");
    }


}
