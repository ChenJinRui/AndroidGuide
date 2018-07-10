package com.soul.androidguide.views;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

public class CustomViewHelper {
    private static final String TAG = "Jarvis_CustomViewHelper";
    //将数据填充子view后依次加入group.
    public static void applySubLayout(DynamicHelper helper, ViewGroup group, DynamicProperty data){
        if(data != null){
            LayoutInflater inflater = LayoutInflater.from(group.getContext());
            if(data.type.equals(DynamicProperty.TYPE.SUBARRAY)) {
                JSONArray allSubArray = data.getValueArray();
                if(allSubArray == null){
                    return;
                }
                for(int k = 0; k< allSubArray.length();k++){
                    JSONObject dataObj = allSubArray.optJSONObject(k);
                    Log.i(TAG,"sublayout data:" + dataObj);
                    if(dataObj == null){
                        return;
                    }
                    String style = dataObj.optString("layout");
                    int resource = StyleManager.getResourceId(style);
                    if(resource <= 0){
                        return;
                    }
                    JSONArray dataArray = dataObj.optJSONArray("data");
                    Log.i(TAG,"sublayout data len:" + dataArray.length());
                    View subView = inflater.inflate(resource, group,false);
                    for(int j = 0; j < dataArray.length(); j++){
                        JSONObject prop = dataArray.optJSONObject(j);
                        Log.i(TAG,"sublayout item prop:" + prop);
                        if(prop != null){
                            if (subView != null) {
                                helper.applyProperty(subView, prop);
                            }
                        }
                    }
                    group.addView(subView);
                }
            }
        }
    }
}
