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

		List<Member> list = memberService.memberList();
		model.addAttribute("memberlist", list);

		return "member_list";
	}

	@RequestMapping(value="/searchForm")
	public String searchForm(Model model) {

		return "search_form";
	}

	@RequestMapping(value="/search_member")
	public String search(HttpServletRequest request, Model model) {

		List<Member> list = memberService.searchName(request.getParameter("searchName"));
		model.addAttribute("memberlist", list);

		return "search_member";
	}
}
