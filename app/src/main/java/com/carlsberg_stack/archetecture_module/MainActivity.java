package com.carlsberg_stack.archetecture_module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.carlsberg_stack.architecture_module_library.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    public void clicked(View view) {
        switch (view.getId()){
            case R.id.test_dialog_1:
                showListDialog(R.string.alert, R.array.test, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                break;
         case R.id.test_dialog_2:
             List<String> strings=new ArrayList<>();
             strings.add("Test 1");
             strings.add("Test 1");
             strings.add("Test 1");
             strings.add("Test 1");
             strings.add("Test 1");
             showListDialog(strings, new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {

                 }
             });
                break;
        }

    }
}
