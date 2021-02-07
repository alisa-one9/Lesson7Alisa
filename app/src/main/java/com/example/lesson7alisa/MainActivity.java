package com.example.lesson7alisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.lesson7alisa.R.id.linearLayout;


public class MainActivity extends AppCompatActivity implements IFragments {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_first, new ChangeFragment());
        transaction.commit();


    }

    @Override
    public void displayDetails(String title, String subTitle, int avatarView) {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            fragmentManager = getSupportFragmentManager();
            transaction =fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_second,TExtFragment.newInstance(title,subTitle,avatarView));
            transaction.commit();
        } else {
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtra("key",title);
            intent.putExtra("keyDesc",subTitle);
            intent.putExtra("keyImage",avatarView);
            startActivity(intent);
        }

    }
}


