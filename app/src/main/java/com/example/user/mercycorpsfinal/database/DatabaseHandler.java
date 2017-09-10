package com.example.user.mercycorpsfinal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.mercycorpsfinal.model.ListItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "PocketDictionary";
    private static final String TABLE_USERS = "contact";
    private static final String KEY_ID="_id";
    private static final String KEY_ORGNATIZATION="organization";
    private static final String KEY_PERSON="person";
    private static final String KEY_LANDLINE="landline";
    private static final String KEY_MOB="mob";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE= "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " TEXT," + KEY_ORGNATIZATION
                + " TEXT," + KEY_PERSON + " TEXT," + KEY_MOB + "TEXT,"+ KEY_LANDLINE + "TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

   public void addUser(ListItem user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
//        values.put(KEY_ID,user.getId());
        values.put(KEY_ORGNATIZATION,user.getOrganization());
        values.put(KEY_PERSON,user.getPerson());
       values.put(KEY_MOB,user.getMob());
       values.put(KEY_LANDLINE,user.getLandline());




       db.insert(TABLE_USERS,null,values);
        db.close();
    }

   public List<ListItem> getAllUser(){
       List<ListItem> userList=new ArrayList<ListItem>();
       String selectQuery="SELECT * FROM "+TABLE_USERS;
       SQLiteDatabase db=this.getWritableDatabase();
       Cursor cursor=db.rawQuery(selectQuery,null);

       if (cursor.moveToFirst()){
           do{
//               ListItem user=new ListItem(); user.setId(cursor.getString(0));
////
//               user.setOrganization(cursor.getString(1));
//               user.setPerson(cursor.getString(2));
//               user.setMob(cursor.getString(3));
//               user.setLandline(cursor.getString(4));
//               userList.add(user);
           }while (cursor.moveToNext());

       }
       return userList;
   }
    public  boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
}
