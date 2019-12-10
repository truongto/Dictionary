package com.example.dictionary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.adapter.TimkiemAV_Adapter;
import com.example.dictionary.data.Data_Dictionary;
import com.example.dictionary.model.Word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Fragment_Manchinh extends Fragment {
    private ImageButton imageDoi;
    private Data_Dictionary dataDictionary;
    private List<Word> wordList;
    private Context context;
    private TimkiemAV_Adapter avAdapter;

    private RecyclerView recyclerView;
    private ImageButton imageButton;
    private EditText editTextnhap;
    public static final String DBTEN = "dict_hh.db";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_manchinh, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageDoi = view.findViewById(R.id.doi_AV);
        recyclerView = view.findViewById(R.id.recy_timkiemAV);
        imageButton = view.findViewById(R.id.timAV);
        editTextnhap = view.findViewById(R.id.nhapAV);

        wordList = new ArrayList<>();

        dataDictionary = new Data_Dictionary(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        avAdapter = new TimkiemAV_Adapter(wordList, getActivity());
        recyclerView.setAdapter(avAdapter);
        try {
            dataDictionary.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //doi fragment Anh Viet sang Viet Anh
        imageDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_ManVietAnh fragment_manVietAnh = new Fragment_ManVietAnh();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, fragment_manVietAnh).commit();

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            List<Word> wordLists =new ArrayList<>();
            @Override
            public void onClick(View view) {
                String nhap = editTextnhap.getText().toString().trim();
                if (nhap.isEmpty()) {
                    editTextnhap.setError("Vui lòng nhập dữ liệu....");
                    return;
                } else {
                    List<Word> wordList = dataDictionary.searchVA(nhap);
                    this.wordLists.addAll(wordList);
                    avAdapter.notifyDataSetChanged();

                }

                Toast.makeText(getActivity(), "bat su kien", Toast.LENGTH_SHORT).show();
            }
        });


    }

//    private void readFromAset(Context context, String name) {
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(name)));
//            String mline;
//            int i = 0;
//            while ((mline = bufferedReader.readLine()) != null) {
//                String[] lineData = mline.split("_");
//                wordList.add(new Word("" + i, lineData[0], lineData[1]));
//                i++;
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}