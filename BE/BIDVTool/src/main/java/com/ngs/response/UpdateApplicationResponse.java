package com.ngs.response;

import com.ngs.entity.Application;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicationResponse {
    private Application previousApplication;
    private Application updatedApplication;
}
