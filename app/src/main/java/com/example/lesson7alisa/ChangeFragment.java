package com.example.lesson7alisa;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChangeFragment extends Fragment implements IFragments{
    private ArrayList<MainModel>list;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

   public ChangeFragment(){

   }
           @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1change, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        setupRecyclerView();
        return  view;
    }
    private void setupRecyclerView() {
        list = new ArrayList<>();
        list.add(new MainModel("Angelina","Jolli", R.drawable.jolie_wallpaper));
        list.add(new MainModel("Jenifer","Lopes",R.drawable.jeniferlopes));
        list.add(new MainModel("Brad","Pitt",  R.drawable.bradpit));
        list.add(new MainModel("Claudia","Shiffer",R.drawable.claudiashiffer));
        list.add(new MainModel("Monica","Belluch",R.drawable.monicabellucci));
        list.add(new MainModel("Sofia","Loren", R.drawable.sofiloren));
        list.add(new MainModel("Merilin","Мonro",R.drawable.monro));
        list.add(new MainModel("Elizaveta","Boyarskaya",R.drawable.lizaboyarskaya));
        list.add(new MainModel("Alecsandr","Habensky",R.drawable.habensky));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list,getActivity());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }



    public void displayDetails(String title, String subTitle, int avatarView) {
        MainActivity activity = (MainActivity) getActivity();
        activity.displayDetails(title,subTitle, avatarView);
    }


    }

