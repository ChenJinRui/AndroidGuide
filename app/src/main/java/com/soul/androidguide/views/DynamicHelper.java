package com.soul.androidguide.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicHelper {
    private static final String TAG = "Jarvis_DynamicHelper";

    private WeakReference<ClickActionListener> mClickActionListener;

    public  void setClickActionListener(ClickActionListener listener){
        mClickActionListener = new WeakReference<ClickActionListener>(listener);
    }

    public String applyStyleProperties(View view, Map<DynamicProperty.NAME,DynamicProperty> properties) {
        String id = "";
        for (DynamicProperty dynProp : properties.values()) {
            switch (dynProp.name) {
                case ID: {
                    id = dynProp.getValueString();
                }
                break;
                case BACKGROUND: {
                    applyBackground(view, dynProp);
                }
                break;
                case TEXT: {
                    applyText(view, dynProp);
                }
                break;
                case TEXTCOLOR: {
                    applyTextColor(view, dynProp);
                }
                break;
                case TEXTSIZE: {
                    applyTextSize(view, dynProp);
                }
                break;
                case TEXTSTYLE: {
                    applyTextStyle(view, dynProp);
                }
                break;
                case PADDING: {
                    applyPadding(view, dynProp);
                }
                break;
                case PADDING_LEFT: {
                    applyPadding(view, dynProp, 0);
                }
                break;
                case PADDING_TOP: {
                    applyPadding(view, dynProp, 1);
                }
                break;
                case PADDING_RIGHT: {
                    applyPadding(view, dynProp, 2);
                }
                break;
                case PADDING_BOTTOM: {
                    applyPadding(view, dynProp, 3);
                }
                break;
                case MINWIDTH: {
                    applyMinWidth(view, dynProp);
                }
                break;
                case MINHEIGHT: {
                    applyMinHeight(view, dynProp);
                }
                break;
                case ELLIPSIZE: {
                    applyEllipsize(view, dynProp);
                }
                break;
                case MAXLINES: {
                    applyMaxLines(view, dynProp);
                }
                break;
                case ORIENTATION: {
                    applyOrientation(view, dynProp);
                }
                break;
                case SUM_WEIGHT: {
                    applyWeightSum(view, dynProp);
                }
                break;
                case GRAVITY: {
                    applyGravity(view, dynProp);
                }
                break;
                case SRC: {
                    applySrc(view, dynProp);
                }
                break;
                case SCALETYPE: {
                    applyScaleType(view, dynProp);
                }
                break;
                case ADJUSTVIEWBOUNDS: {
                    applyAdjustBounds(view, dynProp);
                }
                break;
                case DRAWABLELEFT: {
                    applyCompoundDrawable(view, dynProp, 0);
                }
                break;
                case DRAWABLETOP: {
                    applyCompoundDrawable(view, dynProp, 1);
                }
                break;
                case DRAWABLERIGHT: {
                    applyCompoundDrawable(view, dynProp, 2);
                }
                break;
                case DRAWABLEBOTTOM: {
                    applyCompoundDrawable(view, dynProp, 3);
                }
                break;
                case ENABLED: {
                    applyEnabled(view, dynProp);
                }
                break;
                case SELECTED: {
                    applySelected(view, dynProp);
                }
                break;
                case CLICKABLE: {
                    applyClickable(view, dynProp);
                }
                break;
                case SCALEX: {
                    applyScaleX(view, dynProp);
                }
                break;
                case SCALEY: {
                    applyScaleY(view, dynProp);
                }
                break;
                case TAG: {
                    applyTag(view, dynProp);
                }
                break;
                case FUNCTION: {
                    applyFunction(view, dynProp);
                }
                break;
                case VISIBILITY:{
                    applyVisibility(view, dynProp);
                }
                break;
                case CLICKACTION:{
                    applyClickAction(view,dynProp);
                }
                break;
            }
        }

        return id;
    }

    public  void applyProperty(View view, JSONObject obj){
        Resources resources = view.getResources();
        String id = obj.optString("id");
        if(TextUtils.isEmpty(id)){
            return;
        }

        View targetView = view.findViewWithTag(id);
        if(targetView == null){
            int resourceId = resources.getIdentifier(id,"id", view.getContext().getPackageName());
            if(resourceId > 0){
                targetView = view.findViewById(resourceId);
            }
        }

        if(targetView == null){
            Log.i(TAG," id :" + id + "   targetview is null");
           return;
        }

        Map<DynamicProperty.NAME,DynamicProperty> properties = new HashMap<>();
        JSONArray jArray = obj.optJSONArray("properties");
        if (jArray != null) {
            for (int j=0;j<jArray.length();j++){
                DynamicProperty p = new DynamicProperty(jArray.optJSONObject(j));
                if (p.isValid()){
                    properties.put(p.name,p);
                }
            }
        }
        if(targetView instanceof CustomView){
            Log.i(TAG,"targetview is customView applyStyleProperties");
            ((CustomView)targetView).applyProperty(this,properties);
            return;
        }
        Log.i(TAG,"targetview applyStyleProperties");
        applyStyleProperties(targetView, properties);
    }

    public  void applyLayoutProperties(View view, List<DynamicProperty> properties, ViewGroup viewGroup, HashMap<String, Integer> ids) {
        if (viewGroup == null)
            return;
        ViewGroup.LayoutParams params = createLayoutParams(viewGroup);

        for (DynamicProperty dynProp : properties) {
            try {
                switch (dynProp.name) {
                    case LAYOUT_HEIGHT: {
                        params.height = dynProp.getValueInt();
                    }
                    break;
                    case LAYOUT_WIDTH: {
                        params.width = dynProp.getValueInt();
                    }
                    break;
                    case LAYOUT_MARGIN: {
                        if (params instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams p = ((ViewGroup.MarginLayoutParams) params);
                            p.bottomMargin = p.topMargin = p.leftMargin = p.rightMargin = dynProp.getValueInt();
                        }
                    }
                    break;
                    case LAYOUT_MARGINLEFT: {
                        if (params instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) params).leftMargin = dynProp.getValueInt();
                        }
                    }
                    break;
                    case LAYOUT_MARGINTOP: {
                        if (params instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) params).topMargin = dynProp.getValueInt();
                        }
                    }
                    break;
                    case LAYOUT_MARGINRIGHT: {
                        if (params instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) params).rightMargin = dynProp.getValueInt();
                        }
                    }
                    break;
                    case LAYOUT_MARGINBOTTOM: {
                        if (params instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) params).bottomMargin = dynProp.getValueInt();
                        }
                    }
                    break;
                    case LAYOUT_ABOVE: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ABOVE, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_BELOW: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.BELOW, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_TOLEFTOF: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.LEFT_OF, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_TORIGHTOF: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.RIGHT_OF, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_TOSTARTOF: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.START_OF, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_TOENDOF: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.END_OF, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_ALIGNBASELINE: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_BASELINE, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_ALIGNLEFT: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_LEFT, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_ALIGNTOP: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_TOP, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_ALIGNRIGHT: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_RIGHT, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_ALIGNBOTTOM: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_BOTTOM, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_ALIGNSTART: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_START, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_ALIGNEND: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_END, ids.get(dynProp.getValueString()));
                    }
                    break;
                    case LAYOUT_ALIGNWITHPARENTIFMISSING: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).alignWithParent = dynProp.getValueBoolean();
                    }
                    break;
                    case LAYOUT_ALIGNPARENTTOP: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_TOP);
                    }
                    break;
                    case LAYOUT_ALIGNPARENTBOTTOM: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    }
                    break;
                    case LAYOUT_ALIGNPARENTLEFT: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    }
                    break;
                    case LAYOUT_ALIGNPARENTRIGHT: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    }
                    break;
                    case LAYOUT_ALIGNPARENTSTART: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_START);
                    }
                    break;
                    case LAYOUT_ALIGNPARENTEND: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_END);
                    }
                    break;
                    case LAYOUT_CENTERHORIZONTAL: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.CENTER_HORIZONTAL);
                    }
                    break;
                    case LAYOUT_CENTERVERTICAL: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.CENTER_VERTICAL);
                    }
                    break;
                    case LAYOUT_CENTERINPARENT: {
                        if (params instanceof RelativeLayout.LayoutParams)
                            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.CENTER_IN_PARENT);
                    }
                    break;
                    case LAYOUT_GRAVITY: {
                        switch (dynProp.type) {
                            case INTEGER: {
                                if (params instanceof LinearLayout.LayoutParams)
                                    ((LinearLayout.LayoutParams) params).gravity = dynProp.getValueInt();
                            }
                            break;
                            case STRING: {
                                if (params instanceof LinearLayout.LayoutParams)
                                    ((LinearLayout.LayoutParams) params).gravity = (Integer) dynProp.getValueInt(Gravity.class, dynProp.getValueString().toUpperCase());
                            }
                            break;
                        }
                    }
                    break;
                    case LAYOUT_WEIGHT: {
                        switch (dynProp.type) {
                            case FLOAT: {
                                if (params instanceof LinearLayout.LayoutParams)
                                    ((LinearLayout.LayoutParams) params).weight = dynProp.getValueFloat();
                            }
                            break;
                        }
                    }
                    break;
                }
            } catch (Exception e) {
            }
        }

        view.setLayoutParams(params);
    }

    public  ViewGroup.LayoutParams createLayoutParams(ViewGroup viewGroup) {
        ViewGroup.LayoutParams params = null;
        if (viewGroup!=null) {
            try {
                Class layoutClass = viewGroup.getClass();
                while (!classExists(layoutClass.getName() + "$LayoutParams")) {
                    layoutClass = layoutClass.getSuperclass();
                }
                String layoutParamsClassname = layoutClass.getName() + "$LayoutParams";
                Class layoutParamsClass = Class.forName(layoutParamsClassname);

                params = (ViewGroup.LayoutParams) layoutParamsClass.getConstructor(Integer.TYPE, Integer.TYPE).newInstance(new Object[]{ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (params == null)
            params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        return params;
    }


    public  void applyBackground(final View view, DynamicProperty property) {
        if (view != null) {
            switch (property.type) {
                case COLOR: {
                    view.setBackgroundColor(property.getValueColor());
                }
                break;
                case REF: {

                    view.setBackgroundResource(getDrawableId(view.getContext(), property.getValueString()));
                }
                break;
                case REFURL: {
                    Glide.with(view.getContext())
                            .load(property.getValueString())
                            .asBitmap()
                            .into(new SimpleTarget<Bitmap>() {

                                @Override
                                public void onResourceReady(Bitmap resource,
                                                            GlideAnimation<? super Bitmap> glideAnimation) {
                                    view.setBackgroundDrawable(new BitmapDrawable(resource));
                                }
                            });
                }
                break;
                case BASE64: {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
                        view.setBackground(property.getValueBitmapDrawable());
                    else
                        view.setBackgroundDrawable(property.getValueBitmapDrawable());
                }
                break;
                case DRAWABLE: {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
                        view.setBackground(property.getValueGradientDrawable());
                    else
                        view.setBackgroundDrawable(property.getValueGradientDrawable());
                }
                break;
            }
        }
    }


    public  void applyPadding(View view, DynamicProperty property) {
        if (view != null) {
            switch (property.type) {
                case DIMEN: {
                    int padding = property.getValueInt();
                    view.setPadding(padding, padding, padding, padding);
                }
                break;
            }
        }
    }

    public  void applyPadding(View view, DynamicProperty property, int position) {
        if (view != null) {
            switch (property.type) {
                case DIMEN: {
                    int[] padding = new int[] {
                      view.getPaddingLeft(),
                      view.getPaddingTop(),
                      view.getPaddingRight(),
                      view.getPaddingBottom()
                    };
                    padding[position] = property.getValueInt();
                    view.setPadding(padding[0], padding[1], padding[2], padding[3]);
                }
                break;
            }
        }
    }


    public  void applyMinWidth(View view, DynamicProperty property) {
        if (view != null) {
            if (property.type == DynamicProperty.TYPE.DIMEN) {
                view.setMinimumWidth(property.getValueInt());
            }
        }
    }


    public  void applyMinHeight(View view, DynamicProperty property) {
        if (view != null) {
            if (property.type == DynamicProperty.TYPE.DIMEN) {
                view.setMinimumHeight(property.getValueInt());
            }
        }
    }

    public  void applyEnabled(View view, DynamicProperty property) {
        if (view != null) {
            switch (property.type) {
                case BOOLEAN: {
                    view.setEnabled(property.getValueBoolean());
                }
                break;
            }
        }
    }

    public  void applySelected(View view, DynamicProperty property) {
        if (view != null) {
            switch (property.type) {
                case BOOLEAN: {
                    view.setSelected(property.getValueBoolean());
                }
                break;
            }
        }
    }

    public  void applyClickable(View view, DynamicProperty property) {
        if (view != null) {
            switch (property.type) {
                case BOOLEAN: {
                    view.setClickable(property.getValueBoolean());
                }
                break;
            }
        }
    }

    public  void applyScaleX(View view, DynamicProperty property) {
        if (view != null) {
            switch (property.type) {
                case BOOLEAN: {
                    view.setScaleX(property.getValueFloat());
                }
                break;
            }
        }
    }

    public  void applyScaleY(View view, DynamicProperty property) {
        if (view != null) {
            switch (property.type) {
                case BOOLEAN: {
                    view.setScaleY(property.getValueFloat());
                }
                break;
            }
        }
    }

    private  void applyVisibility(View view, DynamicProperty property) {
        if (view != null) {
            switch (property.type) {
                case STRING: {
                    switch (property.getValueString()){
                        case "gone":{
                            view.setVisibility(View.GONE);
                        }
                        break;
                        case "visible":{
                            view.setVisibility(View.VISIBLE);
                        }
                        break;
                        case "invisible":{
                            view.setVisibility(View.INVISIBLE);
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public  void applyText(View view, DynamicProperty property) {
        if (view instanceof TextView) {
            switch (property.type) {
                case STRING: {
                    ((TextView) view).setText(Html.fromHtml(property.getValueString()));
                }
                break;
                case REF: {
                    ((TextView) view).setText(getStringId(view.getContext(), property.getValueString()));
                }
                break;
            }
        }
    }

    public  void applyTextColor(View view, DynamicProperty property) {
        if (view instanceof TextView) {
            switch (property.type) {
                case COLOR: {
                    ((TextView) view).setTextColor(property.getValueColor());
                }
                break;
            }
        }
    }

    public  void applyTextSize(View view, DynamicProperty property) {
        if (view instanceof TextView) {
            switch (property.type) {
                case DIMEN: {
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_PX, property.getValueFloat());
                }
                break;
            }
        }
    }

    public  void applyTextStyle(View view, DynamicProperty property) {
        if (view instanceof TextView) {
            switch (property.type) {
                case INTEGER: {
                    ((TextView) view).setTypeface(null, property.getValueInt());
                }
                break;
            }
        }
    }

    public  void applyEllipsize(View view, DynamicProperty property) {
        if (view instanceof TextView) {
            ((TextView) view).setEllipsize(TextUtils.TruncateAt.valueOf(property.getValueString().toUpperCase().trim()));
        }
    }

    public  void applyMaxLines(View view, DynamicProperty property) {
        if (view instanceof TextView) {
            ((TextView) view).setMaxLines(property.getValueInt());
        }
    }

    public  void applyGravity(View view, DynamicProperty property) {
        if (view instanceof TextView) {
            switch (property.type) {
                case INTEGER: {
                    ((TextView) view).setGravity(property.getValueInt());
                }
                break;
                case STRING: {
                    ((TextView) view).setGravity((Integer) property.getValueInt(Gravity.class, property.getValueString().toUpperCase()));
                }
                break;
            }
        }
    }

    public  void applyCompoundDrawable(View view, DynamicProperty property, int position) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Drawable[] d = textView.getCompoundDrawables();
            switch (property.type) {
                case REF: {
                    try {
                        d[position] = view.getContext().getResources().getDrawable(getDrawableId(view.getContext(), property.getValueString()));
                    } catch (Exception e) {}
                }
                break;
                case BASE64: {
                    d[position] = property.getValueBitmapDrawable();
                }
                break;
                case DRAWABLE: {
                    d[position] = property.getValueGradientDrawable();
                }
                break;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(d[0], d[1], d[2], d[3]);
        }
    }

    public  void applySrc(View view, DynamicProperty property) {
        if (view instanceof ImageView) {
            switch (property.type) {
                case REF: {
                    ((ImageView) view).setImageResource(getDrawableId(view.getContext(), property.getValueString()));
                }
                break;
                case REFURL: {
                    Glide.with(view.getContext()).load(property.getValueString()).into((ImageView)view);
                }
                break;
                case BASE64: {
                    ((ImageView) view).setImageBitmap(property.getValueBitmap());
                }
                break;
            }
        }
    }

    public  void applyScaleType(View view, DynamicProperty property) {
        if (view instanceof ImageView) {
            switch (property.type) {
                case STRING: {
                    ((ImageView) view).setScaleType(ImageView.ScaleType.valueOf(property.getValueString().toUpperCase()));
                }
                break;
            }
        }
    }

    public  void applyAdjustBounds(View view, DynamicProperty property) {
        if (view instanceof ImageView) {
            switch (property.type) {
                case BOOLEAN: {
                    ((ImageView) view).setAdjustViewBounds(property.getValueBoolean());
                }
                break;
            }
        }
    }

    public  void applyOrientation(View view, DynamicProperty property) {
        if (view instanceof LinearLayout) {
            switch (property.type) {
                case INTEGER: {
                    ((LinearLayout) view).setOrientation(property.getValueInt() == 0 ? LinearLayout.HORIZONTAL : LinearLayout.VERTICAL);
                }
                break;
                case STRING: {
                    ((LinearLayout) view).setOrientation(property.getValueString().equalsIgnoreCase("HORIZONTAL") ? LinearLayout.HORIZONTAL : LinearLayout.VERTICAL);
                }
                break;
            }
        }
    }

    public  void applyWeightSum(View view, DynamicProperty property) {
        if ((view instanceof LinearLayout) && (property.type == DynamicProperty.TYPE.FLOAT)) {
            ((LinearLayout) view).setWeightSum(property.getValueFloat());
        }
    }

    public  void applyTag(View view, DynamicProperty property) {
        view.setTag(property.getValueString());
    }

    public  void applyClickAction(final View view, DynamicProperty property){
        if (property.type == DynamicProperty.TYPE.CLICKJSON) {
            final ClickActionListener listener = mClickActionListener.get();
            if(listener == null){
                return;
            }

            try {
                final JSONObject jsonObject = new JSONObject(property.getValueString());
                listener.onClickJsonApply(view,jsonObject);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onClick(view,jsonObject);
                    }
                });

            } catch (Exception e) {
            }
        }
    }

    public  void applyFunction(View view, DynamicProperty property) {

        if (property.type == DynamicProperty.TYPE.JSON) {
            try {
                JSONObject json = property.getValueJSON();

                String functionName = json.getString("function");
                JSONArray args = json.getJSONArray("args");

                Class[] argsClass;
                Object[] argsValue;
                if (args==null) {
                    argsClass = new Class[0];
                    argsValue = new Object[0];
                } else {
                    try {
                        List<Class> classList = new ArrayList<>();
                        List<Object> valueList= new ArrayList<>();

                        int i=0;
                        int count = args.length();
                        for (; i<count ; i++) {
                            JSONObject argJsonObj = args.getJSONObject(i);
                            boolean isPrimitive = argJsonObj.has("primitive");
                            String className = argJsonObj.getString( isPrimitive ? "primitive" : "class");
                            String classFullName = className;
                            if (!classFullName.contains("."))
                                classFullName = "java.lang." + className;
                            Class clazz = Class.forName(classFullName);
                            if (isPrimitive) {
                                Class primitiveType = (Class)clazz.getField("TYPE").get(null);
                                classList.add( primitiveType );
                            } else {
                                classList.add( clazz );
                            }

                            try {
                                valueList.add( getFromJSON(argJsonObj, "value", clazz) );
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        argsClass = classList.toArray(new Class[classList.size()]);
                        argsValue = valueList.toArray(new Object[valueList.size()]);
                    } catch (Exception e) {
                        argsClass = new Class[0];
                        argsValue = new Object[0];
                    }
                }

                try {
                    view.getClass().getMethod(functionName, argsClass).invoke(view, argsValue);
                } catch (SecurityException e) {
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public  int getDrawableId(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }


    public  static int getStringId(Context context, String name) {
        return context.getResources().getIdentifier(name, "string", context.getPackageName());
    }


    public static  float dpToPx(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
//        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * convert scalePixel to pixel
     */
    public  static float spToPx(float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, Resources.getSystem().getDisplayMetrics());
    }

    public  static float pxToDp(int px) {
        return (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public  static float pxToSp(int px) {
        return (px / Resources.getSystem().getDisplayMetrics().scaledDensity);
//        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, px, Resources.getSystem().getDisplayMetrics());
    }

    public  static float dpToSp(float dp) {
        return (int) ( dpToPx(dp) / Resources.getSystem().getDisplayMetrics().scaledDensity);
    }

    public  static int deviceWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public  void parseDynamicView(Object target, View container, HashMap<String, Integer> idsMap) {

        for (Field field : target.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(DynamicViewId.class)) {
                final DynamicViewId dynamicViewIdAnnotation = field.getAnnotation(DynamicViewId.class);
                String id = dynamicViewIdAnnotation.id();
                if (id.equalsIgnoreCase(""))
                    id = field.getName();
                if (idsMap.containsKey(id)) {
                    try {
                       field.set(target, container.findViewById(idsMap.get(id)));
                    } catch (IllegalArgumentException e) {
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } else if ((field.getName().equalsIgnoreCase("ids")) && (field.getType() == idsMap.getClass())) {
                try {
                    field.set(target, idsMap);
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private Object getFromJSON(JSONObject json, String name, Class clazz) throws JSONException {
        if ((clazz == Integer.class)||(clazz == Integer.TYPE)) {
            return json.getInt(name);
        } else if ((clazz == Boolean.class)||(clazz == Boolean.TYPE)) {
            return json.getBoolean(name);
        } else if ((clazz == Double.class)||(clazz == Double.TYPE)) {
            return json.getDouble(name);
        } else if ((clazz == Float.class)||(clazz == Float.TYPE)) {
            return (float)json.getDouble(name);
        } else if ((clazz == Long.class)||(clazz == Long.TYPE)) {
            return json.getLong(name);
        } else if (clazz == String.class) {
            return json.getString(name);
        } else if (clazz == JSONObject.class) {
            return json.getJSONObject(name);
        } else {
            return json.get(name);

        }
    }

    public  boolean classExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch(ClassNotFoundException ex) {
            return false;
        }
    }

}
