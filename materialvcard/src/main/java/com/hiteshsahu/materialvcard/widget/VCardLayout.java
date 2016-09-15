package com.hiteshsahu.materialvcard.widget;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.hiteshsahu.materialvcard.R;

/**
 * Created by Hitesh on 15-09-2016.
 */
public class VCardLayout extends CoordinatorLayout {

    private final LayoutInflater mInflater;
    View baseLayout;
    ImageButton twitter;
    LinearLayout revealView, layoutButtons;
    Animation alphaAnimation;
    float pixelDensity;
    boolean flag = true;
    private View rootView;
    private ImageButton linkedin;
    private LinearLayout linkedinRevealView;

    public VCardLayout(Context context) {
        super(context);

        pixelDensity = context.getResources().getDisplayMetrics().density;
        mInflater = LayoutInflater.from(context);
        init();
    }

    public VCardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        pixelDensity = context.getResources().getDisplayMetrics().density;

        mInflater = LayoutInflater.from(context);
        init();
    }

    public VCardLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        pixelDensity = context.getResources().getDisplayMetrics().density;

        mInflater = LayoutInflater.from(context);
        init();
    }

    protected void init() {
        rootView = mInflater.inflate(R.layout.vcard_layout, this, true);

        baseLayout = rootView.findViewById(R.id.baseview);
        twitter = (ImageButton) rootView.findViewById(R.id.twitter);
        linkedin = (ImageButton) rootView.findViewById(R.id.linkedin);
        revealView = (LinearLayout) rootView.findViewById(R.id.linearView);
        linkedinRevealView = (LinearLayout) rootView.findViewById(R.id.linkedin_reveal);
        layoutButtons = (LinearLayout) rootView.findViewById(R.id.layoutButtons);
        alphaAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_anim);


        twitter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

        /*
         MARGIN_RIGHT = 16;
         FAB_BUTTON_RADIUS = 28;
         */
                int x = baseLayout.getLeft();
                int y = baseLayout.getBottom();
                x += ((28 * pixelDensity) + (16 * pixelDensity));
                y -= ((28 * pixelDensity) + (16 * pixelDensity));

                int hypotenuse = (int) Math.hypot(baseLayout.getWidth(), baseLayout.getHeight());

                if (flag) {

                    twitter.setBackgroundResource(R.drawable.rounded_cancel_button);
                    twitter.setImageResource(R.mipmap.image_cancel);

                    FrameLayout.LayoutParams parameters = (FrameLayout.LayoutParams)
                            revealView.getLayoutParams();
                    parameters.height = baseLayout.getHeight();
                    revealView.setLayoutParams(parameters);

                    Animator anim = ViewAnimationUtils.createCircularReveal(revealView, x, y, 0, hypotenuse);
                    anim.setDuration(700);

                    anim.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            layoutButtons.setVisibility(View.VISIBLE);
                            layoutButtons.startAnimation(alphaAnimation);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });

                    revealView.setVisibility(View.VISIBLE);
                    anim.start();

                    flag = false;
                } else {

                    twitter.setBackgroundResource(R.drawable.twitter_button);
                    twitter.setImageResource(R.mipmap.twitter_logo);

                    Animator anim = ViewAnimationUtils.createCircularReveal(revealView, x, y, hypotenuse, 0);
                    anim.setDuration(400);

                    anim.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            revealView.setVisibility(View.GONE);
                            layoutButtons.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });

                    anim.start();
                    flag = true;
                }
            }
        });

    }
//
//    public void launchTwitter(View view) {
//
//    }
//
//
//    public void launchLinkedin(View view) {
//
//        /*
//         MARGIN_RIGHT = 16;
//         FAB_BUTTON_RADIUS = 28;
//         */
//        int x = baseLayout.getLeft();
//        int y = baseLayout.getBottom();
//        x += ((28 * pixelDensity) + (16 * pixelDensity));
//        y -= ((28 * pixelDensity) + (16 * pixelDensity));
//
//        int hypotenuse = (int) Math.hypot(baseLayout.getWidth(), baseLayout.getHeight());
//
//        if (flag) {
//
//            linkedin.setBackgroundResource(R.drawable.rounded_cancel_button);
//            linkedin.setImageResource(R.mipmap.image_cancel);
//
//            FrameLayout.LayoutParams parameters = (FrameLayout.LayoutParams)
//                    linkedinRevealView.getLayoutParams();
//            parameters.height = baseLayout.getHeight();
//            linkedinRevealView.setLayoutParams(parameters);
//
//            Animator anim = ViewAnimationUtils.createCircularReveal(linkedinRevealView, x, y, 0, hypotenuse);
//            anim.setDuration(700);
//
//            anim.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animator) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animator) {
////                    layoutButtons.setVisibility(View.VISIBLE);
////                    layoutButtons.startAnimation(alphaAnimation);
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animator) {
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator animator) {
//
//                }
//            });
//
//            revealView.setVisibility(View.VISIBLE);
//            anim.start();
//
//            flag = false;
//        } else {
//
//            linkedin.setBackgroundResource(R.drawable.linkedin_button);
//            linkedin.setImageResource(R.mipmap.linkedin);
//
//            Animator anim = ViewAnimationUtils.createCircularReveal(linkedinRevealView, x, y, hypotenuse, 0);
//            anim.setDuration(400);
//
//            anim.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animator) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animator) {
//                    linkedinRevealView.setVisibility(View.GONE);
////                    layoutButtons.setVisibility(View.GONE);
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animator) {
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator animator) {
//
//                }
//            });
//
//            anim.start();
//            flag = true;
//        }
//    }

}
