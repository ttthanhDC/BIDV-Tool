package com.ngs.request;

import com.ngs.util.StringUtil;

public abstract class BaseRequest {

    @Override
    public String toString() {
        return StringUtil.toJsonString(this);
    }
}
