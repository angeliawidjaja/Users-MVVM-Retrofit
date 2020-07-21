package com.example.learnapp.Retrofit;

import com.example.learnapp.DataModel.UserListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("users/")
    Call<UserListResponse> getUserList(@Query("per_page") int perPage, @Query("page") int page);
}