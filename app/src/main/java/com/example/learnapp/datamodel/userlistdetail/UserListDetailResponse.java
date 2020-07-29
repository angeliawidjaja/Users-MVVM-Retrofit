package com.example.learnapp.datamodel.userlistdetail;

import com.example.learnapp.datamodel.userlist.UserListItemResponse;
import com.google.gson.annotations.SerializedName;

public class UserListDetailResponse {
    @SerializedName("data")
    UserListItemResponse data;
    @SerializedName("ad")
    AdResponse ad;

    public UserListItemResponse getData() {
        return data;
    }

    public AdResponse getAd() {
        return ad;
    }
}
