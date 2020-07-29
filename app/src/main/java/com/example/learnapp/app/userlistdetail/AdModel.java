package com.example.learnapp.app.userlistdetail;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;

public class AdModel implements Observable {
    protected String company;
    protected String url;
    protected String text;

    @Bindable
    public String getCompany() {
        return company;
    }

    public AdModel setCompany(String company) {
        this.company = company;
        return this;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public AdModel setUrl(String url) {
        this.url = url;
        return this;
    }

    @Bindable
    public String getText() {
        return text;
    }

    public AdModel setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
