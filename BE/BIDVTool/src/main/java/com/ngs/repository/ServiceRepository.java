package com.ngs.repository;

import com.ngs.entity.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository  extends CrudRepository<Service,Integer> {
}
