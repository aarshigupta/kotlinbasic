package com.example.kotlinlearning.base;

import androidx.lifecycle.ViewModel;

public class BaseModel extends ViewModel {
    public enum LoadingState {
        NONE,
        FAILED,
        LOADING,
        LOADED
    }
}
