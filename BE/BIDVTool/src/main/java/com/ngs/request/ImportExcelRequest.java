package com.ngs.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportExcelRequest {
    private InputStream inputStream;
    private int sheetIndex;
    private String sheetName;
    private int startRow;
    private Set<Integer> cells;
}
