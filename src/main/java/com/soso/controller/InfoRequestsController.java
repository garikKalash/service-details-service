package com.soso.controller;

import com.soso.persistance.ServiceDevelopmentInfo;
import com.soso.persistance.ServiceProductionInfo;
import com.soso.services.JsonConverter;
import com.soso.services.JsonMapBuilder;
import com.soso.services.ModeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Garik Kalashyan on 3/9/2017.
 */

@CrossOrigin("*")
@Controller
@RequestMapping("serviceDetails")
public class InfoRequestsController {
    @Autowired
    private ModeResolver modeResolver;


    @RequestMapping(value = "/{serviceId}", method = RequestMethod.GET)
    @ResponseBody
    public void getServiceDetail(@PathVariable("serviceId") Integer serviceId, HttpServletResponse response) throws IOException {
        JsonMapBuilder jsonMapBuilder = new JsonMapBuilder();
        boolean isProduction = modeResolver.getMode().equals("PRODUCTION");
        if (isProduction) {
            jsonMapBuilder.add("serviceDetail", ServiceProductionInfo.getServiceInfoById(serviceId));
        } else {
            jsonMapBuilder.add("serviceDetail", ServiceDevelopmentInfo.getServiceDevInfoById(serviceId));
        }
        response.getWriter().write(JsonConverter.toJson(jsonMapBuilder.build()));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public void getAllServiceDetail(HttpServletResponse response) throws IOException {
        JsonMapBuilder jsonMapBuilder = new JsonMapBuilder();
        boolean isProduction = modeResolver.getMode().equals("PRODUCTION");
        if (isProduction) {
            jsonMapBuilder.add("serviceDetails", ServiceProductionInfo.values());
        } else {

        }


        response.getWriter().write(JsonConverter.toJson(jsonMapBuilder.build()));
    }
}
