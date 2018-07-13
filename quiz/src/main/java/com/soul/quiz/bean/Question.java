package com.soul.quiz.bean;

/**
 *
 * Created by Soul on 2018/7/13.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswer;

    public Question(int mTextResId, boolean mAnswer) {
        this.mTextResId = mTextResId;
        this.mAnswer = mAnswer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
