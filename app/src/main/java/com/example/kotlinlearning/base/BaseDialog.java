package com.example.kotlinlearning.base;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

public abstract class BaseDialog extends Dialog {


    public BaseDialog(@NonNull Context context) {
        super(context);
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    public void show() {
        super.show();
    }
}
