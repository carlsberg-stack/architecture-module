package com.carlsberg_stack.architecture_module_library.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.carlsberg_stack.architecture_module_library.R;

public class ToastMessage {

    private static Toast makeText(@NonNull Context context, int background_resource, int color_resource, @NonNull CharSequence text) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast, null);

        TextView textview = layout.findViewById(R.id.text);
        textview.setText(text);
        textview.setBackgroundResource(background_resource);
        textview.setTextColor(context.getColor(color_resource));
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        return toast;
    }

    public static Toast makeErrorToast(@NonNull Context context, @NonNull CharSequence text) {
        return makeText(context, R.drawable.rect_with_corner_fill_trans_stroke_red, R.color.colorRed, text);
    }

    public static Toast makeWarningToast(@NonNull Context context, @NonNull CharSequence text) {
        return makeText(context, R.drawable.rect_with_corner_fill_trans_stroke_yellow, R.color.colorYellow, text);
    }

    public static Toast makeSuccessToast(@NonNull Context context, @NonNull CharSequence text) {
        return makeText(context, R.drawable.rect_with_corner_fill_trans_stroke_green, R.color.colorGreen, text);
    }

    public static Toast makeDebugToast(@NonNull Context context, @NonNull CharSequence text) {
        return makeText(context, R.drawable.rect_with_corner_fill_trans_stroke_black, R.color.colorChocorol, text);
    }

    public static Toast makeInfoToast(@NonNull Context context, @NonNull CharSequence text) {
        return makeText(context, R.drawable.rect_with_corner_fill_trans_stroke_blue, R.color.colorBlue, text);
    }

    public static Toast makeSimpleToast(@NonNull Context context, @NonNull CharSequence text) {
        return Toast.makeText(context, text, Toast.LENGTH_SHORT);
    }
}
