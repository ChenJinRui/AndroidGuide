package com.soul.quiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button btn_true;
    private Button btn_false;
    private TextView tv_question;
    private static Context mContext ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = MainActivity.this;
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        tv_question = findViewById(R.id.tv_question);
        btn_false = findViewById(R.id.btn_false);
        btn_true = findViewById(R.id.btn_true);
        initData();
        btn_false.setOnClickListener(this);
        btn_true.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_true:
                examines(true);
                break;
            case R.id.btn_false:
                examines(false);
                break;
            default:
                break;

        }
    }

    private void examines(boolean answer) {
        if(answer){
            showToast(R.string.toast_correct);
        }else{
            showToast(R.string.toast_error);
        }

    }
    private static Toast mToast;
    private TextView toast_content = null;
    private void showToast(int resId){

        if(mToast == null){
            mToast = new Toast(mContext);
            View toastView = View.inflate(mContext,R.layout.toast_layout,null);
            mToast.setGravity(Gravity.TOP,0,20);
            mToast.setView(toastView);
            mToast.setDuration(Toast.LENGTH_SHORT);
            toast_content = toastView.findViewById(R.id.tv_toast_content);
        }
        
        toast_content.setText(resId);
        mToast.show();
    }
    private void showToast(String resId){

        if(mToast == null){
            mToast = new Toast(mContext);
            View toastView = View.inflate(mContext,R.layout.toast_layout,null);
            mToast.setGravity(Gravity.TOP,0,20);
            mToast.setView(toastView);
            mToast.setDuration(Toast.LENGTH_SHORT);
            toast_content = toastView.findViewById(R.id.tv_toast_content);
        }

        toast_content.setText(resId);
        mToast.show();
    }
}
