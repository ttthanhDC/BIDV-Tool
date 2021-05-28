package com.ngs.repository.impl;

import com.ngs.repository.DashBoardRepository;
import com.ngs.response.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        resultList = buildResult(resultList, callResponse, "IsInScope");
        return resultList;
    }

    @Override
    public TotalAppByService getTotalAppByService() {
        TotalAppByService totalAppByService = new TotalAppByService();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalAppsByServices");
        Map<String, Object> callResponse = jdbcCall.execute();

        ArrayList<Map> resultSet = (ArrayList<Map>) callResponse.get("#result-set-1");
        List<Data> dataset = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        List<Label> labels = new ArrayList<>();
        List<Value> values = new ArrayList<>();
        Category category = new Category();
        Data data = new Data();
        category.setCategory(labels);
        data.setData(values);
        categories.add(category);
        dataset.add(data);

        totalAppByService.setDataset(dataset);
        totalAppByService.setCategories(categories);
        resultSet.forEach(map -> {
            map.keySet().forEach(key -> {
                String result = map.get(key).toString();
                if ("service_name".equals(key.toString())) {
                    Label label = new Label(result);
                    labels.add(label);
                } else {
                    Value value = new Value(result);
                    values.add(value);
                }
            });
        });
        return totalAppByService;
    }

    @Override
    public List<Map<Object, Object>> getTotalServiceByApp() {
        List<Map<Object, Object>> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalServicesByApps");
        Map<String, Object> callResponse = jdbcCall.execute();
        resultList = buildResult(resultList, callResponse, "application_name");
        return resultList;
    }

    @Override
    public List<Map<Object, Object>> getTotalServiceByStatus() {
        List<Map<Object, Object>> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalServicesByStatus");
        Map<String, Object> callResponse = jdbcCall.execute();
        resultList = buildResult(resultList, callResponse, "status");
        return resultList;
    }

    @Override
    public List<OperationResponse> getTotalOperationByServiceId(Integer serviceId) {
        List<OperationResponse> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getOperationsByServiceId");
        Map<String, Object> inputParams = new HashMap<>();
        inputParams.put("p_servicesId", serviceId);
        Map<String, Object> execute = jdbcCall.execute(inputParams);
        ArrayList<Map> dataMap = (ArrayList<Map>) execute.get("#result-set-1");
        dataMap.forEach(map -> {
            OperationResponse operation = OperationResponse.builder()
                    .operationId((Integer) map.get("operation_id"))
                    .applicationId((Integer) map.get("application_id"))
                    .operationName((String) map.get("operation_name"))
                    .ssdLegacy((String) map.get("ssd_legacy"))
                    .ssdSOA((String) map.get("ssd_soa"))
                    .status((String) map.get("status"))
                    .serviceName((String) map.get("service_name"))
                    .build();
            resultList.add(operation);
        });
//        resultList = jdbcCall.execute(inputParams);
        return resultList;
    }

    @Override
    public List<ServiceByApp> getServiceByAppId(Integer appid) {
        List<ServiceByApp> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getServicesbyAppId");
        Map<String, Object> inputParams = new HashMap<>();
        inputParams.put("pAppId", appid);
        Map<String, Object> execute = jdbcCall.execute(inputParams);
        ArrayList<Map> dataMap = (ArrayList<Map>) execute.get("#result-set-1");
        dataMap.forEach(map -> {
            ServiceByApp service = ServiceByApp.builder()
                    .applicationName((String) map.get("application_name"))
                    .serviceId((Integer) map.get("service_id"))
                    .serviceName((String) map.get("service_name"))
                    .status((String) map.get("status"))
                    .build();
            resultList.add(service);
        });
//        resultList = jdbcCall.execute(inputParams);
        return resultList;
    }

    @Override
    public List<Map<Object, Object>> getTotalTaskByOperation() {
        List<Map<Object, Object>> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalTaskByOperations");
        Map<String, Object> callResponse = jdbcCall.execute();
        resultList = buildResult(resultList, callResponse, "operation_name");
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
        resultList = buildResult(resultList, callResponse, "status");
        return resultList;
    }

    @Override
    public List<Map<Object, Object>> getTotalOperationByService() {
        List<Map<Object, Object>> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTotalOperationsbyServices");
        Map<String, Object> callResponse = jdbcCall.execute();
        resultList = buildResult2(resultList, callResponse, "service_name");
        return resultList;
    }

    @Override
    public List<DoingTask> getTasksDoingByOperationId(Integer operationId) {
        List<DoingTask> resultList = new ArrayList<>();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getTasksDoingByOperationId");
        Map<String, Object> inputParams = new HashMap<>();
        inputParams.put("p_operationId", operationId);
        Map<String, Object> callResponse = jdbcCall.execute(inputParams);
        System.out.println(callResponse);
        ArrayList<Map> resultSet = (ArrayList<Map>) callResponse.get("#result-set-1");
        resultSet.forEach(data -> {
            DoingTask doingTask = new DoingTask();
            data.keySet().forEach(key -> {

                doingTask.setTaskId((Integer) data.get("task_id"));
                doingTask.setTaskDescription((String) data.get("task_description"));
                doingTask.setOperationId((Integer) data.get("operation_id"));
                doingTask.setOperationName((String) data.get("operation_name"));
                doingTask.setServiceName((String) data.get("service_name"));
                doingTask.setApplicationName((String) data.get("application_name"));


            });
            resultList.add(doingTask);
        });
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

    private List<Map<Object, Object>> buildResult(List<Map<Object, Object>> resultList, Map<String, Object> callResponse, String labelCol) {
        Objects.requireNonNull(labelCol, "labelCol must be not null");
        ArrayList<Map> resultSet = (ArrayList<Map>) callResponse.get("#result-set-1");
        resultSet.forEach(data -> {
            Map result = new HashMap();
            data.keySet().forEach(key -> {
                if (labelCol.equals(key.toString())) {
                    result.put("label", data.get(key));
                } else {
                    result.put("value", data.get(key));
                }
            });
            resultList.add(result);
        });
        return resultList;
    }

    private List<Map<Object, Object>> buildResult2(List<Map<Object, Object>> resultList, Map<String, Object> callResponse, String labelCol) {
        Objects.requireNonNull(labelCol, "labelCol must be not null");
        ArrayList<Map> resultSet = (ArrayList<Map>) callResponse.get("#result-set-1");
        resultSet.forEach(data -> {
            Map result = new HashMap();
            data.keySet().forEach(key -> {
                if (labelCol.equals(key.toString())) {
                    result.put("label", data.get(key));
                } else if ("totalOperations".equals((key.toString()))) {
                    result.put("value", data.get(key));
                }
            });
            resultList.add(result);
        });
        return resultList;
    }


}
