package com.zero.springcloud.controller;


import com.zero.springcloud.entities.CommonResult;
import com.zero.springcloud.entities.Payment;
import com.zero.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/paymenet")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult creat(Payment payment){
        int result = paymentService.create(payment);

        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(444,"插入失败");
        }

    }
    @GetMapping(value = "/getPaymentById")
    public CommonResult getPaymentById(Long id){
        Payment paymentById = paymentService.getPaymentById(id);

        if (paymentById != null){
            return new CommonResult(200,"查询成功",paymentById);
        }else {
            return new CommonResult(444,"查询失败");
        }

    }

}
