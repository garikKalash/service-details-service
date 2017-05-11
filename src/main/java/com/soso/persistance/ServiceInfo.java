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
            "http://soso-client.herokuapp.com/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://ec2-54-75-231-195.eu-west-1.compute.amazonaws.com:5432/d3kb9mi1sut2m8?sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&username=cauzadlefscrvv&characterEncoding=UTF-8&useUnicode=yes",
                    "cauzadlefscrvv",
                    "0463f0060b75d880792005e16b9d9a03f85c44cf84b0cac4d503d4b571f933b5"),
            "soso_client_service"),

    SOSO_PARTNER_SERVICE(2,
            "https://soso-partner.herokuapp.com/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://ec2-54-247-99-159.eu-west-1.compute.amazonaws.com:5432/dlu28gghspr52?sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                    "iwrfrdlugrxtfd",
                    "568e49d657f1e72020222cbc9637dce8e8545a4583afd82a398d415271ab7532"),
            "soso_partner_service"),

    AUTHENTICATION_SERVICE(3,
            "http://soso-authentication-service.herokuapp.com/",
            null,
            "authentication_service"),

    COMMON_DATA_SERVICE(4,
            "http://soso-common-data.herokuapp.com/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://ec2-79-125-2-69.eu-west-1.compute.amazonaws.com:5432/d5hactgbkc8b7g?sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                    "syngcfcvrdxvjf",
                    "8333e72219c36b1597c4a30f4e8ce952ee175a115aac6ad436fa8345a677193e"),
            "soso_common_data_service"),

    SERVICES_DETAIL_SERVICE(5,
            "http://localhost:9011/",
            null,
            "soso_services_detail_service"),
    SOSO_EVENT_LISTENER_SERVICE(6,
            "http://soso-event-service.herokuapp.com/",
            new DBConnectionMetaData("org.postgresql.Driver",
                    "jdbc:postgresql://ec2-54-247-119-245.eu-west-1.compute.amazonaws.com:5432/d1uujjga8psd6q?username=ejhlnozhlshmok&sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
                    "ejhlnozhlshmok",
                    "123036f31e292231dcb8486b91c6b83ab9f2e04fdb48d19eada760f3f156f0f4"),
            "soso_event_listener_service");


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
    private final String serviceUniqueName;
    private final DBConnectionMetaData dbConnectionMetaData;
}
