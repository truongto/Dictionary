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
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.adapter.TimkiemAVadapter;
import com.example.dictionary.dao.AVdao;
import com.example.dictionary.data.DataDictionary;
import com.example.dictionary.databinding.FramentManchinhBinding;
import com.example.dictionary.interfaceMVP.ManchinhView;
import com.example.dictionary.model.Word;
import com.example.dictionary.presenter.ManchinhPresenter;

import java.util.ArrayList;
import java.util.List;


public class FragmentManchinh extends Fragment implements ManchinhView {
    private ImageButton imageDoi;
    private DataDictionary dataDictionary;
    private List<Word> wordList = new ArrayList<>();
    private Context context;
    private TimkiemAVadapter avAdapter;
    private RecyclerView recyclerView;
    private ImageButton imageButton;
    private EditText editTextnhap;
    private ManchinhPresenter manchinhPresenter;
    private AVdao aVdao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//   View view = inflater.inflate(R.layout.frament_manchinh, container, false);
        FramentManchinhBinding framentManchinhBinding = DataBindingUtil.inflate(inflater,
                R.layout.frament_manchinh, container, false);

        manchinhPresenter = new ManchinhPresenter(this);
        framentManchinhBinding.setFragmentAV(manchinhPresenter);
        View view = framentManchinhBinding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageDoi = view.findViewById(R.id.doi_AV);
        recyclerView = view.findViewById(R.id.recy_timkiemAV);
        imageButton = view.findViewById(R.id.timAV);
        editTextnhap = view.findViewById(R.id.nhapAV);
        manchinhPresenter.Data();
        manchinhPresenter.Tim();


        //doi fragment Anh Viet sang Viet Anh
        imageDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManVietAnh fragment_manVietAnh = new FragmentManVietAnh();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, fragment_manVietAnh).commit();

            }
        });


    }

    @Override
    public void TimWord() {
        String text = editTextnhap.getText().toString().trim();

        if (text.isEmpty()) {
            editTextnhap.setError("Mời bạn nhập từ!");
        }
        wordList = aVdao.searchWord(text);
        if (wordList.size() == 0) {
            Toast.makeText(getActivity(), "Không có thông tin về từ", Toast.LENGTH_SHORT).show();
        } else {
            avAdapter = new TimkiemAVadapter(this, wordList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(avAdapter);
        }

    }

    @Override
    public void Laydulieu() {

    }
}