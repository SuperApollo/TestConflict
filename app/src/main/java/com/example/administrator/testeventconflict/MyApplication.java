package com.example.administrator.testeventconflict;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/11/27.
 */

public class MyApplication extends Application {
    Context context;
    static MyApplication myApplication;
    boolean isTop;
    boolean isBottom;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        myApplication = this;
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public Context getContext() {
        return context;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public boolean isBottom() {
        return isBottom;
    }

    public void setBottom(boolean bottom) {
        isBottom = bottom;
    }
}
