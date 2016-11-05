package org.khmeracademy.atmnearme;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

/**
 * Created by CHHAI CHIVON on 11/5/2016.
 */

public class DBManager extends AsyncTask<Void, Void, Cursor> {

    //TODO getContect
    private Context context;

    public DBManager(Context context){
        this.context = context;
    }

    @Override
    protected Cursor doInBackground(Void... params) {
        return DBConnector.getInstance(context).getCursorDBData();
    }
}
