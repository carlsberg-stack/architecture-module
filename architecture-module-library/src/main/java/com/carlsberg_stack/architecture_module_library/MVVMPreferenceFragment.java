package com.carlsberg_stack.architecture_module_library;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;


public abstract class MVVMPreferenceFragment<T extends BaseViewModel,C extends BaseCommunicator> extends PreferenceBaseFragment<C> {


    protected T mvvm;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mvvm = createViewModel();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private T createViewModel() {
        return ViewModelProviders.of(this).get(createViewModelClass());
    }

    protected abstract Class<T> createViewModelClass();


    @Override
    public void onDetach() {
        mvvm = null;
        super.onDetach();

    }

}
