package com.example.android.musicalstrcutureapp;

/**
 * Created by INNOCENZO on 24/03/2018.
 */

public class Music {

    /** Artist Name  */
    private String mArtistName;

    /** Track Title */
    private String mTrackTitle;

    /** Title Album */
    private String mTitleAlbum;

    /** Track Image  */
    private String mTrackImage;

    /** Track File  */
    private String mTrackFile;

    /** Track Duration  */
    private String mTrackDuration;

    /**
     * Create a new Music object.
     *
     * @param artistName name of artist
     * @param trackTitle is the title of the track in the album
     * @param titleAlbum is the title of the album where the track is
     * @param trackImage is the name of drawble image.
     * @param trackFile is the remote file of track.
     * @param trackDuration is the duration mm:ss of track.
     */
    public Music(String artistName, String trackTitle, String titleAlbum, String trackImage, String trackFile, String trackDuration) {
        mArtistName = artistName;
        mTrackTitle = trackTitle;
        mTitleAlbum = titleAlbum;
        mTrackImage = trackImage;
        mTrackFile = trackFile;
        mTrackDuration = trackDuration;
    }

    /**
     * Get the artist name of the track.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the title of the track.
     */
    public String getTrackTitle() {

        return mTrackTitle;
    }

    /**
     * Get the title of the Album.
     */
    public String getTitleAlbum() {
        return mTitleAlbum;
    }

    /**
     * Get the track image from resource.
     */
    public String getTrackImage() {

        return mTrackImage;
    }

    /**
     * Get the track file from server.
     */
    public String getTrackFile() {

        return mTrackFile;
    }

    /**
     * Get the track duration.
     */
    public String getTrackDuration() {

        return mTrackDuration;
    }


}
