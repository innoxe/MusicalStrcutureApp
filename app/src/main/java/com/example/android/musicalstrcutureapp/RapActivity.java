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

public class RapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        setActionBar();

        // Lists of genre Rap musics
        ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music("Ebsa","Like it or Not","The Remixes","alb_17087","no_curator/Ebsa/HeartworK/Ebsa_-_03_-_Like_it_or_Not.mp3","03:27"));
        musics.add(new Music("CuzOH! Black Feat. Wordsmith","Stronger Living Feat Wordsmith","FrostWire Creative Commons Mixtape Vol. 6","alb_25097","FrostClick/CuzOH_Black_Feat_Wordsmith/FrostWire_Creative_Commons_Mixtape_Volume_4/CuzOH_Black_Feat_Wordsmith_-_05_-_Stronger_Living_Feat_Wordsmith.mp3","04:17"));
        musics.add(new Music("Kellee Maize & J. Glaze Productions","In Tune (J. Glaze Remix)","The Xmas Split","alb_22047","FrostClick/Kellee_Maize__J_Glaze_Productions/The_Remixes/Kellee_Maize__J_Glaze_Productions_-_01_-_In_Tune_J_Glaze_Remix.mp3","05:46"));
        musics.add(new Music("Melissa B.","Mind Frame","The Drop","alb_17422","FrostClick/Melissa_B/FrostWire_Creative_Commons_Mixtape_Vol_6/Melissa_B_-_02_-_Mind_Frame.mp3","03:33"));
        musics.add(new Music("Donnie Ozone","Christmas Shopping at the Dollar Store","Discrepância (Single)","alb_12842","blocSonic/Donnie_Ozone/The_Xmas_Split/Donnie_Ozone_-_01_-_Christmas_Shopping_at_the_Dollar_Store.mp3","01:25"));
        musics.add(new Music("Tickle","The Drop (Dalai Dahmer & Brad Manners Version)","The GxOD Prequel","alb_24153","no_curator/Tickle/The_Drop/Tickle_-_04_-_The_Drop_Dalai_Dahmer__Brad_Manners_Version.mp3","04:37"));
        musics.add(new Music("Oddish","Discrepância (part. Banha e Neto Bicho-$olto)","HeartworK","alb_17282","Subterranean_Records/Oddish/Discrepncia_Single/Oddish_-_01_-_Discrepncia_part_Banha_e_Neto_Bicho-olto.mp3","04:26"));
        musics.add(new Music("BenJamin Banger","Church","Tears of Joy","alb_10755","no_curator/BenJamin_Banger/The_GxOD_Prequel/BenJamin_Banger_-_11_-_Church.mp3","02:11"));
        musics.add(new Music("Ebsa","Remain Resolute","The Whole Ten","alb_24026","no_curator/Ebsa/HeartworK/Ebsa_-_04_-_Remain_Resolute.mp3","04:34"));
        musics.add(new Music("Ain't No Love","Champion Babylon","Tuning Into Paradise","alb_21198","FrostClick/Aint_No_Love/Tears_of_Joy/Aint_No_Love_-_06_-_Champion_Babylon.mp3","03:25"));

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

                Intent trackIntent = new Intent(RapActivity.this, TrackActivity.class);
                trackIntent.putExtra("artistName", artistName_temp);
                trackIntent.putExtra("titleAlbum", titleAlbum_temp);
                trackIntent.putExtra("trackTitle", trackTitle_temp);
                trackIntent.putExtra("trackImage", trackImage_temp);
                trackIntent.putExtra("trackFile", trackFile_temp);
                trackIntent.putExtra("trackDuration", trackDuration_temp);
                trackIntent.putExtra("musicGenre", "Rap");

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
        myAwesomeTextView.setText("Rap List");
    }

}
