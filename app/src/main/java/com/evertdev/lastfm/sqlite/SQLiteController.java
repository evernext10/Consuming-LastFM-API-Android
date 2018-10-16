package com.evertdev.lastfm.sqlite;

import android.content.ContentValues;
import android.content.Context;

import com.evertdev.lastfm.models.Album;
import com.evertdev.lastfm.models.Artist;
import com.evertdev.lastfm.models.Track;

public class SQLiteController {
    private SQLiteHelper sqLiteHelper;
    Context context;

    public SQLiteController(Context mContext){
        this.context = mContext;
        sqLiteHelper = new SQLiteHelper(context);
    }

    public boolean SAVE_ALBUM_DATA(Album album){

        int num = (int) (Math.random() * 1000000) + 1;

        ContentValues values = new ContentValues();
        values.put(SQLiteTables.COL_ALBUM_ID, num);
        values.put(SQLiteTables.COL_ALBUM_MBID, album.getMbid());
        values.put(SQLiteTables.COL_ALBUM_NAME, album.getName());
        values.put(SQLiteTables.COL_ALBUM_PLAYCOUNT, album.getPlaycount());
        values.put(SQLiteTables.COL_ALBUM_URL, album.getUrl());
        values.put(SQLiteTables.COL_ALBUM_IMAGE, album.getImageUrl());
        values.put(SQLiteTables.COL_ALBUM_ARTIST, String.valueOf(album.getArtist()));
        return sqLiteHelper.INSERT_DATA(SQLiteTables.TABLE_ALBUM, values);
    }

    public boolean SAVE_ARTIST_DATA(Artist artist){

        int num = (int) (Math.random() * 1000000) + 1;

        ContentValues values = new ContentValues();
        values.put(SQLiteTables.COL_ARTIST_ID, num);
        values.put(SQLiteTables.COL_ARTIST_MBID, artist.getMbid());
        values.put(SQLiteTables.COL_ARTIST_NAME, artist.getName());
        values.put(SQLiteTables.COL_ARTIST_PLAYCOUNT, artist.getPlaycount());
        values.put(SQLiteTables.COL_ARTIST_URL, artist.getUrl());
        values.put(SQLiteTables.COL_ARTIST_IMAGE, artist.getImageUrl());
        values.put(SQLiteTables.COL_ARTIST_STREAMABLE, artist.getStreamable());
        return sqLiteHelper.INSERT_DATA(SQLiteTables.TABLE_ARTIST, values);
    }

    public boolean SAVE_TRACK_DATA(Track track){

        int num = (int) (Math.random() * 1000000) + 1;

        ContentValues values = new ContentValues();
        values.put(SQLiteTables.COL_TRACK_ID, num);
        values.put(SQLiteTables.COL_TRACK_MBID, track.getMbid());
        values.put(SQLiteTables.COL_TRACK_NAME, track.getName());
        values.put(SQLiteTables.COL_TRACK_PLAYCOUNT, track.getPlaycount());
        values.put(SQLiteTables.COL_TRACK_URL, track.getUrl());
        values.put(SQLiteTables.COL_TRACK_IMAGE, track.getImageUrl());
        values.put(SQLiteTables.COL_TRACK_DURATION, track.getDuration());
        values.put(SQLiteTables.COL_TRACK_ARTIST, String.valueOf(track.getArtist()));
        return sqLiteHelper.INSERT_DATA(SQLiteTables.TABLE_TRACK, values);
    }

    public Album getAlbumDetail(String name){
        return sqLiteHelper.getAlbumDetail(name);
    }
    public Artist getArtistDetail(String name){
        return sqLiteHelper.getArtistDetail(name);
    }
    public Track getTrackDetail(String name){
        return sqLiteHelper.getTrackDetail(name);
    }
}
