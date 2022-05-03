package co.micol.notice.servicelmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.notice.dao.DataSource;
import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;

public class NoticeServiclmpl implements NoticeService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn; // = dao.getConnection();
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		// 전체조회
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "SELECT * FROM NOTICE";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("Writer"));
				vo.setTitle(rs.getString("Title"));
				vo.setWdate(rs.getDate("Wdate"));
				vo.setHit(rs.getInt("Hit"));
				list.add(vo);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
		return list;
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// 글 세부 조회(한개의 공지사항 읽음)
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("Writer"));
				vo.setTitle(rs.getString("Title"));
				vo.setSubject(rs.getString("subject"));
				vo.setWdate(rs.getDate("Wdate"));
				vo.setHit(rs.getInt("Hit"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			close();
		}
		return vo;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void close() {
		  try {
		         if (rs != null)
		            rs.close();
		         if (psmt != null)
		            psmt.close();
		         if (conn != null)
		            conn.close();

				
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}


	}

