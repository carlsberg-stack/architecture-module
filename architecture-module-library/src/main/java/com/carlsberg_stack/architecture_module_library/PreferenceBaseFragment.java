package com.carlsberg_stack.architecture_module_library;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceFragmentCompat;



public abstract class PreferenceBaseFragment <T extends BaseCommunicator> extends PreferenceFragmentCompat {

    private static final String TAG = PreferenceBaseFragment.class.getSimpleName();
    protected TextView TVdna;
    protected T communicator;
    protected SharedPreferences defaultPreference;
//    protected PreferenceManager preferenceManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        defaultPreference = PreferenceManager.getDefaultSharedPreferences(getContext());

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
            communicator = (T) context;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(getPreferencesFromResource(), rootKey);
    }


    protected abstract int getPreferencesFromResource();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TVdna = view.findViewById(R.id.tv_dna);
    }

    protected void replaceFragment(BaseFragment fragment, @NonNull Bundle bundle) {
        if (bundle == null)
            return;
        fragment.setArguments(bundle);
        replaceFragment(fragment);
    }

    protected void replaceFragment(BaseFragment fragment, @NonNull Bundle bundle, String tag) {
        if (bundle == null)
            return;
        fragment.setArguments(bundle);
        replaceFragment(fragment, tag);
    }

    protected void replaceFragment(BaseFragment fragment) {
        communicator.replaceFragment(fragment, null);
    }

    protected void replaceFragment(BaseFragment fragment, String tag) {
        communicator.replaceFragment(fragment, tag);
    }

    protected void addFragment(BaseFragment fragment, @NonNull Bundle bundle) {
        if (bundle == null)
            return;
        fragment.setArguments(bundle);
        addFragment(fragment);
    }

    protected void addFragment(BaseFragment fragment) {
        communicator.addFragment(fragment);
    }

    protected void showFragmentDialog(BaseDialogFragment fragment, Bundle bundle) {
        if (bundle != null)
            fragment.setArguments(bundle);
        showFragmentDialog(fragment);
    }

    protected void showFragmentDialog(BaseDialogFragment fragment) {
        communicator.showFragmentDialog(fragment);
    }

    protected void showToast(int message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
//    protected abstract int getViewResource();

    protected void startActivity(Class<? extends BaseActivity> activityClass) {
        startActivity(new Intent(getActivity(), activityClass));
    }

    protected void showConfirmDialog(int message, int textId, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(getActivity(), R.style.Appearance_App_Dailog)
                .setCancelable(false)
                .setTitle(R.string.confirm)
                .setMessage(message)
                .setNegativeButton(R.string.cancel, null)
                .setPositiveButton(textId, listener)
                .create().show();
    }

    protected void showListDialog(int itemId, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle(R.string.select)
                .setItems(itemId, listener)
                .create().show();
    }

    protected void showAlert(int title, String message) {
        new AlertDialog.Builder(getActivity()).setTitle(title).setMessage(message).setNegativeButton(R.string.cancel, null).create().show();
    }

    protected void showAlert(String message) {
        new AlertDialog.Builder(getActivity()).setTitle(R.string.alert).setMessage(message).setNegativeButton(R.string.cancel, null).create().show();
    }

}
