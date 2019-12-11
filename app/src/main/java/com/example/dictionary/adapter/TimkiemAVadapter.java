package com.example.dictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.FragmentManchinh;
import com.example.dictionary.R;
import com.example.dictionary.data.DataDictionary;
import com.example.dictionary.model.Word;

import java.util.List;

public class TimkiemAVadapter extends RecyclerView.Adapter<TimkiemAVadapter.Holder> {
   private Context context;
   private List<Word> wordList;

    public TimkiemAVadapter(Context context, List<Word> wordList) {
        this.context=context;
        this.wordList=wordList;
    }
    @NonNull
    @Override
    public TimkiemAVadapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.timkiem_av, parent, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TimkiemAVadapter.Holder holder, int position) {
        final Word word = wordList.get(position);
        holder.textView.setText(word.word);


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
