package com.lancefallon.androiddatabasedemo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lancefallon.androiddatabasedemo.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lancefallon on 9/21/16.
 */
public class UserDao {

    private static final UserDao instance = new UserDao();

    public static UserDao getInstance(){
        return instance;
    }

    public List<User> getUsers(Context context){
        List<User> users = new ArrayList<User>();
        SQLiteDatabase db = context.openOrCreateDatabase("demo.db", Context.MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("select * from users", null);
        while(cursor.moveToNext()){
            users.add(new User(cursor));
        }
        db.close();
        return users;
    }

    public long addUser(Context context, String name) {
        SQLiteDatabase db = context.openOrCreateDatabase("demo.db", Context.MODE_PRIVATE, null);
        ContentValues values = new ContentValues();
        values.put("name", name);
        return db.insert("users",null, values);
    }
}
