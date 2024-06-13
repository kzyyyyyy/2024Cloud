package com.zero.springcloud.controller;

import cn.hutool.log.Log;
import com.zero.springcloud.entities.CommonResult;
import com.zero.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class orderConrtroller {

    public static final String PAYMENT_URL ="http://localhost:8001";



    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
}
