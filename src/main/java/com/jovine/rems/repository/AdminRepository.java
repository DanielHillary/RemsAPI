package com.jovine.rems.repository;

import com.jovine.rems.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminUser, Long> {
    Optional<AdminUser> findByUserName(String userName);
}
