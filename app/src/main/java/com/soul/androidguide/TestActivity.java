package com.soul.androidguide;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSONObject;
import com.soul.androidguide.bean.InformationData;
import com.soul.androidguide.views.InfoGrailItem;
import com.soul.androidguide.views.InfoGrailItemTwo;

import java.util.ArrayList;

public class TestActivity extends Activity {
//    private ArrayList<RelativeLayout> mRootItem = new

    private final static String TAG = "TestActivity";

    private final static String json = "{\"code\":0,\"message\":0,\"data\":{\"todo\":{\"sign\":{\"days\":1,\"vcoin\":\"20V\",\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.demo.AllApp\",\"pkgName\":\"com.ysten.demo\",\"background\":\"ImgUrl or ImgType\"},\"weather\":{\"weather\":\"25/30°C\",\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.demo.AllApp\",\"pkgName\":\"com.ysten.demo\",\"background\":\"ImgUrl or ImgType\"},\"order\":{\"hint\":\"未完成订单\",\"hintNum\":6,\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.demo.AllApp\",\"pkgName\":\"com.ysten.demo\",\"background\":\"ImgUrl or ImgType\"},\"member\":{\"hint\":\"会员即将到期\",\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.facerecognition.activity.TakePhotoActivity\",\"pkgName\":\"com.ysten.facerecognition\",\"background\":\"ImgUrl or ImgType\"},\"coupon\":{\"num\":2,\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.facerecognition.activity.TakePhotoActivity\",\"pkgName\":\"com.ysten.facerecognition\",\"background\":\"http://pic31.photophoto.cn/20140413/0008020202812990_b.jpg\"}},\"recommendation\":{\"exclusive\":{\"title\":\"《冰雪奇缘》\",\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"http://pic31.photophoto.cn/20140413/0008020202812990_b.jpg\"},\"subscribe\":{\"title\":\"《冰雪奇缘》\",\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"ImgUrl or ImgType\"}},\"visible\":{\"recommend\":{\"title\":\"《冰雪奇缘》\",\"hintText\":\"电影\",\"who\":\"小伟\",\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"ImgUrl or ImgType\",\"headUrl\":\"url\"},\"shareVideo\":{\"who\":\"小伟\",\"hintNum\":7,\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"ImgUrl or ImgType\",\"headUrl\":\"url\"},\"shareImg\":{\"who\":\"小伟\",\"hintNum\":7,\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"ImgUrl or ImgType\",\"headUrl\":\"url\"},\"call\":{\"who\":\"小伟\",\"hintNum\":7,\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"ImgUrl or ImgType\",\"hintBackground\":\"ImgUrl or ImgType\"}},\"smart\":{\"face\":{\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"ImgUrl or ImgType\",\"hintBackground\":\"ImgUrl or ImgType\"},\"voiceprint\":{\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"ImgUrl or ImgType\",\"hintBackground\":\"ImgUrl or ImgType\"},\"voice\":{\"actionType\":1,\"actionUrl\":\"xxxx\",\"className\":\"com.ysten.app.camera.gallery.GalleryActivity\",\"pkgName\":\"com.ysten.app.camera\",\"background\":\"ImgUrl or ImgType\",\"hintBackground\":\"ImgUrl or ImgType\"}}}}";
    private RelativeLayout mTodoRelativeLayout;
    private RelativeLayout mRecommendationRelativeLayout;
    private RelativeLayout mVisibleRelativeLayout;
    private RelativeLayout mSmartRelativeLayout;

    private InformationData mData;

    private ArrayList<Integer> todoIDs = new ArrayList<>();
    private ArrayList<Integer> recomIDs = new ArrayList<>();
    private ArrayList<Integer> visibleIDs = new ArrayList<>();
    private ArrayList<Integer> smartIDs = new ArrayList<>();

