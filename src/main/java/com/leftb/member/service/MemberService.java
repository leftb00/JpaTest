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

		return memberRepository.findAllByOrderByMnumDesc();
	}

	public List<Member> searchName(String mname) {

		return memberRepository.findByMname(mname);
	}

	public void joinMember(String mid, String mpw, String mname, String mage) {

		Member member = new Member();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMage(Integer.parseInt(mage));
		memberRepository.save(member);
	}
}
