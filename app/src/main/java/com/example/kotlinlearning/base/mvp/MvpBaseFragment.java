package com.example.kotlinlearning.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class MvpBaseFragment<P extends Presenter<U>, U extends Ui> extends Fragment implements Ui {

    private final String TAG = "MvpBaseFragment";

    private P mPresenter;

    protected MvpBaseFragment() {
        super();
        mPresenter = createPresenter();
    }

    protected abstract P createPresenter();

    protected abstract U getUi();

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.onUiReady(getUi());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mPresenter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onUiDestroy(getUi());
    }


    @Nullable
    @Override
    public Context getUiContext() throws NullPointerException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getContext();
        } else {
            Activity activity = getActivity();
            if (activity == null) {
                return null;
            }
            return activity;
        }
    }
}
