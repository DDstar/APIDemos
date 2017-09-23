package com.android.deskclock;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.NumberPicker;

import java.lang.reflect.Field;

/**
 * Subclass of NumberPicker that allows customizing divider color.
 */
public class NumberPickerCompat extends NumberPicker {

    private static Field sSelectionDivider;
    private static boolean sTrySelectionDivider = true;

    public NumberPickerCompat(Context context) {
        this(context, null /* attrs */);
    }

    public NumberPickerCompat(Context context, AttributeSet attrs) {
        super(context, attrs);
        tintSelectionDivider(context);
    }

    public NumberPickerCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        tintSelectionDivider(context);
    }

    private void tintSelectionDivider(Context context) {
        if (sTrySelectionDivider) {
            try {
                if (sSelectionDivider == null) {
                    sSelectionDivider = NumberPicker.class.getDeclaredField("mSelectionDivider");
                    sSelectionDivider.setAccessible(true);
                }
                final Drawable selectionDivider = (Drawable) sSelectionDivider.get(this);
                if (selectionDivider != null) {
                    // setTint is API21+, but this will only be called in API21
                    selectionDivider.setTint(Color.parseColor("#4bd1c3"));
                }
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
                LogUtils.e("Unable to set selection divider", e);
                sTrySelectionDivider = false;
            }
        }
    }

}
