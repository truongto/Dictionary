package com.example.dictionary.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;
import com.example.dictionary.interfaceMVP.OnItemClick;
import com.example.dictionary.model.Word;

import java.util.List;

public class TimkiemAVadapter extends RecyclerView.Adapter<TimkiemAVadapter.Holder> {
    public OnItemClick onItemClick;
    Context context;
    List<Word> wordList;


    public TimkiemAVadapter(Context context, List<Word> wordList) {
        this.context = context;
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public TimkiemAVadapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.timkiem_av, parent, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TimkiemAVadapter.Holder holder, final int position) {
        final Word words = wordList.get(position);
        holder.textView.setText(words.word);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.itemclick(words);

            }
        });

    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvgoi_y_AV);
        }
    }
}
