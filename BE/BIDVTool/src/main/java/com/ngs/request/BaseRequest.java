package com.ngs.request;

import lombok.Data;

@Data
public abstract class BaseRequest<T> {
    protected RequestHeader requestHeader;
    protected T requestBody;
}
