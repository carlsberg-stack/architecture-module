package com.carlsberg_stack.archetecture_module;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.carlsberg_stack.architecture_module_library.CarlsBaseCommunicator;
import com.carlsberg_stack.architecture_module_library.CarlsMVVMFragment;

public class MainFragment extends CarlsMVVMFragment<MyMvvm,MainFragmentInterface> {
    @Override
    protected void bindViews(View view) {

    }

    @Override
    protected int getContentView() {
        return R.layout.carls_textview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator.call();
    }

    @Override
    protected Class<MyMvvm> createViewModelClass() {
        return MyMvvm.class;
    }
}

interface MainFragmentInterface extends CarlsBaseCommunicator {
    void call();
}
