package com.carlsberg_stack.archetecture_module;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.carlsberg_stack.architecture_module_library.base.CarlsCommunicator;
import com.carlsberg_stack.architecture_module_library.base.CarlsFragment;

public class MainFragment extends CarlsFragment {
    @Override
    protected View carls_bindView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.carls_textview,container,false);
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
