package com.carlsberg_stack.archetecture_module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.carlsberg_stack.architecture_module_library.BaseActivity;
import com.carlsberg_stack.architecture_module_library.helper.ToastMessage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements MainFragmentInterface {

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindViews() {

    }

    @Override
    public void call() {
        ToastMessage.makeDebugToast(getApplicationContext(),"call").show();
    }


    public void toast(View view) {
        switch (view.getId()) {
            case R.id.simple_toast:
                ToastMessage.makeSimpleToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.warning_toast:
                ToastMessage.makeWarningToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.error_toast:
                ToastMessage.makeErrorToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.success_toast:
                ToastMessage.makeSuccessToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
            case R.id.info_toast:
                ToastMessage.makeInfoToast(getApplicationContext(), getString(R.string.app_name)).show();
                break;
        }
    }
}
