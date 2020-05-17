package com.carlsberg_stack.architecture_module_library;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public abstract class CarlsBaseViewModel extends AndroidViewModel {

    public CarlsBaseViewModel(@NonNull Application application) {
        super(application);
    }

}
