package com.carlsberg_stack.architecture_module_library;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;


public abstract class CarlsMVVMActivity<T extends CarlsBaseViewModel> extends CarlsBaseActivity {

    protected T mvvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.mvvm = createViewModel();
        super.onCreate(savedInstanceState);
    }

    private T createViewModel() {
        return ViewModelProviders.of(this).get(createViewModelClass());
    }

    protected abstract Class<T> createViewModelClass();


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
