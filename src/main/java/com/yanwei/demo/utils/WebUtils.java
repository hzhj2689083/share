package com.yanwei.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class WebUtils {
    private static Logger logger = LoggerFactory.getLogger(WebUtils.class);

    private static RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        WebUtils.restTemplate = restTemplate;
    }


    /**
     * @param URL  请求URL
     * @param t     返回值类型.class
     * @param <T>   返回值类型
     * @return
     * @throws Exception
     */
    public static <T> T doHttpGet(String URL, Class<T> t) throws Exception {
        logger.info("发起GET请求：" + URL);
        try {

        return restTemplate.getForObject(URL, t);
        }catch (Exception e){
            logger.info("数据中心接口请求异常！");
            e.printStackTrace();
            throw new Exception(e);
        }

    }


    /**
     * @param URL  请求URL
     * @param parameter  请求参数体
     * @param t  返回值类型.class
     * @param <T>  返回值类型
     * @return
     * @throws Exception
     */
    public static <T> T doHttpProd(String URL, Object parameter, Class<T> t) throws Exception {
        logger.info("发起POST请求：" + URL);

        try {
            return restTemplate.postForObject(URL, parameter, t);
        } catch (Exception e) {
            logger.info("数据中心接口请求异常！");
            e.printStackTrace();
            throw new Exception(e);

        }
    }


}
