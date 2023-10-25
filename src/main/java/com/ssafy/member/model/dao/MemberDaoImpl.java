package com.ssafy.member.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	private final String NAMESPACE="com.ssafy.member.model.dao.MemberDao.";

	@Override
	public int idCheck(String userId) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("here?");
		try(SqlSession sqlSession=SqlMapConfig.getSqlSession()){
			System.out.println("here");
			return sqlSession.selectOne(NAMESPACE+"idCheck",userId);
		}
	}

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		// TODO Auto-generated method stub
		try(SqlSession sqlSession=SqlMapConfig.getSqlSession()){
			System.out.println("there");
			sqlSession.insert(NAMESPACE+"joinMember",memberDto);
			sqlSession.commit();
		}
	}

	@Override
	public MemberDto loginMember(String userId, String userPassword) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(userId);
		try(SqlSession sqlSession=SqlMapConfig.getSqlSession()){
			System.out.println("there");
			Map<String, String> map=new HashMap<>();
			map.put("userId", userId);
			map.put("userPwd", userPassword);
			MemberDto memberDto=sqlSession.selectOne(NAMESPACE+"loginMember",map);
			System.out.println(memberDto);
			return memberDto;
		}
	}

	

}
