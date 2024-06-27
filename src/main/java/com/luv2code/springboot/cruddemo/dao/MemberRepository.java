package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,String> {

    @Transactional
    @Modifying
    @Query(value = "insert into members (user_id, pw, active) values (:id, :psw, :active)" , nativeQuery = true)
    void save(@Param("id") String id, @Param("psw") String psw, @Param("active") boolean active);
}
