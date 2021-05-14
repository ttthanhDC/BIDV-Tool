package com.ngs.service;

import com.ngs.entity.Application;
import com.ngs.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ApplicationService {
    void creatApplication(Application application);

}
