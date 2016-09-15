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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hiteshsahu.materialvcard.R;

/**
 * Created by Hitesh on 15-09-2016.
 */
public class VCardLayout extends CoordinatorLayout {

    private static final int RIGHT_MARGIN_FAB = 16;
    private static final int BASE_LAYOUT_MARGIN = 30;
    private static final int FAB_SIZE = 56;
    private static final int FAB_RADIUS = 28;
    private final LayoutInflater mInflater;
    private View rootView, baseView, revealView, revealViewContent;
    private ImageButton twitterButton;
    private Animation alphaAnimation;
    private float pixelDensity;
    private ImageButton linkedinButton, githubButton, dribbleButton, behanceButton, closeButton;
    private ImageView slides;

    private ColorGenerator mColorGenerator = ColorGenerator.MATERIAL;
    private TextDrawable.IBuilder mDrawableBuilder;
    private TextDrawable drawable;


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

        //Social Media Buttons
        twitterButton = (ImageButton) rootView.findViewById(R.id.twitter);
        linkedinButton = (ImageButton) rootView.findViewById(R.id.linkedin);
        dribbleButton = (ImageButton) rootView.findViewById(R.id.dribble);
        githubButton = (ImageButton) rootView.findViewById(R.id.github);
        behanceButton = (ImageButton) rootView.findViewById(R.id.behance);
        closeButton = (ImageButton) rootView.findViewById(R.id.close);

        //Slides
        slides = (ImageView) rootView.findViewById(R.id.demo_slide);

        mDrawableBuilder = TextDrawable.builder().beginConfig().withBorder(4)
                .endConfig().roundRect(10);

        drawable = mDrawableBuilder.build(String.valueOf("Hello".charAt(0)), mColorGenerator
                .getColor("Hello"));

