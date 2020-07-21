package com.example.learnapp;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.learnapp.DataModel.UserListItemResponse;
import com.example.learnapp.DataModel.UserListResponse;
import com.example.learnapp.Retrofit.ApiClient;
import com.example.learnapp.Retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserListViewModel extends AndroidViewModel {
    public static Integer SUCCESS = 101;
    public static Integer FAILED = 102;
    public static Integer EXCEED = 103;

    private int currPage;
    private UserListModel data;
    private List<UserListItemModel> userList;

    public UserListViewModel(Application application) {
        super(application);
        currPage = 0;
        data = new UserListModel();
        userList = new ArrayList<>();
    }

    public UserListModel getData() {
        return data;
    }

    public LiveData<Integer> requestSelectedData(){
        final MutableLiveData<Integer> result = new MutableLiveData<>();

        if(currPage >= data.getTotal_pages() && currPage != 0){
            result.postValue(EXCEED);
        }
        else {
            final ApiService userListService = ApiClient.getUserListService();
            Call<UserListResponse> call = userListService.getUserList(3, ++currPage);

            call.enqueue(new Callback<UserListResponse>() {
                @Override
                public void onResponse(Call<UserListResponse> call, Response<UserListResponse> userListResponse) {
                    UserListResponse response = userListResponse.body();

                    if(response != null){
                        data.setPage(response.getPage())
                                .setPer_page(response.getPer_page())
                                .setTotal(response.getTotal())
                                .setTotal_pages(response.getTotal_pages());

                        List<UserListItemResponse> itemResponseList = response.getData();
                        if(itemResponseList != null){
                            for (UserListItemResponse itemResponse:itemResponseList) {
                                UserListItemModel itemData = new UserListItemModel()
                                        .setId(itemResponse.getId())
                                        .setEmail(itemResponse.getEmail())
                                        .setFirst_name(itemResponse.getFirst_name())
                                        .setLast_name(itemResponse.getLast_name())
                                        .setAvatar(itemResponse.getAvatar());
                                userList.add(itemData);
                            }
                            data.setUserList(userList);
                        }

                        result.postValue(SUCCESS);
                    }
                }

                @Override
                public void onFailure(Call<UserListResponse> call, Throwable t) {
                    result.postValue(FAILED);
                }
            });
        }
        return result;
    }
}
