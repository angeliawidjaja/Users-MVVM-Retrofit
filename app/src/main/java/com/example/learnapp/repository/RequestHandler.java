package com.example.learnapp.repository;

public interface RequestHandler<T> {
    void onResult(T response);
}
