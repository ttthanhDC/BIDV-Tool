package com.ngs.service;

import com.ngs.entity.Services;
import com.ngs.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ServicesService {
  List<Services> getAll();
  Services getById(Integer id);
  void save(Services services);
  void delete(Services services);
}
