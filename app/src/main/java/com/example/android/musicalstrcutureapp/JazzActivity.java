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

public class JazzActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        setActionBar();

        // Lists of genre Jazz musics
        ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music("Stephan Siebert","Night Owl","Directionless EP","alb_8952","WFMU/Broke_For_Free/Directionless_EP/Broke_For_Free_-_01_-_Night_Owl.mp3","03:14"));
        musics.add(new Music("Obsibilo","Enthusiast","Enthusiast","alb_13709","no_curator/Tours/Enthusiast/Tours_-_01_-_Enthusiast.mp3","02:51"));
        musics.add(new Music("Revolution Void","Siesta","Traveller's Guide","alb_7876","no_curator/Jahzzar/Travellers_Guide_Excerpt/Jahzzar_-_05_-_Siesta.mp3","02:19"));
        musics.add(new Music("Quantum Jazz","It's Your Birthday!","Entries","alb_11636","WFMU/Monk_Turner__Fascinoma/The_New_Birthday_Song_Contest/Monk_Turner__Fascinoma_-_01_-_Its_Your_Birthday.mp3","00:36"));
        musics.add(new Music("Kevin MacLeod","Epic Song","Nameless: The Hackers RPG Soundtrack","alb_9619","ccCommunity/BoxCat_Games/Nameless_The_Hackers_RPG_Soundtrack/BoxCat_Games_-_10_-_Epic_Song.mp3","00:54"));
        musics.add(new Music("Revolution Void","Hachiko (The Faithtful Dog)","Wake Up","alb_7876","ccCommunity/The_Kyoto_Connection/Wake_Up/The_Kyoto_Connection_-_09_-_Hachiko_The_Faithtful_Dog.mp3","03:05"));
        musics.add(new Music("Jared C. Balogh","Fater Lee","Free Beats Sel. 3","alb_10080","Music_for_Video/Black_Ant/Free_Beats_Sel_3/Black_Ant_-_01_-_Fater_Lee.mp3","02:23"));
        musics.add(new Music("Kriss","RUNNING WATERS","Audionautix: Acoustic","alb_4931","ccCommunity/Jason_Shaw/Audionautix_Acoustic/Jason_Shaw_-_RUNNING_WATERS.mp3","02:46"));
        musics.add(new Music("Kevin MacLeod","Springish","...Plays Guitar","alb_9619","WFMU/Gillicuddy/Plays_Guitar/Gillicuddy_-_05_-_Springish.mp3","02:23"));
        musics.add(new Music("Kevin MacLeod","Starling","Solo Instruments","alb_9619","Music_for_Video/Podington_Bear/Solo_Instruments/Podington_Bear_-_Starling.mp3","01:45"));

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

                Intent trackIntent = new Intent(JazzActivity.this, TrackActivity.class);
                trackIntent.putExtra("artistName", artistName_temp);
                trackIntent.putExtra("titleAlbum", titleAlbum_temp);
                trackIntent.putExtra("trackTitle", trackTitle_temp);
                trackIntent.putExtra("trackImage", trackImage_temp);
                trackIntent.putExtra("trackFile", trackFile_temp);
                trackIntent.putExtra("trackDuration", trackDuration_temp);
                trackIntent.putExtra("musicGenre", "Jazz");

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
        myAwesomeTextView.setText("Jazz List");
    }

}
