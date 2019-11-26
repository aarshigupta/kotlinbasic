package com.example.kotlinlearning.base.mvp;

import android.os.Bundle;

import androidx.annotation.CallSuper;

public abstract class Presenter<U extends Ui> {
    private U mUi;

    public U getUi() {
        return mUi;
    }

    @CallSuper
    public void onUiReady(U ui) {
        mUi = ui;
    }

    public void onUiUnready(U ui) {
    }

    @CallSuper
    public final void onUiDestroy(U ui) {
        onUiUnready(ui);
        mUi = null;
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }


    protected boolean isUiNull() {
        return mUi == null;
    }
}
