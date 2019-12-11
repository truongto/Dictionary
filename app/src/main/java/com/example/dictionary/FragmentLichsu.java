package com.example.dictionary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.adapter.LichSuAdapter;
import com.example.dictionary.data.SQLite;
import com.example.dictionary.model.LichSu;

import java.util.ArrayList;
import java.util.List;

public class FragmentLichsu extends Fragment  {
    private List<LichSu> lichSuList;
    private SQLite sqLite;
    private RecyclerView recyclerView;
    private LichSuAdapter lichSuAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lichsu, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_lichsu);

        lichSuList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        sqLite = new SQLite(getActivity());
        lichSuList = sqLite.getAllLichSu();

        lichSuAdapter = new LichSuAdapter(getActivity(), lichSuList, sqLite);
        recyclerView.setAdapter(lichSuAdapter);

    }
}
