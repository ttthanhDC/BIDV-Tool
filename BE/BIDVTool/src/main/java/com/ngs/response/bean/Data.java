package com.ngs.response.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {
    private List<Value> data;
}
