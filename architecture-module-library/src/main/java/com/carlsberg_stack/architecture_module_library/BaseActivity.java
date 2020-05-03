package com.carlsberg_stack.architecture_module_library;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;


public abstract class BaseActivity extends AppCompatActivity {


    protected SharedPreferences defaultPreference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(getContentView());
        defaultPreference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }

    protected abstract int getContentView();

    // start activities

    protected void startActivity(Class<? extends BaseActivity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    protected void startActivity(Class<? extends BaseActivity> activityClass, Bundle bundle) {
        Intent intent = new Intent(this, activityClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    // sh7ow msg4

    protected void showToast(String msg) {
        if (msg == null || msg.isEmpty())
            return;
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    // ch7eck connectiom

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

    protected void replaceFragmentNow(@IdRes int containerViewId, @NonNull BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(containerViewId, fragment).commitNow();
    }

    protected void replaceFragment(@IdRes int containerViewId, @NonNull BaseFragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(containerViewId, fragment, tag).addToBackStack(tag).commit();
    }

    protected void addFragment(@IdRes int containerViewId, @NonNull BaseFragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().add(containerViewId, fragment).addToBackStack(tag).commit();
    }

    protected void showDialogFragment(@NonNull BaseDialogFragment fragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        fragment.show(ft, fragment.getTag());
    }

    protected void showAlert(int title, String message) {
        new AlertDialog.Builder(this, R.style.Appearance_App_Dialog).setTitle(title).setMessage(message).setNegativeButton(R.string.cancel, null).create().show();
    }

    protected void showAlert(String message) {
        new AlertDialog.Builder(this, R.style.Appearance_App_Dialog).setTitle(R.string.alert).setMessage(message).setNegativeButton(R.string.cancel, null).create().show();
    }

    protected void showListDialog(int title, int items, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this, R.style.Appearance_App_Dialog).setItems(items, listener).setTitle(title).create().show();
    }

    protected <T> void showListDialog(List<T> items, DialogInterface.OnClickListener listener) {
        final ArrayAdapter<T> arrayAdapter = new ArrayAdapter<>(this, R.layout.textview, items);
        new AlertDialog.Builder(this, R.style.Appearance_App_Dialog)
                .setCancelable(true)
                .setTitle(R.string.select)
                .setAdapter(arrayAdapter, listener)
                .create().show();
    }

    protected void showConfirmDialog(int message, int textId, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(this, R.style.Appearance_App_Dialog)
                .setCancelable(false)
                .setTitle(R.string.confirm)
                .setMessage(message)
                .setNegativeButton(R.string.cancel, null)
                .setPositiveButton(textId, listener)
                .create().show();
    }

}
