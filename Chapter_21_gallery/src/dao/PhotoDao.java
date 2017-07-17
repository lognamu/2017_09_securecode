package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector;
import vo.PhotoVo;

public class PhotoDao {
	private static PhotoDao single = null;

	private PhotoDao() {
	}

	public static PhotoDao getInstance() {
		if (single == null) {
			single = new PhotoDao();
		}

		return single;
	}

	public List<PhotoVo> selectList() {
		List<PhotoVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from photo order by idx desc";
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				PhotoVo vo = new PhotoVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getString("title"));
				vo.setFilename(rs.getString("filename"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				list.add(vo);
			}
		}catch(Exception e){
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
		return list;
	}

	public void insert(PhotoVo vo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into photo(title, pwd, filename, ip) values(?,?,?,?)";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getPwd());
			stmt.setString(3, vo.getFilename());
			stmt.setString(4, vo.getIp());
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

	public PhotoVo selectOne(int idx) {
		PhotoVo vo = new PhotoVo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from photo where idx = ?";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idx);
			rs = stmt.executeQuery();
			rs.next();
			vo.setIdx(rs.getInt("idx"));
			vo.setTitle(rs.getString("title"));
			vo.setFilename(rs.getString("filename"));
			vo.setPwd(rs.getString("pwd"));
			vo.setIp(rs.getString("ip"));
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

	public void delete(int idx) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from photo where idx = ?";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idx);
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
