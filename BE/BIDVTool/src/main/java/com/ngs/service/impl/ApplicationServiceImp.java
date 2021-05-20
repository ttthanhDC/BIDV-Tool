package com.ngs.service.impl;

import com.ngs.entity.Application;
import com.ngs.repository.ApplicationRepository;
import com.ngs.service.ApplicationService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImp implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public List<Application> getAll() {
        Iterable<Application> applications = applicationRepository.findAll();
        if (applications != null) {
            List<Application> applicationList = IterableUtils.toList(applications);
            return applicationList;
        }
        return new ArrayList<>();
    }

    @Override
    public Application getById(Integer id) {
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        if (applicationOptional.isPresent()) {
            return applicationOptional.get();
        }
        return null;
    }

    @Override
    public void save(Application application) {
        applicationRepository.save(application);
    }

    @Override
    public void delete(Application application) {
        applicationRepository.delete(application);
    }
}
