package com.ngs.repository;

import com.ngs.entity.OpenIssue;
import com.ngs.entity.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Integer> {
    @Query(value="select distinct o.operationName from Operation o ")
    Iterable<Operation> getListOperation();
}
