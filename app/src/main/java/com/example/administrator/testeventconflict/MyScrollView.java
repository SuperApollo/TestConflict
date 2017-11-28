package com.example.administrator.testeventconflict;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017/11/27.
 */

public class MyScrollView extends ScrollView {
    Context mContext;

    private final String TAG = MyScrollView.class.getSimpleName();
    private float distance;
    private float speed;
    private int mPointerId;
    private VelocityTracker mVelocityTracker;

    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        acquireVelocityTracker(ev);
        final VelocityTracker verTracker = mVelocityTracker;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //触点第一个id
                mPointerId = ev.getPointerId(0);
                break;

            case MotionEvent.ACTION_MOVE:
                //求伪瞬时速度
//                verTracker.computeCurrentVelocity(1000, mMaxVelocity);
                verTracker.computeCurrentVelocity(1, (float) 10);//设置maxVelocity值为0.1时，速率大于0.01时，显示的速率都是0.01,速率小于0.01时，显示正常
                final float velocityX = verTracker.getXVelocity(mPointerId);
                final float velocityY = verTracker.getYVelocity(mPointerId);
                Log.d(TAG, "x速度：" + velocityX);
                Log.d(TAG, "y速度：" + velocityY);
                if (Math.abs(velocityY) > 4.5f) {
                    return true;
                }

            case MotionEvent.ACTION_UP:
                releaseVelocityTracker();
                break;
            case MotionEvent.ACTION_CANCEL:
                releaseVelocityTracker();
                break;
            default:
                break;

        }

        return super.onInterceptTouchEvent(ev);
    }

    /**
     * @param event 向VelocityTracker添加MotionEvent
     * @see android.view.VelocityTracker#obtain()
     * @see android.view.VelocityTracker#addMovement(MotionEvent)
     */
    private void acquireVelocityTracker(final MotionEvent event) {
        if (null == mVelocityTracker) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);
    }

    /**
     * 释放VelocityTracker
     *
     * @see android.view.VelocityTracker#clear()
     * @see android.view.VelocityTracker#recycle()
     */
    private void releaseVelocityTracker() {
        if (null != mVelocityTracker) {
            mVelocityTracker.clear();
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
