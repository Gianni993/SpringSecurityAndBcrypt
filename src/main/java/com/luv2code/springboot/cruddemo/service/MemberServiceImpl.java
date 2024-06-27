package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.MemberRepository;

import com.luv2code.springboot.cruddemo.entity.Member;
import com.luv2code.springboot.cruddemo.security.Bcrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private Bcrypt bcrypt;

    @Autowired
    public MemberServiceImpl(Bcrypt bcrypt , MemberRepository memberRepository) {
        this.bcrypt = bcrypt;
        this.memberRepository = memberRepository;
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


        theMember.setPw(bcrypt.encodePsw(theMember.getPw()));
        System.out.println(theMember.getPw());
        memberRepository.save(theMember.getUserId(),theMember.getPw(),theMember.isActive());
        return findById(theMember.getUserId());
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