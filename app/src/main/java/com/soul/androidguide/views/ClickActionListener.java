package com.soul.androidguide.views;


import android.view.View;

import org.json.JSONObject;

public interface ClickActionListener {
    public void onClick(View view, JSONObject jsonData);

    public void onClickJsonApply(View view, JSONObject jsonData);
}
