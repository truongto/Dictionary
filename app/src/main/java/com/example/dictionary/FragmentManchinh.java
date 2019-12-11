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

import com.example.dictionary.adapter.LichSuAdapter;
import com.example.dictionary.adapter.TimkiemAVadapter;
import com.example.dictionary.dao.AVdao;
import com.example.dictionary.data.DataDictionary;
import com.example.dictionary.data.SQLite;
import com.example.dictionary.databinding.FramentManchinhBinding;
import com.example.dictionary.interfaceMVP.ManchinhView;
import com.example.dictionary.interfaceMVP.OnItemClick;
import com.example.dictionary.model.LichSu;
import com.example.dictionary.model.Word;
import com.example.dictionary.presenter.ManchinhPresenter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class FragmentManchinh extends Fragment implements ManchinhView {
    private ImageButton imageDoi;
    private List<Word> wordList = new ArrayList<>();
    private Context context;
    private TextView textView1, textView2, textView3;
    private RecyclerView recyclerView;
    private ImageButton imageButton;
    private EditText editTextnhap;
    private ManchinhPresenter manchinhPresenter;
    private AVdao aVdao;
    TimkiemAVadapter avAdapter;
    OnItemClick onItemClick;

    private List<LichSu> lichSuList;
    SQLite databaseSQL;
    LichSuAdapter lichSuAdapter;

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
        textView1 = view.findViewById(R.id.hienthiKQ);
        textView2 = view.findViewById(R.id.hienthiKQ2);
        textView3 = view.findViewById(R.id.hienthiKQ3);

        aVdao = new AVdao(getActivity());
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

        onItemClick = new OnItemClick() {
            @Override
            public void itemclick(Word word) {
                editTextnhap.setText(word.word);
                textView1.setText(word.word);
                textView2.setText(word.description);
                textView3.setText(word.pronounce);

            }
        };
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String text = editTextnhap.getText().toString().trim();
//                Calendar calendar = Calendar.getInstance();
//
//                String gioi = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(calendar.getTime());
//                String ngay2 = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
//                LichSu lichSu = new LichSu();
//                lichSu.setId("" + System.currentTimeMillis());
//                lichSu.setNoidung(text);
//                lichSu.setGio(gioi);
//                lichSu.setNgay(ngay2);
//                lichSuList.add(lichSu);
//                long result = databaseSQL.inserLichSu(lichSu);
//                if (result > 0) {
//                    databaseSQL = new SQLite(getActivity());
//                    Toast.makeText(getActivity(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getActivity(), "Thêm Thất Bại ", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

    }


    @Override
    public void TimWord() {
        String text = editTextnhap.getText().toString().trim();

        if (text.isEmpty()) {
            editTextnhap.setError("Please enter the word!");
        } else {
            wordList = aVdao.searchWord(text);
        }
        if (wordList.size() == 0) {
            Toast.makeText(getActivity(), "There is no information about words", Toast.LENGTH_SHORT).show();
        } else {
            avAdapter = new TimkiemAVadapter(getActivity(), wordList);
            avAdapter.onItemClick = onItemClick;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(avAdapter);

        }

    }

}