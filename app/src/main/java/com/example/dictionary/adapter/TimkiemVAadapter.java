package com.example.dictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;
import com.example.dictionary.interfaceMVP.OnItemClickVA;
import com.example.dictionary.model.Word;

import java.util.List;

public class TimkiemVAadapter extends RecyclerView.Adapter<TimkiemVAadapter.Holder> {
    List<Word> wordList;
    Context context;
    public OnItemClickVA onItemClickVA;

    public TimkiemVAadapter(List<Word> wordList, Context context) {
        this.wordList = wordList;
        this.context = context;
    }

    @NonNull
    @Override
    public TimkiemVAadapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.timkiem_va, parent, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TimkiemVAadapter.Holder holder, int position) {
        final Word words = wordList.get(position);
        holder.textView.setText(words.word);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickVA.itemclickVA(words);
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
            textView = itemView.findViewById(R.id.tvgoi_y_VA);
        }
    }
}
