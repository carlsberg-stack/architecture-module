package com.carlsberg_stack.architecture_module_library.pattern.mvvm;

import android.os.Bundle;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.carlsberg_stack.architecture_module_library.base.CarlsActivity;


public abstract class CarlsMvvmActivity<T extends AndroidViewModel> extends CarlsActivity {

    protected T mvvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.mvvm = createViewModel();
        super.onCreate(savedInstanceState);
    }

    private T createViewModel() {
        return new ViewModelProvider(this).get(createViewModelClass());
    }

    protected abstract Class<T> createViewModelClass();


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
