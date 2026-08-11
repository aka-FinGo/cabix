package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class IconHelper {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCompatRippleBackgroundIfNeeded(CheckableImageButton checkableImageButton) {
    }

    private IconHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIconOnClickListener(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIconOnLongClickListener(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = hasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        if (Build.VERSION.SDK_INT >= 26 || !z2 || z) {
            checkableImageButton.setLongClickable(z);
        }
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyIconTint(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (colorStateList != null && colorStateList.isStateful()) {
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(mergeIconState(textInputLayout, checkableImageButton), colorStateList.getDefaultColor())));
            } else {
                drawable.setTintList(colorStateList);
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void refreshIconDrawableState(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(mergeIconState(textInputLayout, checkableImageButton), colorStateList.getDefaultColor());
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        mutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    private static int[] mergeIconState(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton) {
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIconMinSize(CheckableImageButton checkableImageButton, int i) {
        checkableImageButton.setMinimumWidth(i);
        checkableImageButton.setMinimumHeight(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIconScaleType(CheckableImageButton checkableImageButton, ImageView.ScaleType scaleType) {
        checkableImageButton.setScaleType(scaleType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImageView.ScaleType convertScaleType(int i) {
        if (i == 0) {
            return ImageView.ScaleType.FIT_XY;
        }
        if (i == 1) {
            return ImageView.ScaleType.FIT_START;
        }
        if (i == 2) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (i == 3) {
            return ImageView.ScaleType.FIT_END;
        }
        if (i == 5) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if (i == 6) {
            return ImageView.ScaleType.CENTER_INSIDE;
        }
        return ImageView.ScaleType.CENTER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateIconTooltip(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener, CharSequence charSequence) {
        if (!checkableImageButton.isFocusable()) {
            charSequence = null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            checkableImageButton.setTooltipText(charSequence);
        } else if (onLongClickListener == null) {
            TooltipCompat.setTooltipText(checkableImageButton, charSequence);
        }
    }
}
