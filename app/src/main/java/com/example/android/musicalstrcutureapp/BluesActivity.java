package com.example.android.musicalstrcutureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BluesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        setActionBar();

        // Lists of genre Blues musics
        ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music("U.S. Army Blues", "Walk That Dog", "Live At Blues Alley", "blues_79885", "Oddio_Overplay/US_Army_Blues/Live_At_Blues_Alley/US_Army_Blues_-_11_-_Walk_That_Dog.mp3", "03:45"));
        musics.add(new Music("Robin Grey", "Every Waking Hour (Instrumental)", "Instrumentals", "blues_82565", "Music_for_Video/Robin_Grey/Instrumentals/Robin_Grey_-_02_-_Every_Waking_Hour_Instrumental.mp3", "04:46"));
        musics.add(new Music("Arne Bang Huseby", "Stormy Blues", "Chapter Two / Mild", "blues_61487", "ccCommunity/Arne_Bang_Huseby/Arne_Bang_Huseby_-_Singles/Arne_Bang_Huseby_-_Stormy_Blues.mp3", "02:25"));
        musics.add(new Music("Kai Engel", "Something (Bonus Track)", "ICD-10", "blues_133763", "ccCommunity/Kai_Engel/Chapter_Two__Mild/Kai_Engel_-_09_-_Something_Bonus_Track.mp3", "04:31"));
        musics.add(new Music("Kai Engel", "Anxiety", "Jungle Love Revisited", "blues_136366", "ccCommunity/Kai_Engel/ICD-10/Kai_Engel_-_02_-_Anxiety.mp3", "02:46"));
        musics.add(new Music("The New Mystikal Troubadours", "Tonight: A Lonely Century", "East St. Louis Blues", "blues_72726", "no_curator/The_New_Mystikal_Troubadours/Jungle_Love_Revisited/The_New_Mystikal_Troubadours_-_07_-_Tonight_A_Lonely_Century.mp3", "03:45"));
        musics.add(new Music("Kathleen Martin", "East St. Louis Blues (Damien Riba piano)", "Home (Excerpt)", "blues_127089", "WFMU/Kathleen_Martin/East_St_Louis_Blues/Kathleen_Martin_-_East_St_Louis_Blues_Damien_Riba_piano.mp3", "02:20"));
        musics.add(new Music("Jahzzar", "Railroad's Whiskey Co", "Nice to Be Naughty", "blues_62431", "no_curator/Jahzzar/Home_Excerpt/Jahzzar_-_05_-_Railroads_Whiskey_Co.mp3", "03:47"));
        musics.add(new Music("Kathleen Martin", "Nice to Be Naughty [all Kat]", "", "blues_131577", "WFMU/Kathleen_Martin/Nice_to_Be_Naughty/Kathleen_Martin_-_02_-_Nice_to_Be_Naughty_all_Kat.mp3", "03:13"));
        musics.add(new Music("Sul Rebel", "Rebel Blues", "", "blues_62338", "ccCommunity/Sul_Rebel/Sul_Rebel_-_Singles/Sul_Rebel_-_Rebel_Blues.mp3", "02:05"));

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

                Intent trackIntent = new Intent(BluesActivity.this, TrackActivity.class);
                trackIntent.putExtra("artistName", artistName_temp);
                trackIntent.putExtra("titleAlbum", titleAlbum_temp);
                trackIntent.putExtra("trackTitle", trackTitle_temp);
                trackIntent.putExtra("trackImage", trackImage_temp);
                trackIntent.putExtra("trackFile", trackFile_temp);
                trackIntent.putExtra("trackDuration", trackDuration_temp);
                trackIntent.putExtra("musicGenre", "Blues");

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
        myAwesomeTextView.setText("Blues List");
    }
}
