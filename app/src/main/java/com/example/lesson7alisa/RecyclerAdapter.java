package com.example.lesson7alisa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<MainModel> list;
    private Context context;
    private IFragments listener;

    public RecyclerAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull

    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new RecyclerViewHolder(view);
    }


    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.onBind(list.get(position), position);
    }


    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(ChangeFragment changeFragment) {
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtTitle;
        private TextView txtSubTitle;
        private ImageView imageV;
        private MainModel model;
        int pos;
        private IFragments listener;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitle = itemView.findViewById(R.id.tvTitle);
            txtSubTitle = itemView.findViewById(R.id.tvDesc);
            imageV = itemView.findViewById(R.id.iv_avatar);
        }

        private void onBind(MainModel model, int pos) {
            this.model = model;
            this.pos = pos;
            txtTitle.setText(model.getTitle());
            txtSubTitle.setText(model.getSubTitle());
            imageV.setImageResource(model.getAvatarView());


        }

        public void setOnClickListener(IFragments mListener) {
            this.listener = mListener;
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.displayDetails(model.getTitle(), model.getSubTitle(), model.getAvatarView());
            }
        }
    }


}
