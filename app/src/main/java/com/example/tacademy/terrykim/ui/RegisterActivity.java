package com.example.tacademy.terrykim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tacademy.terrykim.Exception;
import com.example.tacademy.terrykim.R;
import com.example.tacademy.terrykim.ui.MainActivity;

/**
 * Created by Tacademy on 2017-06-29.
 */

public class RegisterActivity extends AppCompatActivity{

    EditText userMail, userPWD;
    Button register, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userMail = (EditText)findViewById(R.id.mail);
        userPWD = (EditText)findViewById(R.id.pwd);

        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(registerListener);
        cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(cancelListener);
    }


    Button.OnClickListener registerListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(Exception.getInstance().emailException(userMail.getText().toString())==Exception.FALSE){
                Toast.makeText(getBaseContext(),"이메일 형식이 틀렸삼~",Toast.LENGTH_LONG);
            }
            if(!register.getText().toString().equals("")||!userPWD.getText().toString().equals("")){
                Intent intent1 = new Intent(getBaseContext(),MainActivity.class);
                getBaseContext().startActivity(intent1);
            }
            else{
                Toast.makeText(getBaseContext(),"모두 입력해주삼~",Toast.LENGTH_LONG);
            }
        }
    };
    Button.OnClickListener cancelListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent2 = new Intent(getBaseContext(),MainActivity.class);
            getBaseContext().startActivity(intent2);
        }
    };



}

