package com.hiteshsahu.material_resume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    View baseLayout;
//    ImageButton twitter;
//    LinearLayout revealView, layoutButtons;
//    Animation alphaAnimation;
//    float pixelDensity;
//    boolean flag = true;
//    private ImageButton linkedin;
//    private LinearLayout linkedinRevealView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* pixelDensity = getResources().getDisplayMetrics().density;

        baseLayout = (View) findViewById(R.id.imageView);
        twitter = (ImageButton) findViewById(R.id.twitter);
        linkedin = (ImageButton) findViewById(R.id.linkedin);
        revealView = (LinearLayout) findViewById(R.id.linearView);
        linkedinRevealView = (LinearLayout) findViewById(R.id.linkedin_reveal);
        layoutButtons = (LinearLayout) findViewById(R.id.layoutButtons);

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
    }

 /*   public void launchTwitter(View view) {

        *//*
         MARGIN_RIGHT = 16;
         FAB_BUTTON_RADIUS = 28;
         *//*
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


    public void launchLinkedin(View view) {

        *//*
         MARGIN_RIGHT = 16;
         FAB_BUTTON_RADIUS = 28;
         *//*
        int x = baseLayout.getLeft();
        int y = baseLayout.getBottom();
        x += ((28 * pixelDensity) + (16 * pixelDensity));
        y -= ((28 * pixelDensity) + (16 * pixelDensity));

        int hypotenuse = (int) Math.hypot(baseLayout.getWidth(), baseLayout.getHeight());

        if (flag) {

            linkedin.setBackgroundResource(R.drawable.rounded_cancel_button);
            linkedin.setImageResource(R.mipmap.image_cancel);

            FrameLayout.LayoutParams parameters = (FrameLayout.LayoutParams)
                    linkedinRevealView.getLayoutParams();
            parameters.height = baseLayout.getHeight();
            linkedinRevealView.setLayoutParams(parameters);

            Animator anim = ViewAnimationUtils.createCircularReveal(linkedinRevealView, x, y, 0, hypotenuse);
            anim.setDuration(700);

            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
//                    layoutButtons.setVisibility(View.VISIBLE);
//                    layoutButtons.startAnimation(alphaAnimation);
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

            linkedin.setBackgroundResource(R.drawable.linkedin_button);
            linkedin.setImageResource(R.mipmap.linkedin);

            Animator anim = ViewAnimationUtils.createCircularReveal(linkedinRevealView, x, y, hypotenuse, 0);
            anim.setDuration(400);

            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    linkedinRevealView.setVisibility(View.GONE);
//                    layoutButtons.setVisibility(View.GONE);
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
    }*/

    }
}