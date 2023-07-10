package com.leftb.member;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

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

	@Test
	@DisplayName("특정 단어가 포함된 이름 검색")
	public void searchKeyName() {
		List<Member> memberlist = memberRepository.findByMnameLike("%이%");
		for(Member member : memberlist) {
			System.out.println(member.toString());
		}
	}

	@Test
	@DisplayName("회원 정보 수정")
	public void modifyMember() {
		Optional<Member> memberOptional = memberRepository.findById(14L);
		assertTrue(memberOptional.isPresent());

		Member member = memberOptional.get();
		member.setMname("호돌이");
		member.setMage(35);
		memberRepository.save(member);
		
	}
}
