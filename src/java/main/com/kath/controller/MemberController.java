package com.kath.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kath.model.Member;
import com.kath.service.MemberService;
/**
 * This class interprets user input and transforms such input into a sensible model which will be represented to the user by the view.
 * @author KitKat
 * @since 0.1
 */
@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	/**
	 * Sets the http path to: member/list
	 * Returns allt members from the databse. 
	 * List the respons in the member:page.jsp
	 * @return
	 */
	@RequestMapping(value="list", method= RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("member/member_page");
		List<Member> list = memberService.getAllMembers();
		model.addObject("listMember", list);
		
		return model;
	}
	
	/**
	 * Sets the http path to: member/add
	 * Adds members to database using a form located in the member_form.jsp
	 * @return
	 */
	@RequestMapping(value="add", method= RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("member/member_form");
		
		Member member = new Member();
		model.addObject("memberForm", member);
		
		return model;
	}

	/**
	 * Sets the http path to: member/add
	 * List info of a specific member in a form
	 * @return
	 */
	@RequestMapping(value="update/{id}", method= RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		
		ModelAndView model = new ModelAndView("member/member_form");	
		Member member = memberService.getMemberById(id);
		model.addObject("memberForm", member);
		
		return model;
	}
	
	/**
	 * Updates members data using a form located in the member_form.jsp
	 * @return
	 */
	@RequestMapping(value="save", method= RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("memberForm") Member member) {	
		
		if (member != null && member.getId() != null) {
			memberService.update(member);
		} else {
            memberService.create(member);
		}		
		return new ModelAndView("redirect:/member/list");
	}

	/**
	 * Deletes a member
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete/{id}", method= RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {		
	
		memberService.delete(id);	
		return new ModelAndView("redirect:/member/list");
	}
	
}
