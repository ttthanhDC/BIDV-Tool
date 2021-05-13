package com.ngs.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportExcelResponseBody {

    private String status;
    private int totalRecord;

}
