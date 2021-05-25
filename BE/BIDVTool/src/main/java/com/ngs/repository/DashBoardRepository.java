package com.ngs.repository;

import java.util.List;
import java.util.Map;

public interface DashBoardRepository {
    List<Map<Object, Object>> getTotalApp();

    List<Map<Object, Object>> getTotalOperationByStatus(Integer serviceId, Integer appId);
}







