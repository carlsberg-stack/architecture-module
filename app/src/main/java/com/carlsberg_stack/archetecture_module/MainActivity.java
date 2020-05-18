package com.carlsberg_stack.archetecture_module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;

import com.carlsberg_stack.architecture_module_library.base.CarlsBroadcastActivity;
import com.carlsberg_stack.architecture_module_library.helper.ToastMessage;

public class MainActivity extends CarlsBroadcastActivity implements MainFragmentInterface {

    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

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
            case R.id.show_list:
                carls_showListDialog(R.array.test,null);
                break;
            case R.id.show_alert:
                carls_showAlert(R.string.app_name);
                break;
            case R.id.show_confirm:
                carls_showConfirmDialog(R.string.app_name,null);
                break;
        }
    }

    @Override
    protected void carls_indexBroadcastReceiver() {
        carls_registerBroadcastReceiver(RegisterBroadcastAction.CARLS_ON_RESUME,UnregisterBroadcastAction.CARLS_ON_STOP,broadcastReceiver,new IntentFilter());
        carls_registerBroadcastReceiver(RegisterBroadcastAction.CARLS_ON_CREATE,UnregisterBroadcastAction.CARLS_ON_DESTROY,broadcastReceiver,new IntentFilter());
    }
}
