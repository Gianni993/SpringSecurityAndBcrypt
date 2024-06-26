package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeberRepository extends JpaRepository<Member,String> {
}
