package com.example.learnapp.app.userlistdetail;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;

import com.example.learnapp.app.userlist.UserListItemModel;

public class UserListDetailModel implements Observable {
    protected UserListItemModel data;
    protected AdModel ad;

    @Bindable
    public UserListItemModel getData() {
        return data;
    }

    public UserListDetailModel setData(UserListItemModel data) {
        this.data = data;
        return this;
    }

    @Bindable
    public AdModel getAd() {
        return ad;
    }

    public UserListDetailModel setAd(AdModel ad) {
        this.ad = ad;
        return this;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
