package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.MemeberRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private MemeberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemeberRepository memeberRepository) {
        this.memberRepository = memeberRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(String theId) {
        Optional<Member> result = memberRepository.findById(theId);

        Member theMember = null;

        if (result.isPresent()){
            theMember = result.get();
        }else {
            throw new RuntimeException("Did not find member id - " + theId);
        }

        return theMember;
    }

    @Override
    public Member save(Member theMember) {

        if(findById(theMember.getUserId()) != null){
            throw new RuntimeException("There is already a member with this id");
        }

        return memberRepository.save(theMember);
    }

    @Override
    public Member update(Member theMember) {
        return memberRepository.save(theMember);
    }

    @Override
    public String deleteById(String theId) {

        Member tempMember = findById(theId);

        // throw exception if null

        if (tempMember == null) {
            throw new RuntimeException("Member id not found - " + theId);
        }
        memberRepository.deleteById(theId);

        return "Deleted member id - " + theId;
    }
}