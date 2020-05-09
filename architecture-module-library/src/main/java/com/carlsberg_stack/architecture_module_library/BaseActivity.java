package com.carlsberg_stack.architecture_module_library;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.carlsberg_stack.architecture_module_library.helper.ToastMessage;

import java.util.List;


public abstract class BaseActivity extends AppCompatActivity implements BaseCommunicator {


    private final static int NONE = -1;
    protected SharedPreferences defaultPreference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        bindViews();
        defaultPreference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }

    protected abstract int getContentView();

    protected abstract void bindViews();


    protected void startActivity(Class<? extends BaseActivity> activityClass) {
        startActivity(activityClass, null, NONE);
    }

    protected void startActivity(Class<? extends BaseActivity> activityClass, Bundle bundle) {
        startActivity(activityClass, bundle, NONE);
    }


    protected void startActivity(Class<? extends BaseActivity> activityClass, Bundle bundle, int flags) {
        Intent intent = new Intent(this, activityClass);
        if (flags != NONE)
            intent.setFlags(flags);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void showToast(String msg) {
        ToastMessage.makeSimpleToast(getApplicationContext(), msg);
    }

    protected void showToast(int msg) {
        ToastMessage.makeSimpleToast(getApplicationContext(), getString(msg));
    }


    protected boolean isInternetAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }

    protected void replaceFragment(@IdRes int containerViewId, @NonNull BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(containerViewId, fragment).commit();
    }

    /**
     * @param containerViewId
     * @param fragment
     * @param tag             - allow to add to in stack
     */
    protected void replaceFragment(@IdRes int containerViewId, @NonNull BaseFragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(containerViewId, fragment, tag).addToBackStack(tag).commit();
    }

    /**
     * @param containerViewId
     * @param fragment
     * @param tag             - allow to add to in stack
     */
    protected void addFragment(@IdRes int containerViewId, @NonNull BaseFragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().add(containerViewId, fragment).addToBackStack(tag).commit();
    }

    protected void addFragment(@IdRes int containerViewId, @NonNull BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().add(containerViewId, fragment).commit();
    }

    protected void showDialogFragment(@NonNull BaseDialogFragment fragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(tag);
        fragment.show(ft, tag);
    }

    /**
     * @param title
     * @param message
     */
    protected void showAlert(int title, String message) {
        showDialog(false, title, message, R.string.okay, null, R.string.cancel, null);
    }

    /**
     * @param message
     */
    protected void showAlert(String message) {
        showDialog(false, R.string.alert, message, R.string.okay, null, R.string.cancel, null);
    }

    /**
     * @param items
     * @param listener
     */
    protected void showListDialog(int items, DialogInterface.OnClickListener listener) {
        showListDialog(NONE, NONE, items, listener);
    }

    protected void showListDialog(int style, int title, int items, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this, style == NONE ? R.style.Appearance_App_Dialog : style).setItems(items, listener).setTitle(title == NONE ? R.string.select : title).create().show();
    }

    /**
     * @param items
     * @param listener
     * @param <T>
     */
    protected <T> void showListDialog(List<T> items, DialogInterface.OnClickListener listener) {
        showListDialog(NONE, NONE, false, NONE, items, listener);
    }

    protected <T> void showListDialog(int style, int resource, boolean isCancelable, int title, List<T> items, DialogInterface.OnClickListener listener) {
        final ArrayAdapter<T> arrayAdapter = new ArrayAdapter<>(this, resource == NONE ? R.layout.textview : resource, items);
        new AlertDialog.Builder(this, style == NONE ? R.style.Appearance_App_Dialog : style)
                .setCancelable(isCancelable)
                .setTitle(title == NONE ? R.string.select : title)
                .setAdapter(arrayAdapter, listener)
                .create().show();
    }

    @Override
    public void frg_startActivity(Class<? extends BaseActivity> activityClass) {
        startActivity(activityClass);
    }

    @Override
    public void frg_startActivity(Class<? extends BaseActivity> activityClass, Bundle bundle) {
        startActivity(activityClass, bundle);
    }

    @Override
    public void frg_startActivity(Class<? extends BaseActivity> activityClass, Bundle bundle, int flags) {
        startActivity(activityClass, bundle, flags);
    }

    @Override
    public void frg_showToast(String msg) {
        showToast(msg);
    }

    @Override
    public void frg_showToast(int msg) {
        showToast(msg);
    }

    @Override
    public boolean frg_isInternetAvailable() {
        return isInternetAvailable();
    }

    @Override
    public void frg_replaceFragment(int containerViewId, @NonNull BaseFragment fragment) {
        replaceFragment(containerViewId, fragment);
    }

    @Override
    public void frg_replaceFragment(int containerViewId, @NonNull BaseFragment fragment, String tag) {
        replaceFragment(containerViewId, fragment, tag);
    }

    @Override
    public void frg_addFragment(int containerViewId, @NonNull BaseFragment fragment, String tag) {
        addFragment(containerViewId, fragment, tag);

    }

    @Override
    public void frg_addFragment(int containerViewId, @NonNull BaseFragment fragment) {
        addFragment(containerViewId, fragment);
    }

    @Override
    public void frg_showDialogFragment(@NonNull BaseDialogFragment fragment, String tag) {
        showDialogFragment(fragment, tag);

    }

    @Override
    public void frg_showAlert(int title, String message) {
        showAlert(title, message);
    }

    @Override
    public void frg_showAlert(String message) {
        showAlert(message);
    }

    @Override
    public void frg_showListDialog(int items, DialogInterface.OnClickListener listener) {
        showListDialog(items, listener);
    }

    @Override
    public void frg_showListDialog(int style, int title, int items, DialogInterface.OnClickListener listener) {
        showListDialog(style, title, items, listener);
    }

    @Override
    public <T> void frg_showListDialog(List<T> items, DialogInterface.OnClickListener listener) {
        showListDialog(items, listener);
    }

    @Override
    public <T> void frg_showListDialog(int style, int resource, boolean isCancelable, int title, List<T> items, DialogInterface.OnClickListener listener) {
        showListDialog(style, resource, isCancelable, title, items, listener);
    }

    @Override
    public void frg_showDialog(boolean isCancelable, int title, int message, int postiveTextId, DialogInterface.OnClickListener positiveListener, int negativeTextId, DialogInterface.OnClickListener negativeListener) {
        showDialog(isCancelable, title, message, postiveTextId, positiveListener, negativeTextId, negativeListener);
    }

    @Override
    public void frg_showDialog(boolean isCancelable, int title, String message, int postiveTextId, DialogInterface.OnClickListener positiveListener, int negativeTextId, DialogInterface.OnClickListener negativeListener) {
        showDialog(isCancelable, title, message, postiveTextId, positiveListener, negativeTextId, negativeListener);

    }

    @Override
    public void frg_showDialog(int style, boolean isCancelable, int title, String message, int postiveTextId, DialogInterface.OnClickListener positiveListener, int negativeTextId, DialogInterface.OnClickListener negativeListener) {
        showDialog(style, isCancelable, title, message, postiveTextId, positiveListener, negativeTextId, negativeListener);
    }

    @Override
    public void frg_showDialog(int style, boolean isCancelable, int title, int message, int postiveTextId, DialogInterface.OnClickListener positiveListener, int negativeTextId, DialogInterface.OnClickListener negativeListener) {
        showDialog(style, isCancelable, title, message, postiveTextId, positiveListener, negativeTextId, negativeListener);
    }

    @Override
    public void frg_showConfirmDialog(int message, int textId, DialogInterface.OnClickListener listener) {
        showConfirmDialog(message, textId, listener);
    }

    /**
     * @param message
     * @param textId
     * @param listener
     */
    protected void showConfirmDialog(int message, int textId, DialogInterface.OnClickListener listener) {
        showDialog(false, R.string.confirm, message, textId, listener, R.string.cancel, null);
    }


    /**
     * @param isCancelable
     * @param title
     * @param message
     * @param postiveTextId
     * @param positiveListener
     * @param negativeTextId
     * @param negativeListener
     */
    protected void showDialog(boolean isCancelable, int title, int message, int postiveTextId, DialogInterface.OnClickListener positiveListener, int negativeTextId, DialogInterface.OnClickListener negativeListener) {
        showDialog(NONE, isCancelable, title, message, postiveTextId, positiveListener, negativeTextId, negativeListener);
    }

    /**
     * @param isCancelable
     * @param title
     * @param message
     * @param postiveTextId
     * @param positiveListener
     * @param negativeTextId
     * @param negativeListener
     */
    protected void showDialog(boolean isCancelable, int title, String message, int postiveTextId, DialogInterface.OnClickListener positiveListener, int negativeTextId, DialogInterface.OnClickListener negativeListener) {
        showDialog(NONE, isCancelable, title, message, postiveTextId, positiveListener, negativeTextId, negativeListener);
    }

    /**
     * @param style
     * @param isCancelable
     * @param title
     * @param message
     * @param postiveTextId
     * @param positiveListener
     * @param negativeTextId
     * @param negativeListener
     */
    protected void showDialog(int style, boolean isCancelable, int title, String message, int postiveTextId, DialogInterface.OnClickListener positiveListener, int negativeTextId, DialogInterface.OnClickListener negativeListener) {
        new AlertDialog.Builder(this, style == NONE ? R.style.Appearance_App_Dialog : style)
                .setCancelable(isCancelable)
                .setTitle(title == NONE ? R.string.alert : title)
                .setMessage(message)
                .setNegativeButton(negativeTextId, negativeListener)
                .setPositiveButton(postiveTextId, positiveListener)
                .create().show();
    }

    /**
     * @param style            - Style that needed
     * @param isCancelable     - For outSide Touch
     * @param title            - Title of the dialog
     * @param message          - Message of dialog
     * @param postiveTextId    - Positive Text Id
     * @param positiveListener - postive listner
     * @param negativeTextId - negative text id
     * @param negativeListener - negative listner
     */
    protected void showDialog(int style, boolean isCancelable, int title, int message, int postiveTextId, DialogInterface.OnClickListener positiveListener, int negativeTextId, DialogInterface.OnClickListener negativeListener) {
        new AlertDialog.Builder(this, style == NONE ? R.style.Appearance_App_Dialog : style)
                .setCancelable(isCancelable)
                .setTitle(title == NONE ? R.string.alert : title)
                .setMessage(message)
                .setNegativeButton(negativeTextId, negativeListener)
                .setPositiveButton(postiveTextId, positiveListener)
                .create().show();
    }


}
