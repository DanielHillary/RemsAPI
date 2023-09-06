package com.jovine.rems.service;

import com.jovine.rems.entity.Pojo.Payment;
import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public ResponseEntity<StandardResponse> createPaymentRegistryForTenant(Payment payment) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", paymentRepository.save(payment));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "There was an error creating payment");
        }
    }

    public ResponseEntity<StandardResponse> getAllPayments(){
        try {
            List<Payment> payments = paymentRepository.findAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all payments");
        }
    }

    public ResponseEntity<StandardResponse> getAllPaymentsByTenant(String id){
        try {
            List<Payment> payments = paymentRepository.findByTenantId(id);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all payments");
        }
    }

    public ResponseEntity<StandardResponse> updatePayment(Payment payment){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", paymentRepository.save(payment));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "There was an error creating payment");
        }
    }
}
