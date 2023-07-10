package com.leftb.member;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.leftb.member.entity.Member;
import com.leftb.member.repository.MemberRepository;


@SpringBootTest
@TestPropertySource(locations="classpath:application-test.yml")
public class JpaTest {

	@Autowired
	MemberRepository memberRepository;

	@Test
	@DisplayName("회원 탈퇴(삭제) 테스트")
	public void deleteMember() {
		memberRepository.deleteById(2L);
	}

	@Test
	@DisplayName("회원 리스트 불러오기 테스트")
	public void memberList() {
		List<Member> memberlist = memberRepository.findAll();

		for(Member member : memberlist) {
			System.out.println(member.toString());
		}
	}

	@Test
	@DisplayName("회원 이름 검색")
	public void searchName() {
		List<Member> memberlist = memberRepository.findByMname("홍길동");
		for(Member member : memberlist) {
			System.out.println(member.toString());
		}
	}

	@Test
	@DisplayName("회원 가입 테스트")
	public void joinMember() {
		Member member = new Member();
		member.setMid("cat");
		member.setMpw("cat");
		member.setMname("고양이");
		member.setMage(12);
		memberRepository.save(member);
	}
}
