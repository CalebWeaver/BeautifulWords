package com.bearlymade.beautifulwords;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/**
 * Created by cweaver on 3/16/2016.
 */
public class ActivationCircle extends ImageView {

    public ActivationCircle(Context context) {
        super(context);
        setBackground(context.getDrawable(R.drawable.activation_circle));
    }

    public void explode() {
        ObjectAnimator heightAnim = ObjectAnimator.ofFloat(this, "scaleY", 40);
        ObjectAnimator widthAnim = ObjectAnimator.ofFloat(this, "scaleX", 40);
        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(this, "alpha", 1f, 0f);

        AnimatorSet enlarge = new AnimatorSet();
        enlarge.play(heightAnim);
        enlarge.play(widthAnim);
        enlarge.play(fadeAnim);
        enlarge.setDuration(800);
        enlarge.setInterpolator(new DecelerateInterpolator());
        enlarge.addListener(animationListener);
        enlarge.start();
    }

    private void remove() {
        ViewGroup parent = (ViewGroup)getParent();
        parent.removeView(this);
    }

    private Animator.AnimatorListener animationListener = new Animator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            remove();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };
}
