package com.example.tacademy.terrykim.net;

import com.example.tacademy.terrykim.utility.C;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tacademy on 2017-06-30.
 */
public class Net {
    private static Net ourInstance = new Net();

    public static Net getInstance() {
        return ourInstance;
    }

    private Net() {
    }

    // Retrofit 생성
    private Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(C.Net.USE_DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    public Retrofit getRetrofit(){
        return retrofit;
    }
    //====================================================================
    // API 담당 인터페이스 생성
    // API 담당 인터페이스의 객체를 생성하고 객체를 리턴해주는 getter 준비
    MemberFactoryIM memberFactoryIM;

    public MemberFactoryIM getMemberFactoryIM() {
        if(memberFactoryIM == null){
            memberFactoryIM = retrofit.create(MemberFactoryIM.class);
        }
        return memberFactoryIM;
    }
}
