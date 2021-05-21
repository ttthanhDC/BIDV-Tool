package com.ngs.service.impl;

import com.ngs.repository.DashBoardRepository;
import com.ngs.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    DashBoardRepository dashBoardRepository;

    @Override
    public List<Map<String, Double>> successServices() {
        return dashBoardRepository.successServices();
    }
}
