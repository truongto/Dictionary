package com.example.dictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;
import com.example.dictionary.data.SQLite;
import com.example.dictionary.model.LichSu;

import java.util.List;

public class LichSuAdapter extends RecyclerView.Adapter<LichSuAdapter.Holder> {
    Context context;
    List<LichSu>lichSuList;
    SQLite sqLite;

    public LichSuAdapter(Context context, List<LichSu> lichSuList, SQLite sqLite) {
        this.lichSuList=lichSuList;
        this.context=context;
        this.sqLite=sqLite;
    }

    @NonNull
    @Override
    public LichSuAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lichsu_timkiem, parent, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LichSuAdapter.Holder holder, int position) {
        final LichSu lichSu= lichSuList.get(position);
        holder.textView1.setText(lichSu.getNoidung());
        holder.textView2.setText(lichSu.getGio());
        holder.textView2.setText(lichSu.getNgay());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView1, textView2,textView3;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.tvlichsu1);
            textView2 = itemView.findViewById(R.id.tvlichsu2);
            textView3 = itemView.findViewById(R.id.tvlichsu3);

        }
    }
}
