package com.ngs.response;

import com.ngs.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateServiceResponse {
    Services previousService;
    Services updateService;
}
