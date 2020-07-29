package com.example.learnapp.app.userlistdetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.learnapp.app.userlist.UserListItemModel;
import com.example.learnapp.datamodel.userlist.UserListItemResponse;
import com.example.learnapp.datamodel.userlistdetail.AdResponse;
import com.example.learnapp.datamodel.userlistdetail.UserListDetailResponse;
import com.example.learnapp.repository.Repository;
import com.example.learnapp.repository.RequestHandler;

public class UserListDetailViewModel extends ViewModel {
    public static Integer SUCCESS = 101;
    public static Integer FAILED = 102;
    public static Integer NODATA = 104;

    private UserListDetailModel userDetailData;
    private MutableLiveData<Integer> eventID;

    public MutableLiveData<Integer> getEventID() {
        return eventID;
    }

    public UserListDetailModel getUserDetailData() {
        return userDetailData;
    }

    public UserListDetailViewModel(){
        userDetailData = new UserListDetailModel();
        eventID = new MutableLiveData<>();
    }

    public void requestUserDetailData(int id){
        final Repository repo = new Repository();
        repo.requestUserDetailData(id, new RequestHandler<UserListDetailResponse>() {

            @Override
            public void onResult(UserListDetailResponse response) {
                handleResult(response);
            }
        });
    }

    private void handleResult(UserListDetailResponse response){
        if(response != null) {
            if(response.getData() != null && response.getAd() != null){
                UserListItemResponse itemUserResponse = response.getData();
                UserListItemModel itemModel = new UserListItemModel()
                        .setId(itemUserResponse.getId().toString())
                        .setEmail(itemUserResponse.getEmail())
                        .setFirst_name(itemUserResponse.getFirst_name())
                        .setLast_name(itemUserResponse.getLast_name())
                        .setAvatar(itemUserResponse.getAvatar());
                userDetailData.setData(itemModel);

                AdResponse adResponse = response.getAd();
                AdModel adModel = new AdModel()
                        .setCompany(adResponse.getCompany())
                        .setUrl(adResponse.getUrl())
                        .setText(adResponse.getText());
                userDetailData.setAd(adModel);

                eventID.postValue(SUCCESS);
            }
            else{
                eventID.postValue(NODATA);
            }
        }
        else{
            eventID.postValue(FAILED);
        }
    }
}
