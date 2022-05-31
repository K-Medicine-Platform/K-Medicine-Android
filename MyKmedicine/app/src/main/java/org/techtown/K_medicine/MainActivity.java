package org.techtown.K_medicine;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> list;
    private ListView listView;
    private EditText editSearch;
    private SearchAdapter adapter;
    private ArrayList<String> arraylist;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn2 = (ImageButton) findViewById(R.id.btn2);  // 버튼1
        ImageButton btnQr = (ImageButton) findViewById(R.id.btnQr);  // 버튼2
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Change.class);
                startActivity(intent);
            }
        });

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Qr.class);
                startActivity(intent);
            }
        });

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);


        // 리스트 시작 //
        list = new ArrayList<String>();

        settingList();

        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        adapter = new SearchAdapter(list, this);

        listView.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String text = editSearch.getText().toString();
                search(text);
            }
        });


    }

    public void search(String charText) {

        list.clear();

        if (charText.length() == 0) {
            list.addAll(arraylist);
        }

        else
        {

            for(int i = 0;i < arraylist.size(); i++)
            {

                if (arraylist.get(i).toLowerCase().contains(charText))
                {

                    list.add(arraylist.get(i));
                }
            }
        }

        adapter.notifyDataSetChanged();
    }

    private void settingList(){
        list.add("거래 번호  : 20220302-2\n" +
                "인계사      : 행복약품\n" +
                "인수사      : 행복병원\n" +
                "물품 정보  : 항생제 외 3개 품목\n");
        list.add("거래 번호  : ks0202020\n " +
                "인계사      : ㅇㅇ 제약회사\n" +
                "인수사      : ㅇㅇ 약국\n" +
                "물품 정보  : 항생제 외 3개 품목\n");
    }
}