package com.mercycorps.ews.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "district.db";
    private static final int DATABASE_VERSION = 1;

    private Context mContext;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }
    public List<String> getAllData() {
        List<String> labels = new ArrayList<String>();



        String selectQuery = "SELECT  * FROM " + "info2" ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();

        db.close();
        labels.add(0,"data");

        // returning lables
        return labels;
    }


}
