package com.ngs.service.impl;

import com.ngs.repository.ApplicationServiceMapRepository;
import com.ngs.repository.ServiceRepository;

import com.ngs.service.ServicesService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.ngs.entity.Service;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImp implements ServicesService {
    @Autowired
    ServiceRepository servicesRepository;
    @Autowired
    ApplicationServiceMapRepository mapRepository;

    @Override
    public List<Service> getAll(){
        Iterable<Service> services = servicesRepository.findAll();
        if(services!=null){
            List<Service> list = IterableUtils.toList(services);
            return  list;
        }
        return null;
    }
    @Override
    public Service getById(Integer id){
        Optional<Service> services = servicesRepository.findById(id);
        if(services.isPresent()){
            return services.get();
        }
        return null;
    }
    @Override
    public void save( Service services){
        servicesRepository.save(services);
    }
    @Override
    public void delete(Service services){
        servicesRepository.delete(services);
    }
    @Override
    public List<Service> getListServiceByAppId(Integer appId){
        return mapRepository.listMap(appId);
    }
}
