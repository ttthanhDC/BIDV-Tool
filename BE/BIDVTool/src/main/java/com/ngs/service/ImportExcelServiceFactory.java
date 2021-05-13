package com.ngs.service;

import com.ngs.constant.ImportFunction;
import com.ngs.service.impl.ApplicationImport;
import com.ngs.util.StringUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImportExcelServiceFactory {

    public static ImportExcelService getImportService(String function) {
        switch (function) {
            case ImportFunction.APPLICATION_IMPORT:
                return new ApplicationImport();
        }
        return null;
    }
}
