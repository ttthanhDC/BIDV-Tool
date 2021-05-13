package com.ngs.service;

import com.ngs.request.ImportExcelRequest;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GetExcelDataService {
    List<Triple<Integer, Integer, Object>> getExcelData(ImportExcelRequest inputStream);
}
