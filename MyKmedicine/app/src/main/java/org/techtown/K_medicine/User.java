package org.techtown.K_medicine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class User extends AppCompatActivity {

        //private TextView tv_result;
        private EditText user_n;
        private Button userbtn;
        //private SharedPreferences preferences;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user);


            init();
            SettingListener();

        }

        private void init() {
            user_n = findViewById(R.id.user_n);
            userbtn = findViewById(R.id.userbtn);
            //tv_result = findViewById(R.id.tv_result);  xml에서 생성한 id 매치
        }

        private void SettingListener() {
            userbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String input = user_n.getText().toString();
                    //인텐트 선언 및 정의

                    Intent intent = new Intent(User.this, MainActivity.class);
                    //입력한 input값을 intent로 전달한다.
                    intent.putExtra("text",input);
                    startActivity(intent);
                }
            });
        }


       /*
        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

            userbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", user_n.getText().toString());
                    editor.commit();
                    getPreferences();

                    Intent intent = new Intent(getApplicationContext(), MainActivityList.class);
                    startActivity(intent);
                }
            });



            private void getPreferences(){

                tv_result.setText("USERN = " + preferences.getString("username",""));

            }


        */
    }
