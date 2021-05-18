package com.ngs.repository;

import com.ngs.entity.Services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository  extends CrudRepository<Services,Integer> {
}
