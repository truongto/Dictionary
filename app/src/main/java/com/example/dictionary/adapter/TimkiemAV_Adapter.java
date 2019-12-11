package com.example.dictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;
import com.example.dictionary.data.Data_Dictionary;
import com.example.dictionary.model.Word;

import java.util.List;

public class TimkiemAV_Adapter extends RecyclerView.Adapter<TimkiemAV_Adapter.Holder> {
    Context context;
    List<Word> wordList;
    Data_Dictionary dataDictionary;

    public TimkiemAV_Adapter(List<Word> wordList, Context activity) {
        this.wordList=wordList;
        this.context=activity;
    }


    @NonNull
    @Override
    public TimkiemAV_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.timkiem_av, parent, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TimkiemAV_Adapter.Holder holder, int position) {
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
