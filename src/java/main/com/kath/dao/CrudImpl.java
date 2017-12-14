package com.kath.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.kath.model.Member;
/**
 * Initializes CRUD methods
 * @author KitKat
 * @since 0.1
 */

//@Component("MemberDao") - This also correct
@Repository
public class CrudImpl implements MemberDao{

	NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Template with a basic set of JDBC operations, allowing the use of named parameters rather than traditional '?' placeholders.
	 * @param jdbcTemplate
	 */
	@Autowired
	public void setDataSource(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}

	/**
	 * Creates a new member in member table
	 * @param member
	 */
	@Override
	public void create(Member member) {
		String sqlQuery = "INSERT INTO member(name, lname, adress, city, username) values(:name, :lname, :adress, :city, :username)";
		jdbcTemplate.update(sqlQuery,  getSqlParameterByModel(member));
	}
	
	
	/**
	 * Retrieve a specific member by id
	 * @param id
	 * @return
	 */
	@Override
	public Member getMemberById(int id) {
		String sqlQuery = "SELECT * FROM member WHERE id= :id";
		return jdbcTemplate.queryForObject(sqlQuery, getSqlParameterByModel(new Member(id)), new MemberRowMapper());
	}

	
	/**
	 * Lists all the members in member table
	 * @return
	 */
	@Override
	public List<Member> getAllMembers() {
		String sqlQuery = "SELECT * FROM member";
		List<Member> members = jdbcTemplate.query(sqlQuery, new MemberRowMapper());
		return members;
	}

	/**
	 * Delete a specific member from table
	 * @param id
	 */
	@Override
	public void delete(int id) {
		String sqlQuery = "DELETE FROM member WHERE id= :id";
		jdbcTemplate.update(sqlQuery, getSqlParameterByModel(new Member(id)));
	}

	
	/**
	 * Updates information of a specifies member in database
	 * @param member
	 */
	@Override
	public void update(Member member) {
		String sqlQuery = "UPDATE member SET name = :name, lname = :lname, "
				+ "adress= :adress, city=:city, username= :username WHERE id = :id";
		jdbcTemplate.update(sqlQuery, getSqlParameterByModel(member));
	}

	/**
	 * Interface that defines common functionality for member tables named SQL parameters, 
	 * serving as argument for NamedParameterJdbcTemplate operation (jdbcTemplate).
	 * @param member
	 * @return
	 */
	private SqlParameterSource getSqlParameterByModel(Member member) {
		MapSqlParameterSource sqlSource = new MapSqlParameterSource();
		if(member != null) {
			sqlSource.addValue("id", member.getId());
			sqlSource.addValue("name", member.getName());
			sqlSource.addValue("lname", member.getlName());
			sqlSource.addValue("adress", member.getAdress());
			sqlSource.addValue("city", member.getCity());
			sqlSource.addValue("username", member.getUserName());
		}
		
		return sqlSource;
	}

}
