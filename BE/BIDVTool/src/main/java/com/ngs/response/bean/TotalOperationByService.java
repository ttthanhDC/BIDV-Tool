package com.ngs.response.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalOperationByService {
    private List<Category> categories;
    private List<com.ngs.response.bean.Data> dataset;
}
