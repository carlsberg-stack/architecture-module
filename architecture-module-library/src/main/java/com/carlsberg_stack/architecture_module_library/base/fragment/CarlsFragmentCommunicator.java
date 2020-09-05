package com.carlsberg_stack.architecture_module_library.base.fragment;


import androidx.annotation.NonNull;

import com.carlsberg_stack.architecture_module_library.base.CarlsCommunicator;
import com.carlsberg_stack.architecture_module_library.base.CarlsFragment;

public interface CarlsFragmentCommunicator extends CarlsCommunicator {
    /*fragments*/
    void frgReplaceFragment(@NonNull CarlsFragment fragment);

    void frgReplaceFragment(@NonNull CarlsFragment fragment, String tag);

    void frgAddFragment(@NonNull CarlsFragment fragment, String tag);

    void frgAddFragment(@NonNull CarlsFragment fragment);
}