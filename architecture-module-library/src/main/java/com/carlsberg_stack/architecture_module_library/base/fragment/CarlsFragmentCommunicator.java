package com.carlsberg_stack.architecture_module_library.base.fragment;


import androidx.annotation.NonNull;

import com.carlsberg_stack.architecture_module_library.base.base.CarlsDialogFragment;
import com.carlsberg_stack.architecture_module_library.base.base.CarlsFragment;
import com.carlsberg_stack.architecture_module_library.base.broadcast.CarlsBroadcastCommunicator;

public interface CarlsFragmentCommunicator extends CarlsBroadcastCommunicator {
    /*fragments*/
    void frg_replaceFragment(@NonNull CarlsFragment fragment) ;
    void frg_replaceFragment(@NonNull CarlsFragment fragment, String tag) ;
    void frg_addFragment(@NonNull CarlsFragment fragment, String tag) ;
    void frg_addFragment(@NonNull CarlsFragment fragment) ;
    void frg_showDialogFragment(@NonNull CarlsDialogFragment fragment, String tag) ;
    void frg_showDialogFragment(@NonNull CarlsDialogFragment fragment) ;
    void setFragmentTitle(String title);
    void setFragmentTitle(int title);
}