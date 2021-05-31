package com.ngs.response.bean;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalGetServiceByApp {
    private List<Category> categories;
    private List<com.ngs.response.bean.Data> dataset;
}
