package com.soul.androidguide.views;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.istv.ystframework.terminal.TerminalManager;
import com.soul.androidguide.R;

import static com.istv.ystframework.terminal.RouteProviderConstants.JUMP_DETAILS_PAGE;



public class InfoGrailItemTwo extends RelativeLayout {
    private Context mContext ;
    private ImageView img_content,img_focus;
    private TextView tv_name ;
    private int index ;
    private String verticalPoster;
    private String itemTitle;
    private String actionUrl;
    public InfoGrailItemTwo(@NonNull Context context,String bg,String itemTitle,
                            String actionUrl) {
        super(context, null, 0);
        this.verticalPoster = bg;
        this.itemTitle = itemTitle;
        this.actionUrl = actionUrl;
        mContext = context ;
        initView();
    }
    public InfoGrailItemTwo(@NonNull Context context) {
        this(context,null);
    }

    public InfoGrailItemTwo(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public InfoGrailItemTwo(@NonNull Context context,
                            @Nullable AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context ;
                initView();
    }

    private void initView(){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.jarvis_infograil_type2,this);
        img_content = (ImageView)findViewById(R.id.img_content);
        tv_name = (TextView) findViewById(R.id.tv_name);
        img_focus = (ImageView)findViewById(R.id.img_focus);

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
                if (TextUtils.isEmpty(actionUrl) )
                    return;
                Intent intent = new Intent();

                intent.putExtra("programSeriesId",actionUrl);
                intent.putExtra("isLargePlay",false);
                TerminalManager.getInstance().jumpLauncherApp(JUMP_DETAILS_PAGE,intent);
            }
        });
    }

    public void setInfo(int index){
        this.index = index ;
        if (TextUtils.isEmpty(verticalPoster)||TextUtils.isEmpty(itemTitle))
            return;
        Log.e("setInfo",verticalPoster);
        Glide.with(mContext)
                .load(verticalPoster)
                .into(img_content);

        if (index == 0){
            SpannableString s1 = new SpannableString("您的专属收视区更新了\n"+itemTitle);

            s1.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.color_F5A623)),
                    "您的专属收视区更新了\n".length(), s1.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            tv_name.setText(s1);
        }else if (index == 1){
            SpannableString s1 = new SpannableString("您订阅的"+itemTitle+"马上就要开始直播了");

            s1.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.color_F5A623)),
                    "您订阅的".length(), "您订阅的".length()+itemTitle.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            tv_name.setText(s1);
        }
    }
}
