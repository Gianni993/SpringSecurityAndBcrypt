package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Member;
import com.luv2code.springboot.cruddemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberRestController {

    private MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @GetMapping("/member/{theId}")
    public Member findById(@PathVariable String theId){
        return memberService.findById(theId);
    }

    @PostMapping("/member")
    public Member addMember(@RequestBody Member theMember){
        return memberService.save(theMember);
    }

    @PutMapping("/member")
    public Member update(@RequestBody Member theMember){

        return memberService.update(theMember);
    }

    @DeleteMapping("/member/{memberId}")
    public String deleteMember(@PathVariable String memberId){

        return memberService.deleteById(memberId);
    }
}
