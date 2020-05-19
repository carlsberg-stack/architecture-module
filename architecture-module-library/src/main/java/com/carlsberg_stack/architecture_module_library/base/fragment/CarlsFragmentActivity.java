package com.carlsberg_stack.architecture_module_library.base.fragment;

import androidx.annotation.NonNull;

import com.carlsberg_stack.architecture_module_library.base.base.CarlsDialogFragment;
import com.carlsberg_stack.architecture_module_library.base.base.CarlsFragment;
import com.carlsberg_stack.architecture_module_library.base.broadcast.CarlsBroadcastActivity;


public abstract class CarlsFragmentActivity extends CarlsBroadcastActivity implements CarlsFragmentCommunicator {

    @Override
    public void frg_replaceFragment(@NonNull CarlsFragment fragment) {
        carls_replaceFragment(getContainerViewId(fragment.getId()), fragment);
    }

    protected abstract int getContainerViewId(int id);

    @Override
    public void frg_replaceFragment(@NonNull CarlsFragment fragment, String tag) {
        carls_replaceFragment(getContainerViewId(fragment.getId()), fragment, tag);
    }

    @Override
    public void frg_addFragment(@NonNull CarlsFragment fragment, String tag) {
        carls_addFragment(getContainerViewId(fragment.getId()), fragment, tag);
    }

    @Override
    public void frg_addFragment(@NonNull CarlsFragment fragment) {
        carls_addFragment(getContainerViewId(fragment.getId()), fragment);
    }

    @Override
    public void frg_showDialogFragment(@NonNull CarlsDialogFragment fragment, String tag) {
        carls_showDialogFragment(fragment, tag);
    }

    @Override
    public void frg_showDialogFragment(@NonNull CarlsDialogFragment fragment) {
        carls_showDialogFragment(fragment);
    }

    @Override
    public void setFragmentTitle(String title) {

    }

    @Override
    public void setFragmentTitle(int title) {

    }
}
