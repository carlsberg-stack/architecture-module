package com.carlsberg_stack.archetecture_module;

import android.app.Application;

import androidx.annotation.NonNull;

import com.carlsberg_stack.architecture_module_library.CarlsBaseViewModel;

public class MyMvvm extends CarlsBaseViewModel {

    public MyMvvm(@NonNull Application application) {
        super(application);
    }
}
