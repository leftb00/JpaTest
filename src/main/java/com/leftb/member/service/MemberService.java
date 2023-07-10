package com.leftb.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leftb.member.entity.Member;
import com.leftb.member.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	public List<Member> memberList() {

		return memberRepository.findAll();
	}

	public List<Member> searchName(String mname) {

		return memberRepository.findByMname(mname);
	}
}
