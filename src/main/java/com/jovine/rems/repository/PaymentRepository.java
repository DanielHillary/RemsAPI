package com.jovine.rems.repository;

import com.jovine.rems.entity.Pojo.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByTenantId(String id);
}
