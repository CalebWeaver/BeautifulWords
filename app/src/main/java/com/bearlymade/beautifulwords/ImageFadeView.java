package com.bearlymade.beautifulwords;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by cweaver on 3/17/2016.
 */
public class ImageFadeView extends ImageView {

    Context context;
    int nextImageId;
    ObjectAnimator fadeIn;

    public ImageFadeView(Context context) {
        super(context);
        this.context = context;
    }

    public ImageFadeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void switchImage(int resId) {
        nextImageId = resId;
        fadeIn = ObjectAnimator.ofFloat(this, "alpha", 0f, .5f);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(this, "alpha", .5f, 0f);
        fadeOut.setDuration(200);
        fadeOut.addListener(animationListener);
        fadeOut.start();
    }

    private Animator.AnimatorListener animationListener = new Animator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            setImageDrawable(context.getDrawable(nextImageId));
            fadeIn.setDuration(200);
            fadeIn.start();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };
}
