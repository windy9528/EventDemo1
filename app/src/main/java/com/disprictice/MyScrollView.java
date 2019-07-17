package com.disprictice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * date:2019/7/17
 * name:windy
 * function:
 */
public class MyScrollView extends ScrollView {

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    boolean intercept = false; //是否拦截的变量
    private ListView mListView;
    private float mLastY; // 记录y轴坐标

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        getChildListView();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                super.onInterceptTouchEvent(ev);
                intercept = false;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                //满足listview滑动到顶部，如果继续下滑，那就让scrollview进行拦截
                float y = ev.getY() - mLastY;
                if (mListView.getFirstVisiblePosition() == 0 && y > 0) {
                    intercept = true;
                } else if (mListView.getLastVisiblePosition() == mListView.getCount() - 1 && y < 0) {
                    intercept = true;
                } else {
                    intercept = false;
                }
                break;
            case MotionEvent.ACTION_HOVER_MOVE:
                intercept = false;
                break;
        }
        mLastY = ev.getY();
        return intercept;
    }

    /**
     * 子listview布局
     */
    private void getChildListView() {
        LinearLayout layout = (LinearLayout) getChildAt(0);

        mListView = (ListView) layout.getChildAt(1);

    }
}
