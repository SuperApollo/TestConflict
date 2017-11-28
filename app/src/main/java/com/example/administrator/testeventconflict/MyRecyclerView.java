package com.example.administrator.testeventconflict;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by Administrator on 2017/11/27.
 */

public class MyRecyclerView extends RecyclerView {
    private final String TAG = MyRecyclerView.class.getSimpleName();
    private boolean isTop;
    private boolean isBottom;
    private boolean isUp;//列表向上滚动

    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        if (!canScrollVertically(-1)) {
            Log.d(TAG, "顶部");
            isTop = true;
            MyApplication.getMyApplication().setTop(true);
        } else {
            isTop = false;
            MyApplication.getMyApplication().setTop(false);
        }

        if (!canScrollVertically(1)) {
            isBottom = true;
            MyApplication.getMyApplication().setBottom(true);
        } else {
            isBottom = false;
            MyApplication.getMyApplication().setBottom(false);
        }

        if (dy > 0) {
            isUp = true;
        } else {
            isUp = false;
        }
//        Log.d(TAG, "isUp:" + isUp);

    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        int action = ev.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                downX = ev.getRawX();
//                downY = ev.getRawY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int moveY = (int) ev.getRawY();
//                if (moveY - downY > 0) {//下滑
//                    Log.d(TAG, "下滑");
//                    return false;
//                } else {//上滑
//                    Log.d(TAG, "上滑");
//                }
//            default:
//                break;
//
//        }
//        return super.dispatchTouchEvent(ev);
//    }


}
