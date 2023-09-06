package com.jovine.rems.controller;

import com.jovine.rems.entity.Pojo.Payment;
import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/createpaymentfortenant")
    public ResponseEntity<StandardResponse> createPayment(@RequestBody Payment payment){
        return paymentService.createPaymentRegistryForTenant(payment);
    }

    @GetMapping("/getallpayments")
    public ResponseEntity<StandardResponse> getAllPayment(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/getpaymentsbytenant")
    public ResponseEntity<StandardResponse> getPaymentsByTenant(@RequestParam("tenantId") String tenantId){
        return paymentService.getAllPaymentsByTenant(tenantId);
    }

    @PutMapping("/updatepayment")
    public ResponseEntity<StandardResponse> updatePayment(@RequestBody Payment payment){
        return paymentService.updatePayment(payment);
    }
}
