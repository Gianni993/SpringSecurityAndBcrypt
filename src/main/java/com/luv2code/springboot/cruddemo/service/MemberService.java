package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll();

    Member findById(String theId);

    Member save(Member theMember);

    Member update(Member theMember);

    String deleteById(String theId);
}
