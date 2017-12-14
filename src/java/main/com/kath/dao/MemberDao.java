package com.kath.dao;

import java.util.List;

import javax.sql.DataSource;

import com.kath.model.Member;
/**
 * CRUD interface (Data access object) 
 * @author KitKat
 * @since 0.1
 */
public interface MemberDao {

	/**
	 * Creates a new member in member table
	 * @param member
	 */
	public void create(Member member);
	
	/**
	 * Retrieves a specific member by id
	 * @param id
	 * @return
	 */
	public Member getMemberById(int id);
	
	/**
	 * Lists all the members in member table
	 * @return
	 */
	public List<Member> getAllMembers();
	
	/**
	 * Deletes a specific member from table
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * Updates information of a specifies member in database
	 * @param member
	 */
	public void update(Member member);
}
