package com.carlsberg_stack.archetecture_module;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.carlsberg_stack.architecture_module_library.BaseDialogFragment;
import com.carlsberg_stack.architecture_module_library.BaseFragment;

public class MainFragment extends BaseDialogFragment {
    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
