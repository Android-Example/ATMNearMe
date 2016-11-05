package org.khmeracademy.atmnearme;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by CHHAI CHIVON on 11/5/2016.
 */

public class DBConnector extends SQLiteAssetHelper{
    private static final String DB_NAME= "atmnearme.sqlite";

    /*=====================Singleton Pattern==========================*/

    private static DBConnector instance = null;

    public static DBConnector getInstance(Context context){
        if(instance == null){
            instance = new DBConnector(context);
        }
        return instance;
    }

    /*=====================End Singleton Pattern==========================*/

    //TODO private constructor for singleton pattern purpose
    private DBConnector(Context context){
        super(context,DB_NAME,null,1);
    }


    //TODO User resturn cursor
    public Cursor getCursorDBData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SONGS", null);
        return cursor;
    }

    //TODO use ArrayList return
    public ArrayList<String> getDBData(){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SONGS", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            Log.d("DB: ", cursor.getString(0));
            cursor.moveToNext();
        }
        return list;
    }
}
