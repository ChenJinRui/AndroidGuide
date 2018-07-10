package com.soul.androidguide.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soul.androidguide.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CusToDoTipBar extends FrameLayout implements CustomView{
    private static final String TAG = "Jarvis_CusToDoTipBar";
    private static final int SHOW_DURATION = 3000;
    private List<TextView> mAllTv = new ArrayList<TextView>();
    private int mCurrentIndex = 0;
    private List<String> mAllMsg = new ArrayList<>();
    private Handler mMainHandler;

    public CusToDoTipBar(@NonNull Context context) {
        this(context,null);
    }

    public CusToDoTipBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CusToDoTipBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContent();
    }

    private void initContent(){
        mMainHandler = new Handler();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.jarvis_style_todo_item_tipbar,this);
        mAllTv.add((TextView) findViewById(R.id.content_tip_txt1));
        mAllTv.add((TextView) findViewById(R.id.content_tip_txt2));
    }

    protected Animator createViewUpAni(final View v, int startValue, int endValue){
        ValueAnimator xAnimator =  null;
        xAnimator = ValueAnimator.ofInt(startValue,endValue);
        xAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                RelativeLayout.LayoutParams lpCur = (RelativeLayout.LayoutParams)v
                        .getLayoutParams();
                lpCur.topMargin = (Integer)animation.getAnimatedValue();
                v.setLayoutParams(lpCur);
            }
        });
        return xAnimator;
    }

    private void showNextMsgWithAni(){
        final TextView curTv = mAllTv.get(mCurrentIndex % mAllTv.size());
        mCurrentIndex = ++mCurrentIndex % mAllMsg.size();
        final TextView nextTv = mAllTv.get(mCurrentIndex % mAllTv.size());
        nextTv.setText(mAllMsg.get(mCurrentIndex));

        ArrayList<Animator> anis = new ArrayList<Animator>();

        anis.add(createViewUpAni(curTv,0,-getHeight()));
        anis.add(createViewUpAni(nextTv,getHeight(),0));

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(anis);
        animatorSet.setDuration(400);
        animatorSet.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                RelativeLayout.LayoutParams lpCur = (RelativeLayout.LayoutParams) curTv
                        .getLayoutParams();
                lpCur.topMargin = getHeight();
                curTv.setLayoutParams(lpCur);
                curTv.setText("");
                RelativeLayout.LayoutParams lpNext = (RelativeLayout.LayoutParams) nextTv
                        .getLayoutParams();
                lpNext.topMargin = 0;
                nextTv.setLayoutParams(lpNext);
                nextTv.setText(mAllMsg.get(mCurrentIndex));
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }
        });
        animatorSet.start();
        mMainHandler.removeCallbacks(recycleRunnable);
        mMainHandler.postDelayed(recycleRunnable, SHOW_DURATION);
    }

    static class RecycleRunnable implements Runnable {
        WeakReference<CusToDoTipBar> wTipBar = null;
        RecycleRunnable(CusToDoTipBar tipBar){
            wTipBar = new WeakReference<CusToDoTipBar>(tipBar);
        }

        @Override
        public void run() {
            CusToDoTipBar tipBar = wTipBar.get();
            if(tipBar == null){
                return;
            }
            tipBar.showNextMsgWithAni();
        }
    }
    Runnable recycleRunnable = new RecycleRunnable(this);

    private void startRecycleShowMsg(){
        if(mAllMsg == null || mAllMsg.size() == 0){
            return;
        }
        TextView curTv = mAllTv.get(mCurrentIndex % mAllTv.size());
        curTv.setText(mAllMsg.get(mCurrentIndex));
        if(mAllMsg.size() > 1){
            mMainHandler.removeCallbacks(recycleRunnable);
            mMainHandler.postDelayed(recycleRunnable, SHOW_DURATION);
        }
    }

    private void stopRecyclesShowMsg(){
        mMainHandler.removeCallbacks(recycleRunnable);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopRecyclesShowMsg();
    }

    @Override
    public void applyProperty(DynamicHelper helper, Map<DynamicProperty.NAME, DynamicProperty> properties) {
        DynamicProperty subData = properties.get(DynamicProperty.NAME.SUBDATA);
        FrameLayout group = new FrameLayout(getContext());
        CustomViewHelper.applySubLayout(helper,group,subData);

        for(int i = 0; i< group.getChildCount();i++){
            View subView = group.getChildAt(i);
            if(subView instanceof ViewGroup){
                View firstView = ((ViewGroup) subView).getChildAt(0);
                String txt = ((TextView) firstView).getText() +"";
                if(!TextUtils.isEmpty(txt)){
                    mAllMsg.add(txt);
                }
            }else if(subView instanceof TextView){
                String txt = ((TextView) subView).getText() +"";
                if(!TextUtils.isEmpty(txt)){
                    mAllMsg.add(txt);
                }
            }
        }

        startRecycleShowMsg();
    }

    public void applyStrings(List<String> datas){
        mAllMsg.addAll(datas);
        startRecycleShowMsg();
    }
}
