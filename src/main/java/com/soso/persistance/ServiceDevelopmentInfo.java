package com.soso.persistance;

import com.soso.persistance.exceptions.ServiceNotFoundException;
import com.soso.utilities.DBConnectionMetaData;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Garik Kalashyan on 5/13/2017.
 */
public enum ServiceDevelopmentInfo implements Serializable {
    SOSO_CLIENT_SERVICE(1,
            "http://localhost:8080/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://ec2-54-75-248-193.eu-west-1.compute.amazonaws.com:5432/duq6guss7p05a?username=dzwzotaggvntdr&sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                    "dzwzotaggvntdr",
                    "345778774163bd849ae265582f47dda5141b639d516e2261631c1d4f58977754"),
            "soso_client_service"),
    SOSO_PARTNER_SERVICE(2,
            "http://localhost:8081/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://ec2-54-247-124-9.eu-west-1.compute.amazonaws.com/deros2lhhrsdig?username=qfwqixcffprnwa&sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                    "qfwqixcffprnwa",
                    "beba59b4165d07a6889a33687d8698bf92838fa20e993ce213690c4e462d37cb"),
            "soso_partner_service"),

    AUTHENTICATION_SERVICE(3,
            "http://localhost:8002/",
            null,
            "authentication_service"),

    COMMON_DATA_SERVICE(4,
            "http://localhost:8001/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://ec2-54-75-248-193.eu-west-1.compute.amazonaws.com/d7qa5oi0ajind8?username=ojjhzxiijfkiod&sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                    "ojjhzxiijfkiod",
                    "5541e39b0753333da836b4fd344ab70484ff625c777671a5c7ac3a531a8f544b"),
            "soso_common_data_service"),

    SERVICES_DETAIL_SERVICE(5,
            "http://localhost:9011/",
            null,
            "soso_services_detail_service"),
    SOSO_EVENT_LISTENER_SERVICE(6,
            "http://localhost:3000/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://ec2-176-34-242-58.eu-west-1.compute.amazonaws.com/de7dmo3hq3f5es?username=fyopuwvotsgxlf&sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                    "fyopuwvotsgxlf",
                    "9cf5052addf3821b564d5c79f63a9f1dfba678db44fc22afbc3fc8102adef5a7"),
            "soso_event_listener_service");

    private static Map<Integer, ServiceDevelopmentInfo> serviceInfoMap = new HashMap<>();

    static {
        for (ServiceDevelopmentInfo serviceDevelopmentInfo : values()) {
            serviceInfoMap.put(serviceDevelopmentInfo.getServiceId(), serviceDevelopmentInfo);
        }
    }

    private final Integer serviceId;
    private final String serviceUrl;
    private final String serviceUniqueName;
    private final DBConnectionMetaData dbConnectionMetaData;

    ServiceDevelopmentInfo(Integer serviceId, String serviceUrl, DBConnectionMetaData dbConnectionMetaData, String serviceUniqueName) {
        this.serviceId = serviceId;
        this.serviceUrl = serviceUrl;
        this.dbConnectionMetaData = dbConnectionMetaData;
        this.serviceUniqueName = serviceUniqueName;
    }

    public static ServiceDevelopmentInfo getServiceDevInfoById(Integer serviceId) {
        if (serviceInfoMap.get(serviceId) != null) {
            return serviceInfoMap.get(serviceId);
        }
        throw new ServiceNotFoundException(ServiceProductionInfo.class, "The requested Enum property Not Found with id: " + serviceId);
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
}
