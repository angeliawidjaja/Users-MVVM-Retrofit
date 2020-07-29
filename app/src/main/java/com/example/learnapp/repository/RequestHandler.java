package com.example.learnapp.repository;

import com.example.learnapp.datamodel.userlist.UserListResponse;

public interface RequestHandler {
    void onResult(UserListResponse response);
}
