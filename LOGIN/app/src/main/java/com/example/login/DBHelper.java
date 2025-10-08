package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT , email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String username, String email, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username );
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean updateuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deletedata(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;

    }

    public Boolean checkusername(String username,String userpassword) {

        SQLiteDatabase DB = this.getWritableDatabase();
       // Cursor cursor = DB. rawQuery("SELECT * " + "FROM Userdetails " + "WHERE username = ?", new String[] {username});
       // Cursor cursor = DB.rawQuery("Select * from Userdetails where name =?", new String[]{username});
        Cursor cursor2 = DB.rawQuery("Select * from Userdetails where password =?", new String[]{userpassword});
        Cursor cursor1 = DB.rawQuery("Select * from Userdetails where username =?", new String[]{username});

       // Cursor cursor = DB. rawQuery("SELECT username, password " + "FROM Userdetails " + "WHERE username = ? and password = ?", new String[] {username, userpassword});
       // Cursor result = db. rawQuery("SELECT first_name, last_name " + "FROM people " + "WHERE id = ?", new String[] {"1"});
        if (cursor1.getCount() > 0 && cursor2.getCount() >0)
            return true;
        else
            return false;
    }
}

