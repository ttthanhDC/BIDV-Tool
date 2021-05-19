package com.ngs.repository;

import com.ngs.entity.ApplicationServiceMap;
import com.ngs.entity.Services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationServiceMapRepository extends CrudRepository<ApplicationServiceMap, Integer> {
    @Query(value="select app.service from ApplicationServiceMap app where app.application.id=:appId")
    List<Services> listMap(Integer appId);
}
