package com.abhishek.minito;

import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;

import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

public class AppUtils {


    @JvmStatic
    @BindingAdapter("android:onLayoutChange")
    public static void setOnLayoutChangeListener(View view, View.OnLayoutChangeListener oldValue,
                                                 View.OnLayoutChangeListener newValue) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (oldValue != null) {
                view.removeOnLayoutChangeListener(oldValue);
            }
            if (newValue != null) {
                view.addOnLayoutChangeListener(newValue);
            }
        }
    }


    @JvmStatic
    @BindingAdapter("onSearchInSoftKeyboard") // I like it to match the listener method name
    public static void setOnSearchInSoftKeyboardListener(TextView view, BindinAdapterCallback callback) {

        if (callback == null) {
            view.setOnEditorActionListener(null);
        } else {
            view.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i == EditorInfo.IME_ACTION_SEARCH) {
                        if (TextUtils.isEmpty(textView.getText().toString())) {
                            textView.setError("Cannot be empty");

                            return false;
                        }
                        callback.onEditorAction();
                        return true;
                    }
                    return false;
                }
            });
        }

    }


}
