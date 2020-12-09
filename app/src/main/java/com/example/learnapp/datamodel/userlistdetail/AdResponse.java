package com.example.learnapp.datamodel.userlistdetail;

import com.google.gson.annotations.SerializedName;

public class AdResponse {
    @SerializedName("url")
    protected String url;
    @SerializedName("text")
    protected String text;

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }
}
