package com.example.kotlinlearning.base;

import android.content.Context;

import androidx.annotation.Nullable;


import java.lang.ref.WeakReference;

public abstract class BaseUiViewModel<H extends BaseViewModelUiHandler> extends BaseModel {
    private final WeakReference<H> uiHandler;

    public BaseUiViewModel(H uiHandler) {
        this.uiHandler = new WeakReference<>(uiHandler);
    }

    @Nullable
    public H getUiHandler() {
        return uiHandler.get();
    }

    @Nullable
    protected Context getContext() {
        if (uiHandler.get() != null) {
            return uiHandler.get().getContext();
        }

        return null;
    }
}
