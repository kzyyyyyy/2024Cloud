package com.zero.springcloud.service.impl;

import com.zero.springcloud.dao.PaymentDao;
import com.zero.springcloud.entities.Payment;
import com.zero.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        int result = paymentDao.create(payment);
        return result;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
