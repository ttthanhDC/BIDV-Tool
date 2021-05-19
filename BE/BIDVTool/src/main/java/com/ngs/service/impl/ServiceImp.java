package com.ngs.service.impl;

import com.ngs.entity.ApplicationServiceMap;
import com.ngs.repository.ApplicationServiceMapRepository;
import com.ngs.repository.ServiceRepository;

import com.ngs.service.ServicesService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ngs.entity.Services;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImp implements ServicesService {
    @Autowired
    ServiceRepository servicesRepository;
    @Autowired
    ApplicationServiceMapRepository mapRepository;
    @Override
    public List<Services> getAll(){
        Iterable<Services> services = servicesRepository.findAll();
        if(services!=null){
            List<Services> list = IterableUtils.toList(services);
            return  list;
        }
        return null;
    }
    @Override
    public  Services getById(Integer id){
        Optional<Services> services = servicesRepository.findById(id);
        if(services.isPresent()){
            return services.get();
        }
        return null;
    }
    @Override
    public void save( Services services){
        servicesRepository.save(services);
    }
    @Override
    public void delete(Services services){
        servicesRepository.delete(services);
    }
    @Override
    public List<Services> getListServiceByAppId(Integer appId){
        return mapRepository.listMap(appId);
    }
}
