package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector;
import vo.VisitVo;

public class VisitDao {
	private static VisitDao single = null;

	private VisitDao() {
	}

	public static VisitDao getInstance() {
		if (single == null) {
			single = new VisitDao();
		}

		return single;
	}

	public List<VisitVo> selectList() {
		List<VisitVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from visit order by idx desc";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				VisitVo vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setPwd(rs.getString("pwd"));
				vo.setRegdate(rs.getString("regdate"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return list;
	}

	public void insert(VisitVo vo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into visit(name, content, ip, pwd, regdate)" +
					"values(?, ?, ?, ?, curdate())";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getIp());
			stmt.setString(4, vo.getPwd());
			
			int count = stmt.executeUpdate();
			System.out.println("--------"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(int idx) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from visit where idx = ?";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idx);
			int count = stmt.executeUpdate();
			System.out.println("-------"+count);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
		
	}

	public VisitVo selectOne(int idx) {
		VisitVo vo = new VisitVo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from visit where idx = ?";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idx);
			rs = stmt.executeQuery();
			rs.next();
			vo.setIdx(rs.getInt("idx"));
			vo.setName(rs.getString("name"));
			vo.setContent(rs.getString("content"));
			vo.setIp(rs.getString("ip"));
			vo.setPwd(rs.getString("pwd"));
			vo.setRegdate(rs.getString("regdate"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return vo;
	}

	public void Update(VisitVo vo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update visit set name = ?, content = ?, pwd = ? where idx = ?";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getPwd());
			stmt.setInt(4, vo.getIdx());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	
}
