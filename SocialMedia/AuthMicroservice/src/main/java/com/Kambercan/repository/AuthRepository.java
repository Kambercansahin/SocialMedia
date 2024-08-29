package com.Kambercan.repository;

import com.Kambercan.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthRepository extends MyGenericRepo<Auth,Long> {
    Boolean existsByUserNameAndPassword(String userName, String password);
}
