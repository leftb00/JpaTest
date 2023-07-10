package com.leftb.member.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leftb.member.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {

	public List<Member> findAllByOrderByMnumDesc();
	public List<Member> findByMname(String mname);
	public List<Member> findByMnameOrderByMnumDesc(String mname);
	public List<Member> findByMidAndMpw(String mid, String mpw);

	public List<Member> findByMageLessThan(int mage);
	public List<Member> findByMageLessThanEqual(int mage);
	public List<Member> findByMageGreaterThan(int mage);
	public List<Member> findByMageGreaterThanEqual(int mage);
	public List<Member> findByMageBetween(int mage1, int mage2);

	public List<Member> findByMnameStartingWith(String mname);
	public List<Member> findByMnameEndingWith(String mname);
	public List<Member> findByMnameContaining(String mname);
	public List<Member> findByMnameLike(String mname);

	@Transactional
	public void deleteAllByMname(String mname);
}
