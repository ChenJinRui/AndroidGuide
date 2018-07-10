package com.soul.androidguide.views;

import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soul.androidguide.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StyleManager {
    private static final String TAG = "Jarvis_StyleManager";

    //---------------------所有预置风格---------------//

    public static final int STYLE_TYPE_TXT = 1;//普通文本
    public static final int STYLE_TYPE_TXT_R = 2;//可回车文本
    public static final int STYLE_TYPE_SPEECH_WAIT_INDICATOR = 3;
    public static final int STYLE_TYPE_SPEECH_INDICATOR = 4;  //对话框语音收音提示

    public static final int STYLE_TYPE_POSTIMG_BTN = 5; //对话框中 海报加按钮
    public static final int STYLE_TYPE_HEADIMG_TXT = 6; // 对话框中，头像加文本
    public static final int STYLE_TYPE_BTN = 7;    //对话框中的按钮
    public static final int STYLE_TYPE_GUIDE = 8;   //对话框中技能列表
    public static final int STYLE_TYPE_GUIDE_ITEM = 9; //对话框中技能列表条目
    public static final int STYLE_TYPE_PLAYER_BTN = 10;//对话框中视频框加按钮
    public static final int STYLE_TYPE_TXT_VOICEWAVE = 11;
    public static final int STYLE_TYPE_STATIC_SPEECH = 12;

    public static final int STYLE_TYPE_TXT_CANCELED = 13;  //可撤销文本


    public static final int STYLE_TYPE_FULL_GUIDE = 100;  //全部技能列表
    public static final int STYLE_TYPE_FULL_GUIDE_ITEM = 101;//全部技能列表条目

    public static final int STYLE_TYPE_TODO_LIST = 102; //信息大盘样式
    public static final int STYLE_TYPE_TODO_ITEM1 = 103; //固定样式，有subtitle!!像是签到、相册无数据时
    public static final int STYLE_TYPE_TODO_ITEM2 = 104; //消息 无海报、无用户头像、无subtitle。像是优惠券、会员到期
    public static final int STYLE_TYPE_TODO_ITEM3 = 105; //消息有海报样式(下面是提示语加头像). 像是好友分享
    public static final int STYLE_TYPE_TODO_ITEM4 = 106; //固定样式，无subtile!!像是全部技能、相册锁定时。
    public static final int STYLE_TYPE_TODO_ITEM5 = 107; //视频通话样式


    public static final int STYLE_TYPE_JSONVIEW = 1000;

    private static int CONTENT_VIEW_TYPE = 0;

    public static void resetContentViewType(){
        CONTENT_VIEW_TYPE = 0;
    }

    public static int generateContentViewType(){
        return CONTENT_VIEW_TYPE++;
    }

    public static int getContentViewTypeCount(){
        return CONTENT_VIEW_TYPE;
    }

    private static SparseIntArray resources = new SparseIntArray();

    private static Set<Integer> returnRes = new HashSet<>();

    static{
        resources.put(STYLE_TYPE_TXT, R.layout.jarvis_style_txt);
        resources.put(STYLE_TYPE_TXT_R,R.layout.jarvis_style_txt);
        resources.put(STYLE_TYPE_SPEECH_WAIT_INDICATOR,R.layout.jarvis_style_speech_wait);
        resources.put(STYLE_TYPE_SPEECH_INDICATOR,R.layout.jarvis_style_voice);
        resources.put(STYLE_TYPE_POSTIMG_BTN,R.layout.jarvis_style_poster_btn);
        resources.put(STYLE_TYPE_HEADIMG_TXT,R.layout.jarvis_style_headimg_txt);
        resources.put(STYLE_TYPE_BTN,R.layout.jarvis_style_btn);
        resources.put(STYLE_TYPE_GUIDE,R.layout.jarvis_style_guide);
        resources.put(STYLE_TYPE_GUIDE_ITEM,R.layout.jarvis_style_guide_item);
        resources.put(STYLE_TYPE_PLAYER_BTN,R.layout.jarvis_style_player_btn);
        resources.put(STYLE_TYPE_TXT_VOICEWAVE,R.layout.jarvis_style_txt_voicewave);
        resources.put(STYLE_TYPE_STATIC_SPEECH,R.layout.jarvis_style_static_speech);
        resources.put(STYLE_TYPE_TXT_CANCELED,R.layout.jarvis_style_txt);

        resources.put(STYLE_TYPE_FULL_GUIDE,R.layout.jarvis_style_full_guide);
        resources.put(STYLE_TYPE_FULL_GUIDE_ITEM,R.layout.jarvis_style_full_guide_item);
        resources.put(STYLE_TYPE_TODO_LIST,R.layout.jarvis_style_todo_main);
        resources.put(STYLE_TYPE_TODO_ITEM1,R.layout.jarvis_style_todo_item_1);
        resources.put(STYLE_TYPE_TODO_ITEM2,R.layout.jarvis_style_todo_item_2);
        resources.put(STYLE_TYPE_TODO_ITEM3,R.layout.jarvis_style_todo_item_3);
        resources.put(STYLE_TYPE_TODO_ITEM4,R.layout.jarvis_style_todo_item_4);
        resources.put(STYLE_TYPE_TODO_ITEM5,R.layout.jarvis_style_todo_item_5);

        returnRes.add(STYLE_TYPE_TXT_R);
        returnRes.add(STYLE_TYPE_TXT_VOICEWAVE);
        returnRes.add(STYLE_TYPE_SPEECH_INDICATOR);
        returnRes.add(STYLE_TYPE_SPEECH_WAIT_INDICATOR);
        returnRes.add(STYLE_TYPE_STATIC_SPEECH);
        returnRes.add(STYLE_TYPE_TXT_CANCELED);
    }

    public static int getResourceId(String type){
        if(type.startsWith("style_")){
            String[] styleParams = type.split("_");
            if(styleParams.length < 2){
                return -1;
            }
            try {
                int index = Integer.parseInt(styleParams[1]);
                return resources.get(index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static View inflateContentView(DynamicHelper helper, ViewGroup group, LayoutInflater inflater, String type, JSONObject ui, List<JSONArray> data){
        if(type.startsWith("style_")) {
            String[] styleParams = type.split("_");
            if (styleParams.length < 2) {
                return null;
            }
            try {
                int index = Integer.parseInt(styleParams[1]);
                int resourceId = resources.get(index);
                if(resourceId > 0){
                    View contentView = inflater.inflate(resourceId,group,false);
                    if(data != null && data.size() > 0){
                        JSONArray dataArray = data.get(0);
                        if(dataArray == null){
                            return null;
                        }
                        for(int i = 0;i < dataArray.length();i++){
                            JSONObject obj = dataArray.optJSONObject(i);
                            if(obj == null){
                                continue;
                            }
                            helper.applyProperty(contentView,obj);
                        }
                        return contentView;
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static boolean isStyleCanReturn(int type){
        return returnRes.contains(type);
    }

    public static boolean isStyleCanCancel(int type){
        return type == STYLE_TYPE_TXT_CANCELED;
    }
}
