package com.kath.service;

import java.util.List;

import com.kath.model.Member;

/**
 * Service interface for MemberServiceIml class
 * @author KitKat
 *
 */
public interface MemberService {

	public void create(Member member);
	public Member getMemberById(int id);
	public List<Member> getAllMembers();
	public void delete(int id);
	public void update(Member member);
}
