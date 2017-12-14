package com.kath.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kath.dao.MemberDao;
import com.kath.model.Member;

/**
 *  This class is informs the spring component-scanning mechanism to load the service class (MemberService)
 *
 * @author KitKat
 *
 */
@Service
public class MemberServiceImpl implements MemberService{

	MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/**
	 * creates a member
	 */
	@Override
	public void create(Member member) {
		memberDao.create(member);	
	}


	/**
	 * gets a specific member
	 */
	@Override
	public Member getMemberById(int id) {
		return memberDao.getMemberById(id);
	}

	/**
	 * Lists all members
	 */
	@Override
	public List<Member> getAllMembers() {
		return memberDao.getAllMembers();
	}

	/**
	 * deletes a member
	 */
	@Override
	public void delete(int id) {
	   memberDao.delete(id);
	}

	/**
	 * updates a member
	 */
	@Override
	public void update(Member member) {
		memberDao.update(member);
	}

}
