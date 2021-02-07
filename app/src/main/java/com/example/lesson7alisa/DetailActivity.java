package com.example.lesson7alisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static com.example.lesson7alisa.R.id.fragmentText;


public class DetailActivity extends AppCompatActivity  {
    private String title;
    private String subTitle;
    private  int avatarView;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private TExtFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra("key");
            subTitle = intent.getStringExtra("keyDesc");
            avatarView = intent.getIntExtra("keyImage",1);
        }
        fragmentManager = getSupportFragmentManager();
        fragment = (TExtFragment) fragmentManager.findFragmentById(R.id.fragmentText);
        transaction = fragmentManager.beginTransaction();
        fragment.showText(title, subTitle,avatarView);
        transaction.commit();
    }

}