package com.example.learnapp;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;

import java.util.List;

public class UserListModel implements Observable {
    public static final int FINAL_PAGE = 100;

    protected Integer page;
    protected Integer per_page;
    protected Integer total;
    protected Integer total_pages;
    protected List<UserListItemModel> userList;
    protected int eventId;

    @Bindable
    public Integer getPage() {
        return page;
    }

    public UserListModel setPage(Integer page) {
        this.page = page;
        return this;
    }

    @Bindable
    public Integer getPer_page() {
        return per_page;
    }

    public UserListModel setPer_page(Integer per_page) {
        this.per_page = per_page;
        return this;
    }

    @Bindable
    public Integer getTotal() {
        return total;
    }

    public UserListModel setTotal(Integer total) {
        this.total = total;
        return this;
    }

    @Bindable
    public Integer getTotal_pages() {
        return total_pages;
    }

    public UserListModel setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
        return this;
    }

    @Bindable
    public List<UserListItemModel> getUserList() {
        return userList;
    }

    public UserListModel setUserList(List<UserListItemModel> userList) {
        this.userList = userList;
        return this;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    public UserListModel() {
        this.page = 0;
        this.per_page = 0;
        this.total = 0;
        this.total_pages = 0;
        this.userList = null;
    }
}
