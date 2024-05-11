package com.school.repository;

import com.school.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {

    Optional<Users> findByMobileNumberOrEmailId(String mobileNumber,String email);
    Optional<Users> findByMobileNumber(String mobileNumber);


}
