package com.ngs.service.impl;

import com.ngs.request.ImportExcelRequest;
import com.ngs.service.ImportExcelService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationImport implements ImportExcelService {
    @Override
    public ImportExcelRequest getImportRequest() {
        ImportExcelRequest request = ImportExcelRequest.builder()
                .sheetIndex(0)
                .startRow(6)
                .cells(Stream.of(1, 2, 3, 4).collect(Collectors.toSet()))
                .build();
        return request;
    }
}
