package com.zero.springcloud.controller;

import com.zero.springcloud.entities.CommonResult;
import com.zero.springcloud.entities.Payment;
import com.zero.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String ServicePort;

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        if (result > 0){
            return CommonResult.success(result,"插入成功,serverPort:"+ServicePort);
        } else {
            return  CommonResult.failed("插入失败");
        }
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);

        if (paymentById != null){
            return CommonResult.success(paymentById,"查询成功,serverPort:"+ServicePort);
        } else {
            return CommonResult.failed("查询失败");
        }
    }
}
