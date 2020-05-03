package com.carlsberg_stack.architecture_module_library;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.List;


public abstract class BaseDialogFragment<T extends BaseCommunicator> extends DialogFragment {

    protected static final String TAG = BaseDialogFragment.class.getSimpleName();
    protected T communicator;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    protected abstract int getContentView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    protected void replaceFragment(BaseFragment fragment, @NonNull Bundle bundle) {
        if (bundle == null)
            return;
        fragment.setArguments(bundle);
        replaceFragment(fragment);
    }

    protected void replaceFragment(BaseFragment fragment) {
        communicator.replaceFragment(fragment, null);
    }

    protected void addFragment(BaseFragment fragment, @NonNull Bundle bundle) {
        if (bundle == null)
            return;
        fragment.setArguments(bundle);
        addFragment(fragment);
    }

    protected void replaceChildFragment(@IdRes int containerViewId, @NonNull BaseFragment fragment) {
        getChildFragmentManager().beginTransaction().replace(containerViewId, fragment).commit();
    }

    protected void addFragment(BaseFragment fragment) {
        communicator.addFragment(fragment);
    }

    protected void showFragmentDialog(BaseDialogFragment fragment, Bundle bundle) {
        if (bundle != null)
            fragment.setArguments(bundle);
        communicator.showFragmentDialog(fragment);
    }


    protected void showToast(int message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void startActivity(Class<? extends BaseActivity> activityClass) {
        startActivity(new Intent(getActivity(), activityClass));
    }

    protected void showConfirmDialog(int message, int textId, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(getActivity())
                .setCancelable(false)
                .setTitle(R.string.confirm)
                .setMessage(message)
                .setNegativeButton(R.string.cancel, null)
                .setPositiveButton(textId, listener)
                .create().show();
    }

    protected void showListDialog(int itemId, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(getActivity(), R.style.Appearance_App_Dailog)
                .setCancelable(true)
                .setTitle(R.string.select)
                .setItems(itemId, listener)
                .create().show();
    }

    protected <T> void showListDialog(List<T> items, DialogInterface.OnClickListener listener) {
        final ArrayAdapter<T> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.select_dialog_singlechoice);
        arrayAdapter.addAll(items);
        new AlertDialog.Builder(getActivity(), R.style.Appearance_App_Dailog)
                .setCancelable(true)
                .setTitle(R.string.select)
                .setAdapter(arrayAdapter, listener)
                .create().show();
    }

}
