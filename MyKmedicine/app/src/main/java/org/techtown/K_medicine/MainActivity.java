package org.techtown.K_medicine;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editSearch;

    public ArrayList<CustomListForm> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn2 = (ImageButton) findViewById(R.id.btn2);
        ImageButton btnQr = (ImageButton) findViewById(R.id.btnQr);

        Intent intent = getIntent();

        String text = intent.getStringExtra("text");
        String text2 = intent.getStringExtra("text2");
        String text3 = intent.getStringExtra("text3");

        TextView text_tv = findViewById(R.id.text_tv);
        TextView text_tv2 = findViewById(R.id.text_tv2);
        TextView text_tv3 = findViewById(R.id.text_tv3);
        text_tv.setText(text);
        text_tv2.setText(text2);
        text_tv3.setText(text3);

        editSearch = (EditText) findViewById(R.id.editSearch);

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


        // 리스트 시작 //
        // 추후 API에서 값 받아서 넣도록 만들기 //
        list = new ArrayList<CustomListForm>();
        list.add(new CustomListForm("20220302-2", "행복약품", "행복병원", "항생제 외 3개 품목"));
        list.add(new CustomListForm("ks0202020", "ㅇㅇ 제약회사", "ㅇㅇ 약국", "항생제 외 5개 품목"));

        listView = findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), R.layout.custom_list_item, list);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                intent.putExtra("LIST_ADAPTER_ID", i);
                startActivity(intent);
            }
        });
    }
}