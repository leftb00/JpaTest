package com.leftb.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leftb.member.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {

	public List<Member> findByMname(String mname);
}
