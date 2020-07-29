package com.example.learnapp.app.userlist;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;

public class UserListItemModel implements Observable {
    protected Integer id;
    protected String email;
    protected String first_name;
    protected String last_name;
    protected String avatar;

    @Bindable
    public Integer getId() {
        return id;
    }

    public UserListItemModel setId(Integer id) {
        this.id = id;
        return this;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public UserListItemModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Bindable
    public String getFirst_name() {
        return first_name;
    }

    public UserListItemModel setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    @Bindable
    public String getLast_name() {
        return last_name;
    }

    public UserListItemModel setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public UserListItemModel setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    @Bindable
    public String getName(){ return this.first_name + ' ' + this.last_name; }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
