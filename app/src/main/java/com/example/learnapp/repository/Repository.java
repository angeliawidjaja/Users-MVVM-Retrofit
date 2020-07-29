package com.example.learnapp.repository;

import com.example.learnapp.datamodel.userlist.UserListResponse;
import com.example.learnapp.datamodel.userlistdetail.UserListDetailResponse;
import com.example.learnapp.retrofit.ApiClient;
import com.example.learnapp.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private ApiService apiService;

    public Repository() {
        apiService = ApiClient.getApiService();
    }

    public void requestData(int perPage, final int currPage, final RequestHandler requestHandler){
        Call<UserListResponse> call = apiService.getUserList(perPage, currPage);

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

    public void requestUserDetailData(int id, final RequestHandler requestHandler){
        Call<UserListDetailResponse> call = apiService.getUserDetail(id);

        call.enqueue(new Callback<UserListDetailResponse>() {
            @Override
            public void onResponse(Call<UserListDetailResponse> call, Response<UserListDetailResponse> response) {
                requestHandler.onResult(response.body());
            }

            @Override
            public void onFailure(Call<UserListDetailResponse> call, Throwable t) {
                requestHandler.onResult(null);
            }
        });
    }
}
