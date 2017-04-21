package com.soso.services;

import com.soso.persistance.ServiceInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Garik Kalashyan on 3/8/2017.
 */
public class JsonMapBuilder {
    private static Map<String, Object> map = new HashMap<>();

    public JsonMapBuilder() {
    }

    public JsonMapBuilder add(String key, ServiceInfo serviceInfo) {
        map.put(key, getServiceDataAsMap(serviceInfo));
        return this;
    }

    public JsonMapBuilder add(String key, ServiceInfo[] serviceInfos) {
        Map<String, Object> services = new HashMap<>();
        for (ServiceInfo serviceInfo : serviceInfos) {
            services.put(serviceInfo.toString(), getServiceDataAsMap(serviceInfo));
        }
        map.put(key, serviceInfos);
        return this;
    }

    private Map<String, Object> getServiceDataAsMap(ServiceInfo serviceInfo) {
        Map<String, Object> serviceNode = new HashMap<>();
        serviceNode.put("url", serviceInfo.getServiceUrl());
        serviceNode.put("serviceUniqueName", serviceInfo.getServiceUniqueName());
        serviceNode.put("dbConnectionMetaData", serviceInfo.getDbConnectionMetaData());
        serviceNode.put("serviceId", serviceInfo.getServiceId());

        return serviceNode;
    }

    public Map<String, Object> build() {
        return map;
    }
}
