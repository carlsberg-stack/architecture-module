package com.carlsberg_stack.architecture_module_library.base.broadcast;


import android.content.BroadcastReceiver;
import android.content.IntentFilter;

import com.carlsberg_stack.architecture_module_library.base.base.CarlsCommunicator;

public interface CarlsBroadcastCommunicator extends CarlsCommunicator {
    void frg_registerLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    void frg_unRegisterLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver);

    void frg_registerBroadcastReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    void frg_unRegisterBroadcastReceiver(BroadcastReceiver broadcastReceiver);
}