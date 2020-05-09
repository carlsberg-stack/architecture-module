package com.carlsberg_stack.architecture_module_library;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

public interface BaseCommunicator {

    void frg_startActivity(Class<? extends BaseActivity> activityClass);

    void frg_startActivity(Class<? extends BaseActivity> activityClass,
                           Bundle bundle);

    void frg_startActivity(Class<? extends BaseActivity> activityClass,
                           Bundle bundle,
                           int flags);

    void frg_showToast(String msg);

    void frg_showToast(int msg);

    boolean frg_isInternetAvailable();

    void frg_replaceFragment(@IdRes
                                     int containerViewId,
                             @NonNull
                                     BaseFragment fragment);

    void frg_replaceFragment(@IdRes
                                     int containerViewId,
                             @NonNull
                                     BaseFragment fragment,
                             String tag);

    void frg_addFragment(@IdRes
                                 int containerViewId,
                         @NonNull
                                 BaseFragment fragment,
                         String tag);

    void frg_addFragment(@IdRes
                                 int containerViewId,
                         @NonNull
                                 BaseFragment fragment);

    void frg_showDialogFragment(@NonNull
                                        BaseDialogFragment fragment,
                                String tag);

    void frg_showAlert(int title,
                       String message);

    void frg_showAlert(String message);

    void frg_showListDialog(int items,
                            DialogInterface.OnClickListener listener);

    void frg_showListDialog(int style,
                            int title,
                            int items,
                            DialogInterface.OnClickListener listener);

    <T> void frg_showListDialog(java.util.List<T> items,
                                DialogInterface.OnClickListener listener);

    <T> void frg_showListDialog(int style,
                                int resource,
                                boolean isCancelable,
                                int title,
                                java.util.List<T> items,
                                DialogInterface.OnClickListener listener);

    void frg_showConfirmDialog(int message,
                               int textId,
                               DialogInterface.OnClickListener listener);

    void frg_showDialog(boolean isCancelable,
                        int title,
                        int message,
                        int postiveTextId,
                        DialogInterface.OnClickListener positiveListener,
                        int negativeTextId,
                        DialogInterface.OnClickListener negativeListener);

    void frg_showDialog(boolean isCancelable,
                        int title,
                        String message,
                        int postiveTextId,
                        DialogInterface.OnClickListener positiveListener,
                        int negativeTextId,
                        DialogInterface.OnClickListener negativeListener);

    void frg_showDialog(int style,
                        boolean isCancelable,
                        int title,
                        String message,
                        int postiveTextId,
                        DialogInterface.OnClickListener positiveListener,
                        int negativeTextId,
                        DialogInterface.OnClickListener negativeListener);

    void frg_showDialog(int style,
                        boolean isCancelable,
                        int title,
                        int message,
                        int postiveTextId,
                        DialogInterface.OnClickListener positiveListener,
                        int negativeTextId,
                        DialogInterface.OnClickListener negativeListener);
}