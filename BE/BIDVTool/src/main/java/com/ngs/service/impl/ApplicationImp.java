package com.ngs.service.impl;

import com.ngs.entity.Application;
import com.ngs.repository.ApplicationRepository;
import com.ngs.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Service
public class ApplicationImp implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    public void creatApplication(Application application) {
        applicationRepository.save(application);
    }

    public void getApplication(int id) {
        applicationRepository.findById(id);
    }
}
