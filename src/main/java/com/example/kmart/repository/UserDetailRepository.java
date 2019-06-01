package com.example.kmart.repository;

import com.example.kmart.entity.UserDetail;
import com.example.kmart.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    List<UserDetail> getUserDetailByRoleAndTripDetail_RequestAtBetweenAndBanned(Role role, Date startDate, Date endDate, String banned);

}
