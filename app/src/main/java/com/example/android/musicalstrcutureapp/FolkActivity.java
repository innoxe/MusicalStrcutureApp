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

public class FolkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        setActionBar();

        // Lists of genre Folk musics
        ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music("Jason Shaw","RUNNING WATERS","Audionautix: Acoustic","alb_9870","ccCommunity/Jason_Shaw/Audionautix_Acoustic/Jason_Shaw_-_RUNNING_WATERS.mp3","02:46"));
        musics.add(new Music("Gillicuddy","Springish","...Plays Guitar","alb_11876","WFMU/Gillicuddy/Plays_Guitar/Gillicuddy_-_05_-_Springish.mp3","02:23"));
        musics.add(new Music("Dan Lerch","O Tannenbaum","A Very Badgerland Christmas (2011)","alb_15669","ccCommunity/Dan_Lerch/A_Very_Badgerland_Christmas_2011/Dan_Lerch_-_09_-_O_Tannenbaum.mp3","01:16"));
        musics.add(new Music("Jahzzar","Take Me Higher","Tumbling Dishes Like Old-Man's Wishes","alb_16163","Music_for_Video/Jahzzar/Tumbling_Dishes_Like_Old-Mans_Wishes/Jahzzar_-_10_-_Take_Me_Higher.mp3","02:55"));
        musics.add(new Music("Gillicuddy","Jupiter the Blue","...Plays Guitar","alb_11876","WFMU/Gillicuddy/Plays_Guitar/Gillicuddy_-_01_-_Jupiter_the_Blue.mp3","02:27"));
        musics.add(new Music("Live Action Fezz","Carol of the Bells","A Very Badgerland Christmas (2011)","alb_15669","no_curator/Live_Action_Fezz/A_Very_Badgerland_Christmas_2011/Live_Action_Fezz_-_15_-_Carol_of_the_Bells.mp3","04:20"));
        musics.add(new Music("Chan Wai Fat","Dream (instrumental)","Children of Soul Mountain (original soundtrack)","alb_6232","Oddio_Overplay/Chan_Wai_Fat/Children_of_Soul_Mountain_original_soundtrack/Chan_Wai_Fat_-_05_-_Dream_instrumental.mp3","02:02"));
        musics.add(new Music("Jason Shaw","SOLO ACOUSTIC GUITAR","Audionautix: Acoustic","alb_9870","ccCommunity/Jason_Shaw/Audionautix_Acoustic/Jason_Shaw_-_SOLO_ACOUSTIC_GUITAR.mp3","03:11"));
        musics.add(new Music("The Upsidedown","E-Love","Dead Bees records label sampler #11","alb_11895","Dead_Bees_Records/The_Upsidedown/Dead_Bees_records_label_sampler_11/The_Upsidedown_-_21_-_E-Love.mp3","05:25"));
        musics.add(new Music("Jahzzar","Little Chance","Tumbling Dishes Like Old-Man's Wishes","alb_16163","Music_for_Video/Jahzzar/Tumbling_Dishes_Like_Old-Mans_Wishes/Jahzzar_-_07_-_Little_Chance.mp3","03:57"));

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

                Intent trackIntent = new Intent(FolkActivity.this, TrackActivity.class);
                trackIntent.putExtra("artistName", artistName_temp);
                trackIntent.putExtra("titleAlbum", titleAlbum_temp);
                trackIntent.putExtra("trackTitle", trackTitle_temp);
                trackIntent.putExtra("trackImage", trackImage_temp);
                trackIntent.putExtra("trackFile", trackFile_temp);
                trackIntent.putExtra("trackDuration", trackDuration_temp);
                trackIntent.putExtra("musicGenre", "Folk");

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
        myAwesomeTextView.setText("Folk List");
    }

}
