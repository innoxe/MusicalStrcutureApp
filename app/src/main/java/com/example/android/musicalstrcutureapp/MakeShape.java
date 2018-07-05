package com.example.android.musicalstrcutureapp;

import android.graphics.drawable.GradientDrawable;

/**
 * Created by INNOCENZO on 30/03/2018.
 */

public class MakeShape {

    public MakeShape() {

    }

    public GradientDrawable rounded (int backgroundColor, int borderColor, int storke, int radius) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(backgroundColor);
        shape.setStroke(storke, borderColor);
        shape.setCornerRadius(radius);

        return shape;
    }
}
