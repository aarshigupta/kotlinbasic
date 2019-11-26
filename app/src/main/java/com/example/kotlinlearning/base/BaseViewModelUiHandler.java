package com.example.kotlinlearning.base;

import android.content.Context;

import androidx.annotation.Nullable;

public interface BaseViewModelUiHandler {
    @Nullable
    Context getContext();

    //Base Toast
    void showToast(String message);
}
