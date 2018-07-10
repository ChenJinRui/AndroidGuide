package com.soul.androidguide.views;

import java.util.Map;

public interface CustomView {
    public void applyProperty(DynamicHelper helper, Map<DynamicProperty.NAME, DynamicProperty> properties);
}
