package com.example.learnapp.datamodel.userlistdetail;

import com.example.learnapp.datamodel.userlist.UserListItemResponse;
import com.google.gson.annotations.SerializedName;

public class UserListDetailResponse {
    @SerializedName("data")
    UserListItemResponse data;
    @SerializedName("support")
    AdResponse support;

    public UserListItemResponse getData() {
        return data;
    }

    public AdResponse getSupport() {
        return support;
    }
}
