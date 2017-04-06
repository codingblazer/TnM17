package com.example.sachinaggarwal.tnm17;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class SplashActivity extends AppCompatActivity {
    public static final int STARTUP_DELAY = 300;
    public static final int ANIM_ITEM_DURATION = 1000;
    public static final int ITEM_DELAY = 300;

    private boolean animationStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        if (!hasFocus || animationStarted) {
            return;
        }

        animate();

        super.onWindowFocusChanged(hasFocus);
    }

    private void animate() {
        animationStarted = true;
        ImageView logoImageView = (ImageView) findViewById(R.id.img_logo);
        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        final HTextView textView = (HTextView) findViewById(R.id.text);

        ViewCompat.animate(logoImageView)
                .translationY(+250)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ANIM_ITEM_DURATION).setInterpolator(
                new DecelerateInterpolator(1.2f)).start();

        Display display = getWindowManager().getDefaultDisplay();
        int height = display.getHeight();

        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            ViewPropertyAnimatorCompat viewAnimator;

                viewAnimator = ViewCompat.animate(v)
                        .translationY(-height/(2.8f)).alpha(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(500);
            viewAnimator.setInterpolator(new DecelerateInterpolator()).start();
        }
        ViewCompat.animate(logoImageView)
                .scaleXBy(-0.2f)
                .scaleYBy(-0.2f)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ANIM_ITEM_DURATION).setInterpolator(new DecelerateInterpolator(1.2f))
                .start();
        final Handler wait1 = new Handler();
        wait1.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setAnimateType(HTextViewType.ANVIL);
                textView.animateText("TnM 17");
            }
        }, 1200);
        final Handler wait = new Handler();
        wait.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setAnimateType(HTextViewType.SPARKLE);
                textView.animateText(Html.fromHtml("6th - 8th April, 2017"));
            }
        }, 3000);
        final Handler wait3 = new Handler();
        wait3.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,Home.class));
            }
        }, 6000);
    }
}
