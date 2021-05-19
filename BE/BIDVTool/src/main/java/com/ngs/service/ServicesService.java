package com.ngs.service;

import com.ngs.entity.Service;
import com.ngs.request.UpdateOperationRequest;
import com.ngs.response.UpdateOperationResponse;

import java.util.List;

public interface ServicesService {
    List<Service> getAll();

    Service getById(Integer id);

    void save(Service services);

    void delete(Service services);

    List<Service> getListServiceByAppId(Integer appId);
}
