package com.example.kotlinlearning.base.mvvm;

import androidx.annotation.Nullable;

public abstract class BaseViewModelFragment extends BaseFragment {
    @Nullable
    protected final BaseViewModelFactory getViewModelFactory() {
        if (getActivity() == null) {
            return null;
        }
        if (getActivity() instanceof BHViewModelFactoryOwner) {
            return ((BHViewModelFactoryOwner) getActivity()).getViewModelFactory();
        } else {
            throw new IllegalStateException();
        }
    }
}
