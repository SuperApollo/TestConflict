package com.example.administrator.testeventconflict;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/11/27.
 */

public class MyLinerLayout extends LinearLayout {
    public MyLinerLayout(Context context) {
        super(context);
    }

    public MyLinerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (MyApplication.getMyApplication().isRecyclerFoucus()) {
//            return true;
//        } else {
//            return super.onInterceptTouchEvent(ev);
//        }
//
//    }
}
