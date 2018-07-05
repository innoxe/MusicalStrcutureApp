package com.example.android.musicalstrcutureapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class TrackActivity extends AppCompatActivity implements View.OnClickListener {

    android.support.v7.widget.Toolbar actionBarToolbar;
    ImageButton like;
    private MediaPlayer mediaPlayer;
    // Initialize Boolean for control if button play at first time
    private Boolean b = false;
    private String trackFileSource;
    private String artistName;
    private String trackTitle;
    private String titleAlbum;
    private String musicGenre;
    private String trackImage;
    private TextView loading;
    private ImageButton btnPlay;
    private SeekBar seekBar;
    private Handler handler;
    private TextView currentTime;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            updateSeekBar();
        }
    };
    private int bufferingLevel;

    /*
     * Hide default ActionBar and set custom one
     */
    public void setActionBar() {
        // Hide the default toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //getSupportActionBar().hide();
        // Get widget toolbar ID
        actionBarToolbar = findViewById(R.id.my_toolbar);
        //Set back return arrow
        actionBarToolbar.setNavigationIcon(R.drawable.back_arrow);
        actionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handleOnBackPress();
                finish();
            }
        });
        // Set the title of toolbar with music genre
        actionBarToolbar.setTitle(musicGenre);
    }

    /*
     * Set the view of album image
     */
    public void setImageAlbum() {
        int resId = getResources().getIdentifier(
                trackImage,
                "drawable",
                getPackageName()
        );
        //Check if portrait orientation
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Set the background album image of parent view.
            RelativeLayout imageAlbumView = (RelativeLayout) findViewById(R.id.parent_view);
            imageAlbumView.setBackgroundResource(resId);
        } else {
            ImageView imageAlbumView = (ImageView) findViewById(R.id.single_track_image);
            imageAlbumView.setImageResource(resId);

        }

    }

    /*
     * Set TextView of track
     */
    public void setTextAlbum() {
        TextView singleTrackTextView = (TextView) findViewById(R.id.single_track_title);
        singleTrackTextView.setText(trackTitle);
        TextView artistNameTextView = (TextView) findViewById(R.id.artist_name);
        artistNameTextView.setText(artistName);
        TextView albumTextView = (TextView) findViewById(R.id.album_title);
        albumTextView.setText("Album: " + titleAlbum);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        Intent intent = getIntent();
        artistName = intent.getExtras().getString("artistName");
        trackTitle = intent.getExtras().getString("trackTitle");
        titleAlbum = intent.getExtras().getString("titleAlbum");
        trackImage = intent.getExtras().getString("trackImage");
        String trackFile = intent.getExtras().getString("trackFile");
        String trackDuration = intent.getExtras().getString("trackDuration");
        musicGenre = intent.getExtras().getString("musicGenre");

        trackFileSource = "https://files.freemusicarchive.org/music/" + trackFile;

        //Call the functions to set image and text layout
        setActionBar();
        setImageAlbum();
        setTextAlbum();

        /*
         * Prepare the control buttons section and set them with events
         */
        //Call the class MakeShape to round the corner of view and set background color
        LinearLayout sectionBtnView = (LinearLayout) findViewById(R.id.btn_section);
        sectionBtnView.setBackgroundDrawable(new MakeShape().rounded(Color.TRANSPARENT, Color.WHITE, 1, 50));

        // Find the view for every buttons
        ImageButton btnPrev = (ImageButton) findViewById(R.id.btnPrevious);
        ImageButton btnBack = (ImageButton) findViewById(R.id.btnBackward);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        ImageButton btnStop = (ImageButton) findViewById(R.id.btnStop);
        ImageButton btnForward = (ImageButton) findViewById(R.id.btnForward);
        ImageButton btnNext = (ImageButton) findViewById(R.id.btnNext);
        like = (ImageButton) findViewById(R.id.like);
        //Set the event for every buttons
        btnPrev.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnForward.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        like.setOnClickListener(this);


        mediaPlayer = new MediaPlayer();
        // When the play finished set the ImageButton to "play" image.
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                stopAudio();
            }

        });
        // This register a callback to invoke when the track si ready for playback
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(mediaPlayer.getDuration());
                updateSeekBar();

                // Manage the buffer update and relative text to display
                mp.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                    @Override
                    public void onBufferingUpdate(MediaPlayer mp, int percent) {
                        double ratio = percent / 100.0;
                        bufferingLevel = (int) (mp.getDuration() * ratio);
                        loading.setText("Buffering update " + percent + "%");
                        seekBar.setSecondaryProgress(bufferingLevel);
                        // Remove callback to buffering, display 100% and call function for credits
                        if (percent == 100) {
                            mp.setOnBufferingUpdateListener(null);
                            //Display that have completed buffering
                            loading.setText("Buffering 100%");
                            //Hide after 3 seconds
                            loading.postDelayed(new Runnable() {
                                public void run() {
                                    loading.setVisibility(View.INVISIBLE);
                                    showMention();
                                }
                            }, 3000);
                        }
                    }
                });
            }
        });

        /*
         * Section SeekBar and relative next TextView
         */
        // Find the view that will show "Loading" and "Buffering" text
        loading = findViewById(R.id.loading);
        //Find the view of duration and set the tradkDuration text
        TextView durationTime = findViewById(R.id.durationTime);
        durationTime.setText(trackDuration);
        //Initialize the current time to 0:00
        currentTime = (TextView) findViewById(R.id.currentTime);
        currentTime.setText("0:00");
        // Set Seekbar
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        handler = new Handler();
        seekBar.setMax(mediaPlayer.getDuration());
    }

    // Update Seekbar
    private void updateSeekBar() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        currentTime.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));
        handler.postDelayed(runnable, 1000);
    }

    /*
     * Function to convert milliseconds to time format
     */
    private String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";
        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    /*
     * Function that manage onClick event for icons and image buttons of the layout
     */
    @Override
    public void onClick(View view) {
        view.setSelected(!view.isSelected());
        switch (view.getId()) {
            case R.id.like:
                if (view.isSelected()) {
                    //Handle selected state change
                    like.setBackgroundResource(R.drawable.like_add);
                    Toast.makeText(getApplicationContext(), "Added to your favorites.", Toast.LENGTH_SHORT).show();
                } else {
                    //Handle de-select state change
                    like.setBackgroundResource(R.drawable.like);
                    Toast.makeText(getApplicationContext(), "Delete from your favorites.", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnPrevious:
                Toast.makeText(getApplicationContext(), "Pressed Previous Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBackward:
                Toast.makeText(getApplicationContext(), "Pressed Backward Button", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnForward:
                Toast.makeText(getApplicationContext(), "Pressed Forward Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnNext:
                Toast.makeText(getApplicationContext(), "Pressed Next Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnStop:
                stopAudio();
                break;
            case R.id.btnPlay:
                //ImageButton btnPlay = (ImageButton) findViewById(R.id.btnPlay);
                if (mediaPlayer.isPlaying()) {
                    btnPlay.setImageResource(R.drawable.btn_play);
                    // Pause the music player
                    mediaPlayer.pause();
                } else {
                    // Set the view btnPlay with pause image
                    btnPlay.setImageResource(R.drawable.btn_pause);
                    // If is the first play (b = false)
                    if (!b) {
                        // Show text loading
                        loading.setText("Loading...");
                        //Start Player
                        Handler handler = new Handler();
                        // A minimum of delay necessary to display button and text before to play
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    playAudio(trackFileSource);
                                    mediaPlayer.start();
                                    updateSeekBar();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 100);
                        b = true;
                    } else {
                        mediaPlayer.start();
                    }
                }
                break;
        }
    }

    private void stopAudio() {

        btnPlay.setImageResource(R.drawable.btn_play);
        b = false;
        currentTime.setText("0:00");
        mediaPlayer.reset();
        handler.removeCallbacks(runnable);
        seekBar.setProgress(0);
    }

    /*
     * Function dedicate to set source e prepare mediaPlayer.
     */
    private void playAudio(String url) throws Exception {
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare();
    }

    /*
     * Clean up and release some things before close the activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        killMediaPlayer();
    }

    private void killMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                //mediaPlayer.release();
                mediaPlayer.stop();
                mediaPlayer.reset();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * Set the text for the credits
     */
    private void showMention() {
        String credits = "From <a href=http://freemusicarchive.org/ >freemusicarchive.org</a>";
        loading.setText(Html.fromHtml(credits));
        loading.setMovementMethod(LinkMovementMethod.getInstance());
        loading.postDelayed(new Runnable() {
            public void run() {
                loading.setVisibility(View.VISIBLE);
                loading.setClickable(true);

            }
        }, 3000);

    }

}
