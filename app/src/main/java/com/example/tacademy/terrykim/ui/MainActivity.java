package com.example.tacademy.terrykim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tacademy.terrykim.R;
import com.example.tacademy.terrykim.model.User;
import com.example.tacademy.terrykim.net.Net;
import com.example.tacademy.terrykim.utility.U;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Activity : 화면 단위.
 * 기본 세팅 : onCreate() : 액티비티가 런칭이 되고 manager가 호출하는 첫 번째 메소드
 *                          초기화 작업 : 로드가 많이 걸리지 않는 작업들 - 화면이 빨리 떠야한다.
 *                          반드시 해야하는 부분 : 화면 세팅(setContentView())
 */

public class MainActivity extends AppCompatActivity {



    EditText mail;
    EditText pwd;
    String userMail, userPWD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(btnListener);
        Button btn2 = (Button) findViewById(R.id.button3);
        btn2.setOnClickListener(btnListener2);
        Button btn3 = (Button) findViewById(R.id.button4);
        btn3.setOnClickListener(btnListener3);

        mail = (EditText)findViewById(R.id.editText);
        pwd = (EditText)findViewById(R.id.editText2);
    }



    Button.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            U.getInstance().log("눌렸다.");
        }
    };
    Button.OnClickListener btnListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            U.getInstance().log("로그인 버튼 눌림.");
            userMail = mail.getText().toString();
            userPWD = pwd.getText().toString();

            if(TextUtils.isEmpty(userMail)){
                mail.setError("이메일을 입력하세요.");
                return;
            }
            if(TextUtils.isEmpty(userPWD)) {
                pwd.setError("비밀번호를 입력하세요.");
                return;
            }
            Call<List<User>> res = Net.getInstance().getMemberFactoryIM().login(userMail,userPWD);
            //Net.getInstance().getMemberFactoryIM().login(userMail,userPWD);//url 엔터치는 행위
            res.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    //- 응답 전문상 오류 -> 알림 -> 자유도
                    //- 응답 성공 -> 로그인(자동로그인) -> 메인 서비스로 이동
                    if(response.isSuccessful()){
                        //Success
                        if(response.body() != null) {
                            // response.body()는 json으로 컨버팅돼서 객체에 담겨서 지정한대로 리턴된다.
                            // 여기서는 지정을 Call<지정타입> => Call<List<User>>
                            // List<User>가 응답 결과물이다.
                            List<User> users = response.body();
                            U.getInstance().log(response.body().get(0).toString());
                        }else{
                            U.getInstance().log("Failure 1");
                        }
                    }else {
                        //Failure
                        U.getInstance().log("Failure 2");
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    //- 통신오류 - > 알림 -> 자유도
                    U.getInstance().log("Failure 3");
                }
            });
        }
    };
    Button.OnClickListener btnListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            U.getInstance().log("회원가입 버튼 눌림.");
            Intent intent = new Intent(getBaseContext(),RegisterActivity.class);
            getBaseContext().startActivity(intent);
            //통신 : retrofit(okhttp), volley 통신용 오픈소스 / 데이터처리 : Json(Gson), xml
            //응답 (response)


        }
    };
}
