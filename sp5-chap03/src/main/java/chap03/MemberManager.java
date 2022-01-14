package chap03;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.util.List;


import javax.sql.DataSource;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class MemberManager {

	private JdbcTemplate jdbcTemplate;
	
	public MemberManager(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member SelectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from  MEMBER where EMAIL = ?",
				new MemberRowMapper(),
				email);
		
		return results.isEmpty() ? null : results.get(0);
		
	}
	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) " +
						"values (?,?,?,?)",
						new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
		}, keyHolder);
		Number keyValue= keyHolder.getKey();
		member.setId(keyValue.longValue());
		
		
	}
	public void update(Member member) {
		jdbcTemplate.update(
				"update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
				member.getName(), member.getPassword(), member.getEmail());
		
	}
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
				"select * from  MEMBER",
				new MemberRowMapper());
		
		return results;
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}
}