        //Views to animate
        baseView = rootView.findViewById(R.id.baseview);
        revealView = rootView.findViewById(R.id.reveal_view_root);
        revealViewContent = rootView.findViewById(R.id.reveal_view_content);
        alphaAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_anim);

        closeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                int cx = closeButton.getLeft();
                int cy = closeButton.getBottom();

                int hypotenuse = (int) Math.hypot(baseView.getWidth(), baseView.getHeight());

                Animator anim = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, hypotenuse, 0);
                anim.setDuration(400);

                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        revealView.setVisibility(View.GONE);
                        revealViewContent.setVisibility(View.GONE);
                        // slides.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left));
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

                anim.start();

            }
        });

        twitterButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                revealView.setBackgroundResource(R.color.twitter);

                ((TextView) rootView.findViewById(R.id.demo_heading)).setText("Hello Twitter");

                Glide.with(getContext()).load("https://s-media-cache-ak0.pinimg.com/564x/52/3f/f0/523ff005d81196928769eaec7b850081.jpg").placeholder(R.drawable.demo).error(drawable).crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL).into(slides);

                int cx = baseView.getLeft();
                int cy = baseView.getBottom();
                cx += ((FAB_RADIUS * pixelDensity) +
                        (RIGHT_MARGIN_FAB + BASE_LAYOUT_MARGIN) * pixelDensity);

                cy -= ((FAB_RADIUS * pixelDensity) +
                        ((RIGHT_MARGIN_FAB + BASE_LAYOUT_MARGIN) * pixelDensity));

                int hypotenuse = (int) Math.hypot(baseView.getWidth(), baseView.getHeight());

                doCircularReveal(cx, cy, hypotenuse);

            }
        });


        linkedinButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Glide.with(getContext()).load("https://s-media-cache-ak0.pinimg.com/originals/2d/6a/91/2d6a91a9eada0f581e6f452ce6b2d99b.gif").placeholder(R.drawable.demo).error(drawable).crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL).into(slides);

                ((TextView) rootView.findViewById(R.id.demo_heading)).setText("Hello Linkedin");

                revealView.setBackgroundResource(R.color.linkedin);

                int cx = baseView.getLeft();
                int cy = baseView.getBottom();
                cx += ((FAB_RADIUS * pixelDensity) +
                        ((RIGHT_MARGIN_FAB + BASE_LAYOUT_MARGIN + FAB_SIZE) * pixelDensity));

                cy -= ((FAB_RADIUS * pixelDensity) + ((RIGHT_MARGIN_FAB + BASE_LAYOUT_MARGIN) * pixelDensity));

                int hypotenuse = (int) Math.hypot(baseView.getWidth(), baseView.getHeight());

                doCircularReveal(cx, cy, hypotenuse);

            }
        });

        githubButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                ((TextView) rootView.findViewById(R.id.demo_heading)).setText("Hello GitHub");

                Glide.with(getContext()).load("https://s-media-cache-ak0.pinimg.com/originals/62/62/75/62627517bf3e0b1d5e35862a36ed7ac8.gif").placeholder(R.drawable.demo).error(drawable).crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL).into(slides);


                revealView.setBackgroundResource(R.color.github);

                int cx = baseView.getLeft();
                int cy = baseView.getBottom();
                cx += ((FAB_RADIUS * pixelDensity) +
                        ((BASE_LAYOUT_MARGIN + RIGHT_MARGIN_FAB +
                                FAB_SIZE + FAB_SIZE + RIGHT_MARGIN_FAB) * pixelDensity));

                cy -= ((FAB_RADIUS * pixelDensity) + ((RIGHT_MARGIN_FAB + BASE_LAYOUT_MARGIN) * pixelDensity));

                int hypotenuse = (int) Math.hypot(baseView.getWidth(), baseView.getHeight());

                doCircularReveal(cx, cy, hypotenuse);
            }
        });


        dribbleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ((TextView) rootView.findViewById(R.id.demo_heading)).setText("Hello Dribble");

                Glide.with(getContext()).load("https://s-media-cache-ak0.pinimg.com/originals/d0/76/2d/d0762d3fb1fbb492b5a41eb222d1ce30.gif").placeholder(R.drawable.demo).error(drawable).crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL).into(slides);

                revealView.setBackgroundResource(R.color.dribble);

                int cx = baseView.getLeft();
                int cy = baseView.getBottom();
                cx += ((FAB_RADIUS * pixelDensity) + ((BASE_LAYOUT_MARGIN + RIGHT_MARGIN_FAB + FAB_SIZE + FAB_SIZE + RIGHT_MARGIN_FAB + FAB_SIZE + RIGHT_MARGIN_FAB) * pixelDensity));
                cy -= ((FAB_RADIUS * pixelDensity) + ((RIGHT_MARGIN_FAB + BASE_LAYOUT_MARGIN) * pixelDensity));

                int hypotenuse = (int) Math.hypot(baseView.getWidth(), baseView.getHeight());

                doCircularReveal(cx, cy, hypotenuse);

            }
        });

        behanceButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ((TextView) rootView.findViewById(R.id.demo_heading)).setText("Hello Behance");

                Glide.with(getContext()).load("https://s-media-cache-ak0.pinimg.com/originals/e7/b3/dd/e7b3dd54525dc1efb1c687678ceb92b7.gif").placeholder(R.drawable.demo).error(drawable).crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL).into(slides);

                revealView.setBackgroundResource(R.color.behance);

                int cx = baseView.getLeft();
                int cy = baseView.getBottom();
                cx += ((FAB_RADIUS * pixelDensity) + ((BASE_LAYOUT_MARGIN + RIGHT_MARGIN_FAB + FAB_SIZE + FAB_SIZE + RIGHT_MARGIN_FAB + FAB_SIZE + RIGHT_MARGIN_FAB + FAB_SIZE + RIGHT_MARGIN_FAB) * pixelDensity));
                cy -= ((FAB_RADIUS * pixelDensity) + ((RIGHT_MARGIN_FAB + BASE_LAYOUT_MARGIN) * pixelDensity));

                int hypotenuse = (int) Math.hypot(baseView.getWidth(), baseView.getHeight());

                doCircularReveal(cx, cy, hypotenuse);

            }
        });
    }

    private void doCircularReveal(int cx, int cy, int hypotenuse) {

        revealViewContent.setVisibility(View.GONE);

        FrameLayout.LayoutParams parameters = (FrameLayout.LayoutParams)
                revealView.getLayoutParams();
        parameters.height = baseView.getHeight();
        revealView.setLayoutParams(parameters);

        Animator anim = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, 0, hypotenuse);
        anim.setDuration(700);

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                revealViewContent.setVisibility(View.VISIBLE);
                revealViewContent.startAnimation(alphaAnimation);
                slides.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left));
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
    }
}
