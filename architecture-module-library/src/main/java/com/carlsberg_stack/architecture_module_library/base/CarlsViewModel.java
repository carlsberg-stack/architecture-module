package com.carlsberg_stack.architecture_module_library.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public abstract class CarlsViewModel extends AndroidViewModel {

    public CarlsViewModel(@NonNull Application application) {
        super(application);
    }

}
