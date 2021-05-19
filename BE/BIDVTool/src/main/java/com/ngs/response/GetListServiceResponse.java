package com.ngs.response;

import com.ngs.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetListServiceResponse {
    List<Service> services;
}
