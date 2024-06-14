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
@RequestMapping("/consumer")
public class orderConrtroller {

    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";



    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }
}
