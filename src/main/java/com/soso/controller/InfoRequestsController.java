package com.soso.controller;

import com.soso.persistance.ServiceInfo;
import com.soso.services.JsonConverter;
import com.soso.services.JsonMapBuilder;
import org.springframework.http.MediaType;
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
    @RequestMapping(value = "/{serviceId}", method = RequestMethod.GET)
    @ResponseBody
    public void getServiceDetail(@PathVariable("serviceId") Integer serviceId, HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonConverter.toJson(new JsonMapBuilder()
                .add("serviceDetail", ServiceInfo.getServiceInfoById(serviceId))
                .build()));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public void getAllServiceDetail(HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonConverter.toJson(new JsonMapBuilder()
                .add("serviceDetail", ServiceInfo.values())
                .build()));
    }
}
