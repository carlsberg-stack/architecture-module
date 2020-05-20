package com.carlsberg_stack.archetecture_module;

import android.app.Application;

import androidx.annotation.NonNull;

import com.carlsberg_stack.architecture_module_library.base.CarlsViewModel;

public class MyMvvm extends CarlsViewModel {

    public MyMvvm(@NonNull Application application) {
        super(application);
    }
}
