package com.example.tacademy.terrykim.utility;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tacademy.terrykim.R;

/**
 * Created by Tacademy on 2017-06-29.
 */

public class MainServiceActivity extends AppCompatActivity{

    boolean isFirstEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);
    }

    @Override
    public void onBackPressed(){
        if(!isFirstEnd){
            isFirstEnd = true;
            handler.sendEmptyMessageDelayed(1000,1000*3);
            Toast.makeText(this,"다시 한 번 백키를 누르면 앱이 종료됩니다.",Toast.LENGTH_SHORT).show();
        }else{
            super.onBackPressed();
        }

    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1000){
                isFirstEnd = false;
            }
        }
    };
}
