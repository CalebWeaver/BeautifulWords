package com.bearlymade.beautifulwords;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by cweaver on 3/17/2016.
 */
public class Utility {

    Context context;

    public Utility(Context context) {
        this.context = context;
    }

    public float dpTopx(float dp) {
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return px;
    }
}
