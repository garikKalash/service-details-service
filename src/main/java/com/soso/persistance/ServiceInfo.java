package com.soso.persistance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.SerializedName;
import com.soso.persistance.exceptions.ServiceNotFoundException;
import com.soso.utilities.DBConnectionMetaData;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Garik Kalashyan on 3/9/2017.
 */
public enum ServiceInfo implements Serializable {
    SOSO_CLIENT_SERVICE(1,
            "http://localhost:8000/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://localhost:5432/soso-client-service-db",
                    "postgres",
                    "0944477522gar"),
            "soso_client_service"),

    SOSO_PARTNER_SERVICE(2,
            "http://localhost:8081/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://localhost:5432/soso-partner-service-db",
                    "postgres",
                    "0944477522gar"),
            "soso_partner_service"),

    AUTHENTICATION_SERVICE(3,
            "http://localhost:8002/",
            null,
            "authentication_service"),

    COMMON_DATA_SERVICE(4,
            "http://localhost:8001/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://localhost:5432/soso-common-data-service-db",
                    "postgres",
                    "0944477522gar"),
            "soso_common_data_service"),

    SERVICES_DETAIL_SERVICE(5,
            "http://localhost:9011/",
            null,
            "soso_services_detail_service");


    ServiceInfo(Integer serviceId, String serviceUrl, DBConnectionMetaData dbConnectionMetaData, String serviceUniqueName) {
        this.serviceId = serviceId;
        this.serviceUrl = serviceUrl;
        this.dbConnectionMetaData = dbConnectionMetaData;
        this.serviceUniqueName = serviceUniqueName;
    }


    private static Map<Integer, ServiceInfo> serviceInfoMap = new HashMap<>();

    static {
        for (ServiceInfo serviceInfo : values()) {
            serviceInfoMap.put(serviceInfo.getServiceId(), serviceInfo);
        }
    }

    public static ServiceInfo getServiceInfoById(Integer serviceId) {
        if (serviceInfoMap.get(serviceId) != null) {
            return serviceInfoMap.get(serviceId);
        }
        throw new ServiceNotFoundException(ServiceInfo.class, "The requested Enum property Not Found with id: " + serviceId);
    }


    public Integer getServiceId() {
        return serviceId;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public DBConnectionMetaData getDbConnectionMetaData() {
        return dbConnectionMetaData;
    }

    public String getServiceUniqueName() {
        return serviceUniqueName;
    }

    private final Integer serviceId;
    private final String serviceUrl;
    private final DBConnectionMetaData dbConnectionMetaData;
    private final String serviceUniqueName;
}