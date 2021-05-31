package com.ngs.response.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalTaskByOperation {
    private List<Category> categories;
    private List<com.ngs.response.bean.Data> dataset;

}
