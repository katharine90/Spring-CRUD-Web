package com.kath.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kath.model.Member;
/**
 * RowMapper is a interface that is used by the JdbcTemplate for mapping rows of a ResultSet on a per-row basis.
 * SQLExceptions will be caught and handled by the calling JdbcTemplate implemented in the CrudImpl class.
 * @author KitKat
 * @since 0.1
 */
public class MemberRowMapper implements RowMapper<Member>{
	
/**
 *  mapRow contains the attributes in the member table
 */
	public Member mapRow(ResultSet rs, int rowNr) throws SQLException {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setlName(rs.getString("lname"));
		member.setAdress(rs.getString("adress"));
		member.setCity(rs.getString("city"));
		member.setUserName(rs.getString("username"));
		
		return member;
	}
	
}
