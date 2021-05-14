package com.ngs.repository;

import com.ngs.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {
}
