package com.example.herihomes.api;

import com.example.herihomes.DefaultResponse;
import com.example.herihomes.models.LoginResponse;
import com.example.herihomes.models.UserResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponse> createUser(
                @Field("email") String email,
                @Field("password") String password,
                @Field("name") String name,
                @Field("school") String school
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
                @Field("email")String email,
                @Field("password") String password
    );

    @GET("allusers")
    Call<UserResponse> getUsers();
}