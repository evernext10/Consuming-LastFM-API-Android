package com.evertdev.lastfm.sqlite;

@SuppressWarnings("WeakerAccess")
public class SQLiteTables {

    //CREATING TABLE ALBUM

    public static final String TABLE_ALBUM = "table_album";
    public static final String COL_ALBUM_ID = " col_album_id";
    public static final String COL_ALBUM_MBID = " col_album_mbid";
    public static final String COL_ALBUM_NAME = " col_album_name";
    public static final String COL_ALBUM_IMAGE = " col_album_image";
    public static final String COL_ALBUM_PLAYCOUNT = " col_album_playcount";
    public static final String COL_ALBUM_ARTIST = " col_album_artist";
    public static final String COL_ALBUM_URL = " col_album_url";


    public static final String DB_ALBUM = "CREATE TABLE " + TABLE_ALBUM + "(" + COL_ALBUM_ID + " INTEGER PRIMARY KEY, "
            + COL_ALBUM_MBID + " TEXT, " + COL_ALBUM_NAME + " TEXT, " + COL_ALBUM_IMAGE + " TEXT, " + COL_ALBUM_PLAYCOUNT + " TEXT, "
            + COL_ALBUM_ARTIST + " TEXT, " + COL_ALBUM_URL + " TEXT " + ")";

    //CREATING TABLE ARTIST

    public static final String TABLE_ARTIST = "table_artist";
    public static final String COL_ARTIST_ID = " col_artist_id";
    public static final String COL_ARTIST_MBID = " col_artist_mbid";
    public static final String COL_ARTIST_NAME = " col_artist_name";
    public static final String COL_ARTIST_IMAGE = " col_artist_image";
    public static final String COL_ARTIST_STREAMABLE = " col_artist_streamable";
    public static final String COL_ARTIST_PLAYCOUNT = " col_artist_playcount";
    public static final String COL_ARTIST_URL = " col_artist_url";


    public static final String DB_ARTIST = "CREATE TABLE " + TABLE_ARTIST + "(" + COL_ARTIST_ID + " INTEGER PRIMARY KEY, "
            + COL_ARTIST_MBID + " TEXT, " + COL_ARTIST_NAME + " TEXT, " + COL_ARTIST_IMAGE + " TEXT, " + COL_ARTIST_STREAMABLE + " TEXT, "
            + COL_ARTIST_PLAYCOUNT + " TEXT, " + COL_ARTIST_URL + " TEXT " + ")";

    //CREATING TABLE TRACK

    public static final String TABLE_TRACK = "table_track";
    public static final String COL_TRACK_ID = " col_track_id";
    public static final String COL_TRACK_DURATION = " col_track_duration";
    public static final String COL_TRACK_MBID = " col_track_mbid";
    public static final String COL_TRACK_NAME = " col_track_name";
    public static final String COL_TRACK_IMAGE = " col_track_image";
    public static final String COL_TRACK_PLAYCOUNT = " col_track_playcount";
    public static final String COL_TRACK_ARTIST = " col_track_artist";
    public static final String COL_TRACK_URL = " col_track_url";


    public static final String DB_TRACK = "CREATE TABLE " + TABLE_TRACK + "(" + COL_TRACK_ID + " INTEGER PRIMARY KEY, "
            + COL_TRACK_DURATION + " TEXT, " + COL_TRACK_MBID + " TEXT, " + COL_TRACK_NAME + " TEXT, " + COL_TRACK_IMAGE + " TEXT, "
            + COL_TRACK_PLAYCOUNT + " TEXT, " + COL_TRACK_ARTIST + " TEXT, " + COL_TRACK_URL+ " TEST "+ ")";

}