    private final static int MAX_ITEM_LINE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.out_from_left, R.anim.in_from_left);


        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initView() {
        setContentView(R.layout.activity_test);
        mTodoRelativeLayout = findViewById(R.id.info_todo_layout);
        mRecommendationRelativeLayout = findViewById(R.id.info_recommendation_layout);
        mVisibleRelativeLayout = findViewById(R.id.info_visible_layout);
        mSmartRelativeLayout = findViewById(R.id.info_smart_layout);


        initData();
        addView(mData);
//        toAddView();
        toAddView2();
        toAddView3();
    }

    private void initData() {
        mData = JSONObject.parseObject(json,InformationData.class);

        Log.e(TAG,mData.toString());
    }


    private final static int MARGINS = 40;
    private final static int FAR_LEFT = 10;
    private final static int MARGINS_LEFT = 20;
    private final static int MARGINS_RIGHT = 0;
    private void addView (InformationData data){

        /**
         * TodoBean
         */
        InformationData.DataBean.TodoBean todoData = data.getData().getTodo();
        if(null != todoData){
            InformationData.DataBean.TodoBean.SignBean mSignBean = todoData.getSign();
            if(null != mSignBean){
                InfoGrailItem m = new InfoGrailItem(this,R.drawable.ic_sign_in,
                        mSignBean.getPkgName(),mSignBean.getClassName(),"0");
                RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                mParams.setMargins(FAR_LEFT,MARGINS,MARGINS_RIGHT,MARGINS);
                m.setLayoutParams(mParams);
                m.setFocusable(true);
                m.setId(R.id.todoSignName);
                m.setTextType(0,"2","20V");
                todoIDs.add(R.id.todoSignName);
                mTodoRelativeLayout.addView(m);
            }
            InformationData.DataBean.TodoBean.WeatherBean mWeatherBean= todoData.getWeather();
            if(null != mWeatherBean){
                InfoGrailItem m = new InfoGrailItem(this,R.drawable.ic_weather,
                        mWeatherBean.getPkgName(),mWeatherBean.getClassName(),"0");
                RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                if(todoIDs.size() > 0){
                    mParams.addRule(RelativeLayout.RIGHT_OF,todoIDs.get(todoIDs.size()-1));
                }

                mParams.setMargins(MARGINS_LEFT,MARGINS,MARGINS_RIGHT,MARGINS);
                m.setLayoutParams(mParams);
                m.setFocusable(true);
                m.setTextType(1,"25/30℃",null);
                m.setId(R.id.todoWeatherName);
                todoIDs.add(R.id.todoWeatherName);
                mTodoRelativeLayout.addView(m);
            }
            InformationData.DataBean.TodoBean.OrderBean mOrderBean= todoData.getOrder();
            if(null != mOrderBean){
                InfoGrailItem m = new InfoGrailItem(this,R.drawable.ic_unfinish_order,
                        mOrderBean.getPkgName(),mOrderBean.getClassName(),mOrderBean.getHintNum()+"");
                RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                if(todoIDs.size() > 0){
                    mParams.addRule(RelativeLayout.RIGHT_OF,todoIDs.get(todoIDs.size()-1));
                }
                mParams.setMargins(MARGINS_LEFT,MARGINS,MARGINS_RIGHT,MARGINS);
                m.setLayoutParams(mParams);
                m.setFocusable(true);
                m.setTextType(2,null,null);
                m.setId(R.id.todoOrderName);
                todoIDs.add(R.id.todoOrderName);
                mTodoRelativeLayout.addView(m);
            }
            InformationData.DataBean.TodoBean.MemberBean mMemberBean= todoData.getMember();
            if(null != mMemberBean){
                InfoGrailItem m = new InfoGrailItem(this,R.drawable.ic_member,
                        mMemberBean.getPkgName(),mMemberBean.getClassName(),"0");
                RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                if(todoIDs.size() > 0){
                    mParams.addRule(RelativeLayout.RIGHT_OF,todoIDs.get(todoIDs.size()-1));
                }
                mParams.setMargins(MARGINS_LEFT,MARGINS,MARGINS_RIGHT,MARGINS);
                m.setLayoutParams(mParams);
                m.setFocusable(true);
                m.setTextType(3,null,null);
                m.setId(R.id.todoMemberName);
                todoIDs.add(R.id.todoMemberName);
                mTodoRelativeLayout.addView(m);
            }
            InformationData.DataBean.TodoBean.CouponBean mCouponBean= todoData.getCoupon();
            if(null != mCouponBean){
                InfoGrailItem m = new InfoGrailItem(this,R.drawable.ic_coupon,
                        mCouponBean.getPkgName(),mCouponBean.getClassName(),"0");
                RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                if(todoIDs.size() > 0){
                    mParams.addRule(RelativeLayout.RIGHT_OF,todoIDs.get(todoIDs.size()-1));
                }
                mParams.setMargins(MARGINS_LEFT,MARGINS,MARGINS_RIGHT,MARGINS);
                m.setLayoutParams(mParams);
                m.setFocusable(true);
                m.setTextType(4,"n",null);
                m.setId(R.id.todoCouponName);
                todoIDs.add(R.id.todoCouponName);
                mTodoRelativeLayout.addView(m);
            }
        }else{
            mTodoRelativeLayout.setVisibility(View.GONE);
        }
        /**
         * Recommendation
         */
        InformationData.DataBean.RecommendationBean  mRecommendationBean= data.getData().getRecommendation();
        if(null != mRecommendationBean){
            InformationData.DataBean.RecommendationBean.ExclusiveBean mExclusiveBean =
                    mRecommendationBean.getExclusive();
            if(null != mExclusiveBean){
                if(mExclusiveBean.getViewType() == 0){
                    InfoGrailItemTwo m = new InfoGrailItemTwo(this,mExclusiveBean.getBackground(),
                            mExclusiveBean.getTitle(),mExclusiveBean.getActionUrl());
                    RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    mParams.setMargins(FAR_LEFT,MARGINS,MARGINS_RIGHT,MARGINS);
                    m.setLayoutParams(mParams);
                    m.setFocusable(true);
                    m.setId(R.id.recomExclusiveName);
                    recomIDs.add(R.id.recomExclusiveName);

                    mRecommendationRelativeLayout.addView(m);
                    m.setInfo(0);
                }
            }
            InformationData.DataBean.RecommendationBean.SubscribeBean mSubscribeBean = mRecommendationBean.getSubscribe();
            if(null != mSubscribeBean){
                InfoGrailItemTwo m = new InfoGrailItemTwo(this,mSubscribeBean.getBackground(),
                        mSubscribeBean.getTitle(),mSubscribeBean.getActionUrl());
                RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                mParams.setMargins(MARGINS_LEFT,MARGINS,MARGINS_RIGHT,MARGINS);
                if(recomIDs.size() > 0){
                    mParams.addRule(RelativeLayout.RIGHT_OF,recomIDs.get(recomIDs.size()-1));
                }
                m.setLayoutParams(mParams);
                m.setFocusable(true);
                m.setId(R.id.recomSubscribeName);
                recomIDs.add(R.id.recomSubscribeName);

                mRecommendationRelativeLayout.addView(m);
                m.setInfo(1);
            }
        }else{
            mRecommendationRelativeLayout.setVisibility(View.GONE);
        }
        data.getData().getVisible();
        data.getData().getSmart();
    }

    private void toAddView() {
        InfoGrailItem m = new InfoGrailItem(this,R.drawable.ic_sign_in,"tv.icntv.ott","com.istv.ystengrowthsystem.ui.vcoins.myvcoins.MyVCoinsActivity","8");
        RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(260,260);
        mParams.setMargins(10,40,0,40);
        m.setLayoutParams(mParams);
        m.setFocusable(true);
        m.setId(R.id.visibleCallName);

        mRecommendationRelativeLayout.addView(m);

        InfoGrailItem mm = new InfoGrailItem(this,R.drawable.ic_sign_in,"com.ysten.demo","com.ysten.demo.AllApp","3");
        RelativeLayout.LayoutParams  mmParams = new RelativeLayout.LayoutParams(260,260);
        mmParams.addRule(RelativeLayout.RIGHT_OF,m.getId());
        mmParams.setMargins(20,40,0,40);
        mm.setLayoutParams(mmParams);
        mm.setFocusable(true);
        mm.setId(R.id.recomSubscribeName);

        mRecommendationRelativeLayout.addView(mm);
    }
    private void toAddView2() {
        InfoGrailItem m = new InfoGrailItem(this,R.drawable.ic_sign_in,"com.ysten.facerecognition","com.ysten.facerecognition.activity.TakePhotoActivity","3");
        RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(260,260);
        mParams.setMargins(10,40,0,40);
        m.setLayoutParams(mParams);
        m.setFocusable(true);
        m.setId(R.id.recomExclusiveName);

        mVisibleRelativeLayout.addView(m);

        InfoGrailItem mm = new InfoGrailItem(this,R.drawable.ic_sign_in,"com.ysten.facerecognition","com.ysten.facerecognition.activity.TakePhotoActivity","3");
        RelativeLayout.LayoutParams  mmParams = new RelativeLayout.LayoutParams(260,260);
        mmParams.addRule(RelativeLayout.RIGHT_OF,m.getId());
        mmParams.setMargins(20,40,0,40);
        mm.setLayoutParams(mmParams);
        mm.setFocusable(true);
        mm.setId(R.id.smartVoicePrintName);

        mVisibleRelativeLayout.addView(mm);
    }
    private void toAddView3() {
        InfoGrailItem m = new InfoGrailItem(this,R.drawable.ic_sign_in,"com.ysten.facerecognition","com.ysten.facerecognition.activity.TakePhotoActivity","3");
        RelativeLayout.LayoutParams  mParams = new RelativeLayout.LayoutParams(260,260);
        mParams.setMargins(10,40,0,40);
        m.setLayoutParams(mParams);
        m.setFocusable(true);
        m.setId(R.id.smartVoiceName);

        mSmartRelativeLayout.addView(m);

        InfoGrailItem mm = new InfoGrailItem(this,R.drawable.ic_sign_in,"com.ysten.facerecognition","com.ysten.facerecognition.activity.TakePhotoActivity","3");
        RelativeLayout.LayoutParams  mmParams = new RelativeLayout.LayoutParams(260,260);
        mmParams.addRule(RelativeLayout.RIGHT_OF,m.getId());
        mmParams.setMargins(20,40,0,40);
        mm.setLayoutParams(mmParams);
        mm.setFocusable(true);
        mm.setId(R.id.smartFaceName);

        mSmartRelativeLayout.addView(mm);
    }

}
