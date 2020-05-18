package com.carlsberg_stack.architecture_module_library.base;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.carlsberg_stack.architecture_module_library.base.base.CarlsActivity;
import com.carlsberg_stack.architecture_module_library.helper.BroadcastReceiverModel;
import com.carlsberg_stack.architecture_module_library.helper.CarlsLogger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class CarlsBroadcastActivity extends CarlsActivity implements CarlsBroadcastCommunicator{

    private Map<String, BroadcastReceiverModel> broadcastReceiverMap = new HashMap<>();
    private Set<String> onCreateList = new HashSet<>();
    private Set<String> onStartList = new HashSet<>();
    private Set<String> onResumeList = new HashSet<>();
    private Set<String> onPauseList = new HashSet<>();
    private Set<String> onStopList = new HashSet<>();
    private Set<String> onDestroyList = new HashSet<>();

    protected abstract void registerBroadcastReceiver();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBroadcastReceiver();
        register(onCreateList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        register(onStartList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        register(onResumeList);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregister(onPauseList);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregister(onStopList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregister(onDestroyList);
        broadcastReceiverMap = null;
        onCreateList = null;
        onStartList = null;
        onResumeList = null;
        onPauseList = null;
        onStopList = null;
        onDestroyList = null;
    }

    protected void registerLocalBroadcastReceiver(RegisterBroadcastAction register, UnregisterBroadcastAction unregister, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        String name = broadcastReceiver.getClass().getName();
        if (canRegister(name)) {
            broadcastReceiverMap.put(name, BroadcastReceiverModel.getInstance(broadcastReceiver, intentFilter, register, unregister, true));
            register(register, broadcastReceiver, intentFilter, name);
            unregister(unregister, name);
        }
    }

    protected void registerBroadcastReceiver(RegisterBroadcastAction register, UnregisterBroadcastAction unregister, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        String name = broadcastReceiver.getClass().getName();
        if (canRegister(name)) {
            broadcastReceiverMap.put(name, BroadcastReceiverModel.getInstance(broadcastReceiver, intentFilter, register, unregister, false));
            register(register, broadcastReceiver, intentFilter, name);
            unregister(unregister, name);
        }
    }


    /*register and unregister*/
    private void registerLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(broadcastReceiver, intentFilter);
    }

    private void unRegisterLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(broadcastReceiver);
    }

    private void registerBroadcastReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        registerReceiver(broadcastReceiver, intentFilter);
    }

    private void unRegisterBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        unregisterReceiver(broadcastReceiver);
    }

    private boolean canRegister(String name) {
        if (broadcastReceiverMap.containsKey(name)) {
            CarlsLogger.w("Broadcast receiver is already added, Please add action in intenet filter");
            return false;
        }
        return true;
    }

    private void register(RegisterBroadcastAction register, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String name) {
        switch (register) {
            case ON_CREATE:
                onCreateList.add(name);
                break;
            case ON_START:
                onStartList.add(name);
                break;
            case ON_RESUME:
                onResumeList.add(name);
                break;
        }
    }

    private void register(Set<String> receivers) {
        if(receivers.isEmpty())
            return;
        BroadcastReceiverModel broadcastReceiverModel;
        for (String receiver:
                receivers) {
            broadcastReceiverModel = broadcastReceiverMap.get(receiver);
            if(broadcastReceiverModel.isLocal())
                registerLocalBroadcastReceiver(broadcastReceiverModel.getBroadcastReceiver(),broadcastReceiverModel.getIntentFilter());
            else
                registerBroadcastReceiver(broadcastReceiverModel.getBroadcastReceiver(),broadcastReceiverModel.getIntentFilter());
        }
    }

    private void unregister(UnregisterBroadcastAction unregister, String name) {
        switch (unregister) {
            case ON_PAUSE:
                onPauseList.add(name);
                break;
            case ON_STOP:
                onStopList.add(name);
                break;
            case ON_DESTROY:
                onDestroyList.add(name);
                break;
        }
    }

    private void unregister(Set<String> receivers) {
        if(receivers.isEmpty())
            return;
        BroadcastReceiverModel broadcastReceiverModel;
        for (String receiver:
                receivers) {
            broadcastReceiverModel = broadcastReceiverMap.get(receiver);
            if(broadcastReceiverModel.isLocal())
                unRegisterLocalBroadcastReceiver(broadcastReceiverModel.getBroadcastReceiver());
            else
                unRegisterBroadcastReceiver(broadcastReceiverModel.getBroadcastReceiver());
        }
    }

    public enum RegisterBroadcastAction {
        ON_CREATE, ON_START, ON_RESUME
    }

    public enum UnregisterBroadcastAction {
        ON_PAUSE, ON_STOP, ON_DESTROY
    }
}
