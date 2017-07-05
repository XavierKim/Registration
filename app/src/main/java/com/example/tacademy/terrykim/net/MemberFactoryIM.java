package com.example.tacademy.terrykim.net;

import com.example.tacademy.terrykim.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 통신 API를 선언한다. 구현이 아니라 선언임
 */

public interface MemberFactoryIM {
    // Login 통신 담당 메소드 구현
    @GET("login")//서버의 라우팅 이름과 일치해야함.
    Call<List<User>> login(@Query("userEmail") String userEmail, @Query("userPwd") String userPwd);
}
