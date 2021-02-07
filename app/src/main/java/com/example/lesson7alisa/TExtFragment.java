package com.example.lesson7alisa;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TExtFragment extends Fragment {
    private String text1;
    private String text2;
    private int avatar3;
    private TextView textFTitle;
    private TextView textFSubTitle;
    private ImageView textFAvatar;
    private static final String KEY1 ="key1";
    private static final String KEY2 ="key2";
    private static final String KEY3 ="key3";



    public TExtFragment() {
        // Required empty public constructor
    }


    public static TExtFragment newInstance(String param1, String param2,int param3) {
        TExtFragment fragment = new TExtFragment();
        Bundle args = new Bundle();
        args.putString(KEY1, param1);
        args.putString(KEY2, param2);
        args.putInt(KEY3, param3);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text1 = getArguments().getString(KEY1);
            text2 = getArguments().getString(KEY2);
            avatar3 = getArguments().getInt(KEY3);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment2text, container, false);

        textFTitle = view.findViewById(R.id.txtView);
        textFSubTitle =view.findViewById(R.id.txtSubTitle);
        textFAvatar = view.findViewById(R.id.imageView);

        textFTitle.setText(text1);
        textFSubTitle.setText(text2);
        textFAvatar.setImageResource(avatar3);

        return view;

    }

    public  void showText(String title, String subTitle,int avatarView){
        textFTitle.setText(title);
        textFSubTitle.setText(subTitle);
        this.textFAvatar.setImageResource(avatarView);


    }


}