package com.example.noteapp;

import android.widget.TextView;

public class TaskModel {
    private String title, des;

    public TaskModel(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
