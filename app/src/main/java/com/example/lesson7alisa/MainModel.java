package com.example.lesson7alisa;

import android.widget.ImageView;

public class MainModel {
    private static int avatarResoursId;
    private String  title;
    private String  subTitle;
    private int avatarView;


    public MainModel(String title, String subTitle, int avatarView) {
        this.title = title;
        this.subTitle = subTitle;
        this.avatarView =avatarView;

    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getAvatarView() {
        return avatarView;
    }
}
