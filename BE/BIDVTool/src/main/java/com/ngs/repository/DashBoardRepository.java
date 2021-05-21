package com.ngs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DashBoardRepository {

    @Query(value = "select s.service_name, " +
            "(select count(*) from service  where status = 'S')/count(*) as success_percent " +
            "from service s ", nativeQuery = true)
    List<Map<String, Double>> successServices();
}
