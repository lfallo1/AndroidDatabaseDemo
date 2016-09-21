package com.lancefallon.androiddatabasedemo.model;

import android.database.Cursor;

/**
 * Created by lancefallon on 9/21/16.
 */
public class User {
    private long id;
    private String name;

    public User(long id, String name){
        this.id = id;
        this.name = name;
    }

    public User(Cursor cursor){
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.name = cursor.getString(cursor.getColumnIndex("name"));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
