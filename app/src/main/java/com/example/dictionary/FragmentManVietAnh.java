package com.example.dictionary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.adapter.TimkiemVAadapter;
import com.example.dictionary.dao.VAdao;
import com.example.dictionary.data.DataDictionary;
import com.example.dictionary.databinding.FramentManVietAnhBinding;
import com.example.dictionary.databinding.FramentManchinhBinding;
import com.example.dictionary.interfaceMVP.ManVietAnhView;
import com.example.dictionary.interfaceMVP.OnItemClickVA;
import com.example.dictionary.model.Word;
import com.example.dictionary.presenter.ManVietPresenter;


import java.util.ArrayList;
import java.util.List;

public class FragmentManVietAnh extends Fragment implements ManVietAnhView {
    private ImageButton imagedoi;
    private DataDictionary dataDictionary;
    private List<Word> wordList = new ArrayList<>();
    private Context context;
    private TextView textView1, textView2, textView3;
    private RecyclerView recyclerView;
    private ImageButton imageButtonTim;
    private EditText editText;
    private ManVietPresenter manVietAnhPresenter;
    private VAdao vAdao;
    TimkiemVAadapter timkiemVAadapter;
    OnItemClickVA onItemClickVA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.frament_man_viet_anh, container, false);
//        return view;
        FramentManVietAnhBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.frament_man_viet_anh, container, false);
        manVietAnhPresenter = new ManVietPresenter(this);
        binding.setFragmentVA(manVietAnhPresenter);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagedoi = view.findViewById(R.id.doi_VA);
        recyclerView = view.findViewById(R.id.recy_timkiemVA);
        imageButtonTim = view.findViewById(R.id.timVA);
        editText = view.findViewById(R.id.nhapVA);
        textView1 = view.findViewById(R.id.hienthiKQVA);
        textView2 = view.findViewById(R.id.hienthiKQ2VA);
        textView3 = view.findViewById(R.id.hienthiKQ3VA);
        vAdao = new VAdao(getActivity());
        manVietAnhPresenter.TimVA();

        //doi fragment Viet Anh sang Anh Viet
        imagedoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManchinh fragment_manchinh = new FragmentManchinh();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, fragment_manchinh).commit();

            }
        });
        onItemClickVA=new OnItemClickVA() {
            @Override
            public void itemclickVA(Word word) {
                editText.setText(word.word);
                textView1.setText(word.word);
                textView2.setText(word.description);
                textView3.setText(word.pronounce);
            }
        };
    }


    @Override
    public void TimVietAnh() {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) {
            editText.setError("Vui lòng nhập từ!");
        } else {
            wordList = vAdao.searchVA(text);
        }
        if (wordList.size() == 0) {
            Toast.makeText(getActivity(), "Không có thông tin về từ ngữ", Toast.LENGTH_SHORT).show();
        } else {
            timkiemVAadapter = new TimkiemVAadapter(wordList, getActivity());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            timkiemVAadapter.onItemClickVA = onItemClickVA;
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(timkiemVAadapter);

        }
    }
}
