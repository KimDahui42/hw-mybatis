package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.FileInfoDto;
import com.ssafy.util.DBUtil;
import com.ssafy.util.SqlMapConfig;

@Repository
public class BoardDaoImpl implements BoardDao {
	private final String NAMESPACE="com.ssafy.board.model.dao.BoardDao.";
	@Override
	public void writeArticle(BoardDto boardDto) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("here? board");
		try(SqlSession sqlSession=SqlMapConfig.getSqlSession()){
			System.out.println("here board");
			sqlSession.insert(NAMESPACE+"writeArticle",boardDto);
			List<FileInfoDto> fileInfos=boardDto.getFileInfos();
			if(fileInfos!=null&&!fileInfos.isEmpty()) {
				sqlSession.insert(NAMESPACE+"registFile",boardDto);
			}
			sqlSession.commit();
		}
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> param) throws SQLException {
		try(SqlSession sqlSession=SqlMapConfig.getSqlSession()){
			System.out.println("here board");
			List<BoardDto> list=sqlSession.selectList(NAMESPACE+"listArticle", param);
			for (BoardDto boardDto : list) {
				System.out.println(boardDto);
			}
			return list;
		}
	}

	@Override
	public int getTotalArticleCount(Map<String, String> param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
