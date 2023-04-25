package com.熔断;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoqi
 * @date 2020/8/9.
 */
public class UserService {

    @HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {
                    //默认 20 个;10s 内请求数大于 20 个时就启动熔断器，当请求符合熔断条件时将触发 getFallback()。
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,
                            value = "10"),
                    //请求错误率大于 50%时就熔断，然后 for 循环发起请求，当请求符合熔断条件时将触发 getFallback()。
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,
                            value = "50"),
                    //默认 5 秒;熔断多少秒后去尝试请求
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,
                            value = "5000"),
            })
    public List<Object> getUsers(Integer id) {
        System.out.println("--------->" + id);
        if (id == 1) {
            throw new RuntimeException();
        }

        return new ArrayList<>();
    }

    /**
     * 服务降级
     * 返回托底数据的方法
     *
     * @return
     */
    public List<Object> fallback(Integer id) {
        return Lists.newArrayList();
    }
}
