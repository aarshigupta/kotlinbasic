package com.example.kotlinlearning.base.mvp;

import android.app.Activity;
import android.content.Context;

public interface Ui {
    Context getUiContext();

    Activity getActivity();
}
