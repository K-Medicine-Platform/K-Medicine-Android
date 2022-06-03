package org.techtown.K_medicine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Change extends AppCompatActivity {
    private TextView tv_result2;
    private EditText o_user, c_user;
    private Button btn_save;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_main);

        init();
        SettingListener();

    }

    private void init() {
        o_user = findViewById(R.id.o_user);
        c_user = findViewById(R.id.c_user);
        btn_save = findViewById(R.id.btn_save); //xml에서 생성한 id 매치
    }

    private void SettingListener() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = o_user.getText().toString();
                String input2 = c_user.getText().toString();
                //인텐트 선언 및 정의

                Intent intent = new Intent(Change.this, MainActivity.class);
                //입력한 input값을 intent로 전달한다.
                intent.putExtra("text2",input);
                intent.putExtra("text3",input2);

                //액티비티 이동
                startActivity(intent);
            }
        });
    }

}
