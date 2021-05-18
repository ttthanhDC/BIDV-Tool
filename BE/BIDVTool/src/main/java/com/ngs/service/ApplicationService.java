package com.ngs.service;

import com.ngs.entity.Application;


import java.util.List;

public interface ApplicationService {
    List<Application> getAll();

    Application getById(Integer id);
    
    void save(Application application);

    void delete(Application application);

    
}
