package com.example.learnapp.DataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserListResponse {
    @SerializedName("page")
    protected Integer page;
    @SerializedName("per_page")
    protected Integer per_page;
    @SerializedName("total")
    protected Integer total;
    @SerializedName("total_pages")
    protected Integer total_pages;
    @SerializedName("data")
    protected List<UserListItemResponse> data;

    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public List<UserListItemResponse> getData() {
        return data;
    }
}
