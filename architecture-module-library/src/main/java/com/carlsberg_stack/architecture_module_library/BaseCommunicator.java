package com.carlsberg_stack.architecture_module_library;


import android.content.DialogInterface;
import android.os.Bundle;

import java.util.List;

public interface BaseCommunicator {

    void frg_replaceFragment(BaseFragment aClass, Bundle bundle, String tag);

    void frg_addFragment(BaseFragment aClass, Bundle bundle, String tag);

    void frg_showFragmentDialog(BaseDialogFragment aClass, Bundle bundle, String tag);

    void frg_setFragmentTitle(String title);

    <T> void frg_showListDialog(List<T> items, DialogInterface.OnClickListener listener);

    void frg_showAlert(int title, String message);

    void frg_showAlert(String message);

    void frg_showListDialog(int itemId, DialogInterface.OnClickListener listener);

    void frg_showConfirmDialog(int message, int textId, DialogInterface.OnClickListener listener);

    void frg_startActivity(Class<? extends BaseActivity> activityClass);
}