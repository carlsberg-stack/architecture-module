package com.carlsberg_stack.archetecture_module;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.carlsberg_stack.architecture_module_library.BaseCommunicator;
import com.carlsberg_stack.architecture_module_library.BaseDialogFragment;
import com.carlsberg_stack.architecture_module_library.BaseFragment;
import com.carlsberg_stack.architecture_module_library.MVVMFragment;

public class MainFragment extends MVVMFragment<MyMvvm,MainFragmentInterface> {
    @Override
    protected void bindViews(View view) {

    }

    @Override
    protected int getContentView() {
        return R.layout.textview;
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

interface MainFragmentInterface extends BaseCommunicator {
    void call();
}
