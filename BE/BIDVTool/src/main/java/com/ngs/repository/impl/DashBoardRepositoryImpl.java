package com.ngs.repository.impl;

import com.ngs.repository.DashBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DashBoardRepositoryImpl implements DashBoardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public List<Map<Object, Object>> getTotalApp() {
        List<Map<Object, Object>> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalApp");
        resultList = buildResult(resultList, jdbcCall);
        return resultList;
    }

    private List<Map<Object, Object>> buildResult(List<Map<Object, Object>> resultList, SimpleJdbcCall jdbcCall) {
        Map<String, Object> callResponse = jdbcCall.execute();
        ArrayList<Map> resultSet = (ArrayList<Map>) callResponse.get("#result-set-1");
        Map data = resultSet.get(0);
        data.keySet().forEach(key -> {
            Map result = new HashMap();
            result.put("label", key);
            result.put("value", data.get(key));
            resultList.add(result);
        });
        return resultList;
    }
}
