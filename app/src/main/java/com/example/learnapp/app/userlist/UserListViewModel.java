package com.example.learnapp.app.userlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.learnapp.datamodel.userlist.UserListItemResponse;
import com.example.learnapp.datamodel.userlist.UserListResponse;
import com.example.learnapp.repository.Repository;
import com.example.learnapp.repository.RequestHandler;

import java.util.ArrayList;
import java.util.List;


public class UserListViewModel extends ViewModel {
    public static Integer SUCCESS = 101;
    public static Integer FAILED = 102;
    public static Integer EXCEED = 103;
    public static Integer NODATA = 104;

    private UserListModel data;
    private List<UserListItemModel> userList;

    private int currPage;
    private int totalPage;
    private MutableLiveData<Integer> eventID;

    public UserListViewModel() {
        super();
        currPage = 1;
        totalPage = 0;
        data = new UserListModel();
        eventID = new MutableLiveData<>();
        userList = new ArrayList<>();
    }

    public UserListModel getData() {
        return data;
    }

    public LiveData<Integer> getEventID() {
        return eventID;
    }

    public void requestSelectedData(){
        if(currPage > totalPage && totalPage != 0){
            eventID.postValue(EXCEED);
        }
        else {
            final Repository repo = new Repository();
            repo.requestData(3, currPage++, new RequestHandler() {

                @Override
                public void onResult(Object response) {
                    handleResult((UserListResponse) response);
                }
            });
        }
    }

    private void handleResult(UserListResponse response){
        if(response != null) {
            data.setPage(response.getPage())
                    .setPer_page(response.getPer_page())
                    .setTotal(response.getTotal())
                    .setTotal_pages(response.getTotal_pages());

            List<UserListItemResponse> itemResponseList = response.getData();
            if (itemResponseList != null) {
                for (UserListItemResponse itemResponse : itemResponseList) {
                    UserListItemModel itemData = new UserListItemModel()
                            .setId(itemResponse.getId())
                            .setEmail(itemResponse.getEmail())
                            .setFirst_name(itemResponse.getFirst_name())
                            .setLast_name(itemResponse.getLast_name())
                            .setAvatar(itemResponse.getAvatar());
                    userList.add(itemData);
                }
                data.setUserList(userList);

                totalPage = data.getTotal_pages();
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
