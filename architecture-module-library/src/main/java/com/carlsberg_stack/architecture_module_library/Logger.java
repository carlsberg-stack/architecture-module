package com.carlsberg_stack.architecture_module_library;

import android.util.Log;


public class Logger {

    public static final boolean DEBUG = BuildConfig.DEBUG;
    private final static String TAG = "Logger";

    /*E*/
    public static void e(String error) {
        e(TAG, error, null);
    }

    public static void e(String tag, String error) {
        e(tag, error, null);
    }

    public static void e(String tag, String error, Exception e) {
        if (DEBUG)
            Log.e(tag, error, e);
    }

    /*D*/
    public static void d(String error) {
        d(TAG, error, null);
    }

    public static void d(String tag, String error) {
        d(tag, error, null);
    }

    public static void d(String tag, String error, Exception e) {
        if (DEBUG)
            Log.d(tag, error, e);
    }

    /*PRINT*/
    public static void print(Exception e) {
        if (DEBUG) {
            if (e != null)
                e.printStackTrace();
        }
    }

    public static void print(Throwable exception) {
        if (DEBUG) {
            if (exception != null)
                exception.printStackTrace();
        }
    }

}
