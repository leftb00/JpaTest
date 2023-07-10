package com.leftb.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leftb.member.entity.Member;
import com.leftb.member.service.MemberService;


@Controller
public class HomeController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value={"/", "/memberList"})
	public String memberList(Model model) {

		model.addAttribute("memberlist", memberService.memberList());

		return "member_list";
	}

	@RequestMapping(value="/joinForm")
	public String joinForm() {

		return "join_form";
	}

	@RequestMapping(value="/join")
	public String join(HttpServletRequest request, Model model) {

		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mage = request.getParameter("mage");
		memberService.joinMember(mid, mpw, mname, mage);

		return "redirect:memberList";
	}

	@RequestMapping(value="/searchForm")
	public String searchForm() {

		return "search_form";
	}

	@RequestMapping(value="/search_member")
	public String search(HttpServletRequest request, Model model) {

		List<Member> list = memberService.searchName(request.getParameter("searchName"));
		model.addAttribute("memberlist", list);

		return "search_member";
	}
}
