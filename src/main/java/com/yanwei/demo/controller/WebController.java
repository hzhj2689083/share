package com.yanwei.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.yanwei.demo.model.Company;
import com.yanwei.demo.utils.WebUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {


    @GetMapping("/test/get")
    public Object test() {
        String url = "http://10.10.90.85:9090/api/basis/alarm/get/device/1";
        String get = "";
        try {

            get = WebUtils.doHttpGet(url, String.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return get;
    }


    @GetMapping("/test/post")
    public Object test2(){
        String url = "http://10.10.90.85:9090/api/basis/alarm/get";
        Company company = new Company("entnameExample","unidExample","regnoExample","pripidExample");
        JSONObject jsonObject = null;
        try {

            jsonObject = WebUtils.doHttpProd(url, company, JSONObject.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }


}
