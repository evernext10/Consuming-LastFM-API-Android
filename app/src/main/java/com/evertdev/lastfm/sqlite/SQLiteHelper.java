package com.evertdev.lastfm.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.evertdev.lastfm.models.Album;
import com.evertdev.lastfm.models.Artist;
import com.evertdev.lastfm.models.ImageItem;
import com.evertdev.lastfm.models.Track;

import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "lastfm_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = SQLiteHelper.class.getSimpleName();



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteTables.DB_ARTIST);
        db.execSQL(SQLiteTables.DB_ALBUM);
        db.execSQL(SQLiteTables.DB_TRACK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SQLiteTables.DB_ARTIST+","+SQLiteTables.DB_ALBUM+","+SQLiteTables.DB_TRACK+";");
        onCreate(db);
    }

    public boolean INSERT_DATA(String table, ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table, null, values);
        if (result == -1){
            Log.d(TAG, "Fallo al guardar la información!");
            return false;
        }else{
            Log.d(TAG, "Se guardo la información");
            return true;
        }
    }

    public Album getAlbumDetail(String name){
        Album album;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns={
                SQLiteTables.COL_ALBUM_ID,
                SQLiteTables.COL_ALBUM_MBID,
                SQLiteTables.COL_ALBUM_NAME,
                SQLiteTables.COL_ALBUM_IMAGE,
                SQLiteTables.COL_ALBUM_PLAYCOUNT,
                SQLiteTables.COL_ALBUM_ARTIST,
                SQLiteTables.COL_ALBUM_URL
        };

        String selection = SQLiteTables.COL_ALBUM_NAME + " =? " ;
        String[] args={name};

        Cursor cursor = db.query(SQLiteTables.TABLE_ALBUM, columns,
                selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()){
            album = new Album();
            album.setMbid(cursor.getString(1));
            album.setName(cursor.getString(2));
            album.setPlaycount(cursor.getString(4));
            album.setUrl(cursor.getString(6));
            return album;
        }

        return null;
    }

    public Artist getArtistDetail(String name){
        Artist artist;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns={
                SQLiteTables.COL_ARTIST_ID,
                SQLiteTables.COL_ARTIST_MBID,
                SQLiteTables.COL_ARTIST_NAME,
                SQLiteTables.COL_ARTIST_IMAGE,
                SQLiteTables.COL_ARTIST_PLAYCOUNT,
                SQLiteTables.COL_ARTIST_STREAMABLE,
                SQLiteTables.COL_ARTIST_URL
        };

        String selection = SQLiteTables.COL_ARTIST_NAME + " =? " ;
        String[] args={name};

        Cursor cursor = db.query(SQLiteTables.TABLE_ARTIST, columns,
                selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()){

            artist = new Artist();
            artist.setMbid(cursor.getString(1));
            artist.setName(cursor.getString(2));
            artist.setPlaycount(cursor.getString(5));
            artist.setUrl(cursor.getString(6));
            artist.setStreamable(cursor.getString(4));

            return artist;
        }

        return null;
    }

    public Track getTrackDetail(String name){
        Track track;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns={
                SQLiteTables.COL_TRACK_ID,
                SQLiteTables.COL_TRACK_MBID,
                SQLiteTables.COL_TRACK_NAME,
                SQLiteTables.COL_TRACK_IMAGE,
                SQLiteTables.COL_TRACK_PLAYCOUNT,
                SQLiteTables.COL_TRACK_ARTIST,
                SQLiteTables.COL_TRACK_URL,
                SQLiteTables.COL_TRACK_DURATION
        };

        String selection = SQLiteTables.COL_TRACK_NAME + " =? " ;
        String[] args={name};

        Cursor cursor = db.query(SQLiteTables.TABLE_TRACK, columns,
                selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()){

            track = new Track();
            track.setMbid(cursor.getString(2));
            track.setName(cursor.getString(3));
            track.setPlaycount(cursor.getString(5));
            track.setUrl(cursor.getString(6));
            track.setDuration(cursor.getString(1));

            return track;
        }

        return null;
    }

}
