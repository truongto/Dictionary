package com.example.dictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.FragmentManchinh;
import com.example.dictionary.R;
import com.example.dictionary.data.DataDictionary;
import com.example.dictionary.model.Word;

import java.util.List;

public class TimkiemAVadapter extends RecyclerView.Adapter<TimkiemAVadapter.Holder> {
    Context context;
    List<Word> wordList;
    DataDictionary dataDictionary;
FragmentManchinh fragmentManchinh;

    public TimkiemAVadapter(FragmentManchinh fragmentManchinh, List<Word> wordList) {
        this.fragmentManchinh = fragmentManchinh;
        this.wordList = wordList;
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

//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//
//                builder.setTitle(word.word);
//                builder.setMessage(Html.fromHtml(word.html));
//
//                builder.show();
//
////                Toast.makeText(context, Html.fromHtml(word.html), Toast.LENGTH_SHORT).show();
//            }
//        });

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
