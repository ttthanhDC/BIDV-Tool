package com.ngs.service.impl;

import com.ngs.request.ImportExcelRequest;
import com.ngs.service.GetExcelDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: duongnd
 * @since: 5/13/2021
 * @description: read excel file and save into DB
 */
@Slf4j
@Service
public class GetExcelDataByApachePOI implements GetExcelDataService {

    @Override
    public List<Triple<Integer, Integer, Object>> getExcelData(ImportExcelRequest request) {
        List<Triple<Integer, Integer, Object>> result = new ArrayList<>();
        try (XSSFWorkbook workbook = new XSSFWorkbook(request.getInputStream())) {
            XSSFSheet sheet = Objects.requireNonNull(workbook.getSheetAt(request.getSheetIndex()));
            log.info(sheet.getSheetName());
            XSSFRow row1 = sheet.getRow(0);
            log.info(row1.getCell(0).getStringCellValue());
            for (Row row : sheet) {
                if (row.getRowNum() < request.getStartRow()) {
                    continue;
                }
                for (Cell cell : row) {
                    if (!request.getCells().contains(cell.getColumnIndex())) {
                        continue;
                    }
                    Object data = getCellData(cell);
                    Triple record = new ImmutableTriple(cell.getRowIndex(), cell.getColumnIndex(), data);
                    result.add(record);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return result;
    }

    private Object getCellData(Cell cell) {
        if (cell != null) {
            CellType cellType = cell.getCellType();
            switch (cellType) {
                case FORMULA:
                case STRING:
                    return Objects.requireNonNull(cell.getStringCellValue());
                case NUMERIC:
                    return Objects.requireNonNull(cell.getNumericCellValue());
            }
        }
        return null;
    }
}
