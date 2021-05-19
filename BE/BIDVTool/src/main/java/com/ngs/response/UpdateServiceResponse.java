package com.ngs.response;

import com.ngs.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateServiceResponse {
    Service previousService;
    Service updateService;
}
