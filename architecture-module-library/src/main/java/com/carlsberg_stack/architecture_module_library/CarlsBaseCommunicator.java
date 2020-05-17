package com.carlsberg_stack.architecture_module_library;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

import java.util.List;

public interface CarlsBaseCommunicator {

    /*activity*/
    void frg_startActivity(Class<? extends CarlsBaseActivity> activityClass);
    void frg_startActivity(Class<? extends CarlsBaseActivity> activityClass,
                           Bundle bundle);
    void frg_startActivity(Class<? extends CarlsBaseActivity> activityClass,
                           Bundle bundle,
                           int flags);

    /*toast*/
    void frg_showToast(String msg);
    void frg_showToast(int msg);

    boolean frg_isInternetAvailable();

    /*fragments*/
     void frg_replaceFragment(@IdRes int containerViewId, @NonNull CarlsBaseFragment fragment) ;
     void frg_replaceFragment(@IdRes int containerViewId, @NonNull CarlsBaseFragment fragment, String tag) ;
     void frg_addFragment(@IdRes int containerViewId, @NonNull CarlsBaseFragment fragment, String tag) ;
     void frg_addFragment(@IdRes int containerViewId, @NonNull CarlsBaseFragment fragment) ;
     void frg_showDialogFragment(@NonNull CarlsBaseDialogFragment fragment, String tag) ;
     void frg_showDialogFragment(@NonNull CarlsBaseDialogFragment fragment) ;

    /*list dialog*/
     void frg_showListDialog(int items, DialogInterface.OnClickListener listener);
     void frg_showListDialog(int style, int items, DialogInterface.OnClickListener listener) ;
     void frg_showListDialog(int style,boolean isCancelable, int title, int items, DialogInterface.OnClickListener listener) ;
    <T> void frg_showListDialog(List<T> items, DialogInterface.OnClickListener listener);
     <T> void frg_showListDialog(int style,List<T> items, DialogInterface.OnClickListener listener) ;
     <T> void frg_showListDialog(int style, int resource, boolean isCancelable, int title, List<T> items, DialogInterface.OnClickListener listener) ;

    /*dialog*/
    void frg_showDialog(boolean isCancelable,
                        int title,
                        int message,
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

    /*confirm*/
    void frg_showConfirmDialog(int message, int textId, DialogInterface.OnClickListener listener);
    void frg_showConfirmDialog(int message, DialogInterface.OnClickListener listener);
    void frg_showConfirmDialog(int style,int message, int textId, DialogInterface.OnClickListener listener);
    void frg_showConfirmDialog_(int style,int message, DialogInterface.OnClickListener listener) ;

    /*alert*/
     void frg_showAlert(int title, int message) ;
     void frg_showAlert(int message) ;
     void frg_showAlert(int style,int title, int message);
     void frg_showAlert_(int style,int message) ;
}