package com.example.kotlinlearning.base.mvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.kotlinlearning.base.BaseUiViewModel;
import com.example.kotlinlearning.base.BaseViewModelUiHandler;

public class BaseUiViewModelFactory<H extends BaseViewModelUiHandler> extends ViewModelProvider.NewInstanceFactory implements BaseViewModelFactory {
    protected final H uiHandler;
    private final Class<H> uiHandlerClass;

    public BaseUiViewModelFactory(H uiHandler, Class<H> uiHandlerClass) {
        this.uiHandler = uiHandler;
        this.uiHandlerClass = uiHandlerClass;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (BaseUiViewModel.class.isAssignableFrom(modelClass)) {
            try {
                return modelClass.getConstructor(uiHandlerClass)
                        .newInstance(uiHandler);
            } catch (Exception e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            }
        }
        return super.create(modelClass);
    }
}

