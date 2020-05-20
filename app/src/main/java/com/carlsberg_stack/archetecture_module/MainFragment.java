package com.carlsberg_stack.archetecture_module;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.carlsberg_stack.architecture_module_library.base.CarlsCommunicator;
import com.carlsberg_stack.architecture_module_library.base.CarlsFragment;

public class MainFragment extends CarlsFragment {
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
//        communicator.call();
    }

//    @Override
//    protected Class<MyMvvm> createViewModelClass() {
//        return MyMvvm.class;
//    }
}

interface MainFragmentInterface extends CarlsCommunicator {
    void call();
}
