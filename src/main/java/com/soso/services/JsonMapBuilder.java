package com.soso.services;

import com.soso.persistance.ServiceDevelopmentInfo;
import com.soso.persistance.ServiceProductionInfo;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Garik Kalashyan on 3/8/2017.
 */
public class JsonMapBuilder {
    private static Map<String, Object> map = new HashMap<>();

    public JsonMapBuilder add(String key, ServiceProductionInfo serviceProductionInfo) {
        map.put(key, getServiceDataAsMap(serviceProductionInfo));
        return this;
    }


    public JsonMapBuilder add(String key, ServiceDevelopmentInfo serviceDevelopmentInfo) {
        map.put(key, getServiceDataAsMap(serviceDevelopmentInfo));
        return this;
    }

    public JsonMapBuilder add(String key, ServiceProductionInfo[] serviceProductionInfos) {
        Map<String, Object> services = new HashMap<>();
        for (ServiceProductionInfo serviceProductionInfo : serviceProductionInfos) {
            services.put(serviceProductionInfo.toString(), getServiceDataAsMap(serviceProductionInfo));
        }
        map.put(key, serviceProductionInfos);
        return this;
    }

    private Map<String, Object> getServiceDataAsMap(ServiceProductionInfo serviceProductionInfo) {
        Map<String, Object> serviceNode = new HashMap<>();
        serviceNode.put("url", serviceProductionInfo.getServiceUrl());
        serviceNode.put("serviceUniqueName", serviceProductionInfo.getServiceUniqueName());
        serviceNode.put("dbConnectionMetaData", serviceProductionInfo.getDbConnectionMetaData());
        serviceNode.put("serviceId", serviceProductionInfo.getServiceId());

        return serviceNode;
    }

    private Map<String, Object> getServiceDataAsMap(ServiceDevelopmentInfo serviceDevelopmentInfo) {
        Map<String, Object> serviceDeevNode = new HashMap<>();
        serviceDeevNode.put("url", serviceDevelopmentInfo.getServiceUrl());
        serviceDeevNode.put("serviceUniqueName", serviceDevelopmentInfo.getServiceUniqueName());
        serviceDeevNode.put("dbConnectionMetaData", serviceDevelopmentInfo.getDbConnectionMetaData());
        serviceDeevNode.put("serviceId", serviceDevelopmentInfo.getServiceId());

        return serviceDeevNode;
    }


    public Map<String, Object> build() {
        return map;
    }
}
