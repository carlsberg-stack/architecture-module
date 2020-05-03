package com.carlsberg_stack.architecture_module_library;



public interface BaseCommunicator {

    void replaceFragment(BaseFragment aClass, String tag);

    void addFragment(BaseFragment aClass);

    void showFragmentDialog(BaseDialogFragment aClass);

    void setFragmentTitle(String title);

}