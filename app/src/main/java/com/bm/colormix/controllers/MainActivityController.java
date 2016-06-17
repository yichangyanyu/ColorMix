package com.bm.colormix.controllers;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bm.colormix.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright © 2016 蓝色互动. All rights reserved.
 * 作者:杨杰 on 2016/6/17 09:50
 *
 * @Description: mainactivity控制器
 */
public class MainActivityController {

    private Context mContext;
    private TextView mtv_color;
    private ImageView miv_ok;
    private ProgressBar mPb_fenshu;

    private int beforeTextMessage;
    private int beforeColorMessage;

    private List<String> textMessage = new ArrayList<>();
    private List<Integer> colorMessage = new ArrayList<>();

    public MainActivityController(Context context, TextView tv_color, ImageView iv_ok, ProgressBar pb_fenshu) {
        mContext = context;
        mtv_color = tv_color;
        miv_ok = iv_ok;
        mPb_fenshu = pb_fenshu;
        initData();
    }

    private void initData() {
        textMessage.add("黄色");
        textMessage.add("红色");
        textMessage.add("黑色");
        textMessage.add("蓝色");
        colorMessage.add(mContext.getResources().getColor(R.color.yellow));
        colorMessage.add(mContext.getResources().getColor(R.color.red));
        colorMessage.add(mContext.getResources().getColor(R.color.black));
        colorMessage.add(mContext.getResources().getColor(R.color.blue));
        showTextMessgae();
    }

    public void setClickOk() {
        clickAction(0);
    }

    public void setClickErr() {
        clickAction(1);
    }

    private void clickAction(int type) {
        miv_ok.setVisibility(View.VISIBLE);
        tran();
        if (type == 0) {
            if (beforeTextMessage == beforeColorMessage) {
                mPb_fenshu.setProgress(mPb_fenshu.getProgress() + 1);
            }
        } else if (type == 1) {
            if (beforeTextMessage != beforeColorMessage) {
                mPb_fenshu.setProgress(mPb_fenshu.getProgress() + 1);
            }
        }
        showTextMessgae();
    }

    private void showTextMessgae() {
        Random rand = new Random();
        int textRand = rand.nextInt(4);
        int colorRand = rand.nextInt(4);
        beforeTextMessage = textRand;
        beforeColorMessage = colorRand;
        mtv_color.setText(textMessage.get(textRand));
        mtv_color.setTextColor(colorMessage.get(colorRand));
    }

    private void tran() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Random rand = new Random();
                int textRand = rand.nextInt(100);
                TranslateAnimation translateAnimation;
                if (textRand % 2 == 0) {
                    translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -5, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                } else {
                    translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 5, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                }
                translateAnimation.setDuration(150);
                translateAnimation.setFillAfter(true);
                miv_ok.startAnimation(translateAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        miv_ok.startAnimation(scaleAnimation);
    }
}
