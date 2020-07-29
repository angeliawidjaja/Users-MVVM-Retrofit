package com.example.learnapp.datamodel.userlist;

import com.google.gson.annotations.SerializedName;

public class UserListItemResponse {
    @SerializedName("id")
    protected Integer id;
    @SerializedName("email")
    protected String email;
    @SerializedName("first_name")
    protected String first_name;
    @SerializedName("last_name")
    protected String last_name;
    @SerializedName("avatar")
    protected String avatar;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}
