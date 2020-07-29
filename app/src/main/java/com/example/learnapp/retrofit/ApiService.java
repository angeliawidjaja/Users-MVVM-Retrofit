package com.example.learnapp.retrofit;

import com.example.learnapp.datamodel.userlist.UserListResponse;
import com.example.learnapp.datamodel.userlistdetail.UserListDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("users/")
    Call<UserListResponse> getUserList(@Query("per_page") int perPage, @Query("page") int page);

    @GET("users/{id}")
    Call<UserListDetailResponse> getUserDetail(@Path("id") int id);
}