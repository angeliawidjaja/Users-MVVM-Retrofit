package com.example.learnapp;

import com.example.learnapp.DataModel.UserListResponse;

public interface RequestHandler {
    void onResult(UserListResponse response);
}
