package com.soul.androidguide.views;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soul.androidguide.MainActivity;
import com.soul.androidguide.R;

import java.util.Map;



public class InfoGrailItem extends RelativeLayout {
    private ImageView img_content,img_focus;
    private TextView tv_sum,tv_hint,tv_phone ;
    private String pkgName,className;
    private Map<String ,String> params ;
    private String sumString ;
    private int background ;
    private Context mContext ;

    public InfoGrailItem(@NonNull Context context,
                         int backgroundId,String pkgName,String className,String sumString ) {
        super(context, null, 0);
        mContext = context ;
        background = backgroundId;
        this.pkgName = pkgName;
        this.className = className;
        this.sumString = sumString;
        initView();
    }
    public InfoGrailItem(@NonNull Context context) {
        this(context,null);
    }

    public InfoGrailItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public InfoGrailItem(@NonNull Context context,
                         @Nullable AttributeSet attrs,
                         int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context ;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.InfoGrailItem);
        background = a.getResourceId(R.styleable.InfoGrailItem_img_background,R.drawable.jarvis_fullguide_bg);
        pkgName = a.getString(R.styleable.InfoGrailItem_pkgName);
        className = a.getString(R.styleable.InfoGrailItem_className);
        sumString= a.getString(R.styleable.InfoGrailItem_tv_sum);
        a.recycle();
        initView();
    }

    private void initView(){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.jarvis_infograil_type1,this);
        img_content = (ImageView)findViewById(R.id.img_content);
        tv_sum = (TextView) findViewById(R.id.tv_sum);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_hint = (TextView) findViewById(R.id.tv_hint);
        img_focus = (ImageView)findViewById(R.id.img_focus);

        img_content.setImageResource(background);
        if (sumString.equals("0")){
            tv_sum.setVisibility(INVISIBLE);
        }else {
            tv_sum.setVisibility(VISIBLE);
        }
        tv_sum.setText(sumString);

        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    setScaleX(1.05f);
                    setScaleY(1.05f);
                    img_focus.setVisibility(VISIBLE);
                }else{
                    setScaleX(1.0f);
                    setScaleY(1.0f);
                    img_focus.setVisibility(INVISIBLE);
                }
            }
        });

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                if (pkgName == null || pkgName.equals("")){
                    return;
                }
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(pkgName,className);
                intent.setComponent(componentName);
                if (params!= null){
                    for(Object obj : params.entrySet()) {
                        Map.Entry entry = (Map.Entry) obj;
                        intent.putExtra((String) entry.getKey(),(String) entry.getValue());
                        System.out.println(entry.getKey() + "=" + entry.getValue());
                    }
                }
                Intent mIntent = new Intent(mContext,MainActivity.class);
                mContext.startActivity(mIntent);
//                mContext.startActivity(intent);
            }
        });

    }

    public void setParams(Map<String ,String> params){
        this.params = params ;
    }
    public void setTextType(int type,@Nullable String hint,@Nullable String hint2){

        switch (type){
            case 0://sign
                tv_hint.setVisibility(VISIBLE);

                tv_hint.setText( Html.fromHtml("<big>第" + hint +"天签到</big><br/>" +
                        "您有<font color='#FF0000'>"+hint2+ "</font>币待领取"));
                break;
            case 1://sign
                tv_hint.setVisibility(VISIBLE);

                tv_hint.setText( Html.fromHtml(hint));
                break;
            case 2://sign
                tv_hint.setVisibility(VISIBLE);
                tv_hint.setText( Html.fromHtml("未完成订单"));
                break;
            case 3://sign
                tv_hint.setVisibility(VISIBLE);

                tv_hint.setText( Html.fromHtml("您的会员即将到期请尽快续费"));
                break;
            case 4://sign
                tv_hint.setVisibility(VISIBLE);

                tv_hint.setText( Html.fromHtml("收到<font color='#F5A623'>"+hint+ "</font>张优惠券"));
                break;
            default:
                break;

        }
    }
}
