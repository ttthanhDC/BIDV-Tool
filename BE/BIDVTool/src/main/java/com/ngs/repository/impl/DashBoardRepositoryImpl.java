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
@Transactional
public class DashBoardRepositoryImpl implements DashBoardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<Object, Object>> getTotalApp() {
        List<Map<Object, Object>> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalApp");
        Map<String, Object> callResponse = jdbcCall.execute();
        resultList = buildResult(resultList, callResponse);
        return resultList;
    }
    @Override
    public  List<Map<Object,Object>> getTotalAppByService(){
        List<Map<Object,Object>> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalAppsByServices");
        Map<String,Object> callResponse  = jdbcCall.execute();
        resultList = buildResult(resultList,callResponse);
        return resultList;
    }

    @Override
    public List<Map<Object, Object>> getTotalOperationByStatus(Integer serviceId, Integer appId) {
        List<Map<Object, Object>> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalOperationByStatus");
        Map<String, Object> inputParams = new HashMap<>();
        inputParams.put("p_serviceId", serviceId);
        inputParams.put("p_appId", appId);
        Map<String, Object> callResponse = jdbcCall.execute(inputParams);
        resultList = buildResult(resultList, callResponse);
        return resultList;
    }

    private List<Map<Object, Object>> buildResult(List<Map<Object, Object>> resultList, Map<String, Object> callResponse) {
        ArrayList<Map> resultSet = (ArrayList<Map>) callResponse.get("#result-set-1");
        resultSet.forEach(data -> {
            data.keySet().forEach(key -> {
                Map result = new HashMap();
                result.put("label", key);
                result.put("value", data.get(key));
                resultList.add(result);
            });
        });
        return resultList;
    }

}
