package com.bm.colormix.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bm.colormix.R;
import com.bm.colormix.controllers.MainActivityController;

/**
 * Copyright © 2016 蓝色互动. All rights reserved.
 *
 * @author yangjie
 *         create at 2016/6/17
 * @Description 颜色混淆
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_color;
    private ImageView iv_ok;
    private TextView tv_error;
    private TextView tv_ok;
    private MainActivityController mMainActivityController;
    private ProgressBar mPb_fenshu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mMainActivityController = new MainActivityController(getApplicationContext(), tv_color, iv_ok, mPb_fenshu);
    }

    private void initView() {
        mPb_fenshu = (ProgressBar) findViewById(R.id.pb_fenshu);
        tv_color = (TextView) findViewById(R.id.tv_color);
        iv_ok = (ImageView) findViewById(R.id.iv_ok);
        tv_error = (TextView) findViewById(R.id.tv_error);
        tv_ok = (TextView) findViewById(R.id.tv_ok);
        tv_error.setOnClickListener(this);
        tv_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_error:
                mMainActivityController.setClickErr();
                break;
            case R.id.tv_ok:
                mMainActivityController.setClickOk();
                break;
        }
    }
}
