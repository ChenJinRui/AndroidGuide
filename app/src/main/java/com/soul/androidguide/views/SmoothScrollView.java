package com.soul.androidguide.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

public class SmoothScrollView extends ScrollView {
    private static final String TAG = "Jarvis_SmoothScrollView";
    private int winW;
    private int winH;

    public SmoothScrollView(Context context) {
        this(context,null);
    }

    public SmoothScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SmoothScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContent();
    }

    private void initContent(){
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        winW = metrics.widthPixels;
        winH = metrics.heightPixels;
    }


    @Override
    public void scrollTo(int x, int y) {
    }

    private void smoothToDestView(View child){
        int[] preLocation = new int[2];
        child.getLocationOnScreen(preLocation);

        int height = child.getHeight();

        int midH = getHeight() / 2;
        int destY = midH - height / 2;

        int dx = 0;
        int dy = preLocation[1] - destY ;
        Log.i(TAG, "smooth scroll dy:" + dy + " child:" + child + " height:" + getHeight());

        smoothScrollBy(dx, dy);
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int code = event.getKeyCode();
        if(action == KeyEvent.ACTION_DOWN){

            View nextView = null;
            if(code == KeyEvent.KEYCODE_DPAD_DOWN){
                View focusView = findFocus();
                if(focusView == null){
                    return true;
                }
                nextView = focusView.focusSearch(View.FOCUS_DOWN);
            }else if(code == KeyEvent.KEYCODE_DPAD_UP){
                View focusView = findFocus();
                if(focusView == null){
                    return true;
                }
                nextView = focusView.focusSearch(View.FOCUS_UP);
            }else if(code == KeyEvent.KEYCODE_DPAD_LEFT){
                View focusView = findFocus();
                if(focusView == null){
                    return true;
                }
                nextView = focusView.focusSearch(View.FOCUS_LEFT);
            }else if(code == KeyEvent.KEYCODE_DPAD_RIGHT){
                View focusView = findFocus();
                if(focusView == null){
                    return true;
                }
                nextView = focusView.focusSearch(View.FOCUS_RIGHT);
            }else{
                View focusView = findFocus();
                if(focusView != null){
                    focusView.setClickable(true);
                    focusView.dispatchKeyEvent(event);
                    return true;
                }
                Log.i(TAG,"focus view:" + focusView + "  clickEnable:" + focusView.isClickable());

                return super.dispatchKeyEvent(event);
            }
            if(nextView == null){
                return super.dispatchKeyEvent(event);
            }
            smoothToDestView(nextView);
            nextView.requestFocus();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

}
