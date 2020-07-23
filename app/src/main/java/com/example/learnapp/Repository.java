package com.example.learnapp;

import com.example.learnapp.DataModel.UserListResponse;
import com.example.learnapp.Retrofit.ApiClient;
import com.example.learnapp.Retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    public void requestData(int perPage, final int currPage, final RequestHandler requestHandler){
        final ApiService userListService = ApiClient.getUserListService();
        Call<UserListResponse> call = userListService.getUserList(perPage, currPage);

        call.enqueue(new Callback<UserListResponse>() {
            @Override
            public void onResponse(Call<UserListResponse> call, Response<UserListResponse> userListResponse) {
                requestHandler.onResult(userListResponse.body());
            }

            @Override
            public void onFailure(Call<UserListResponse> call, Throwable t) {
                requestHandler.onResult(null);
            }
        });
    }
}
