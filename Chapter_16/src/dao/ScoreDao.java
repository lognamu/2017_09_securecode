package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector;
import vo.ScoreVo;

public class ScoreDao {
	
	private static ScoreDao single = null;

	private ScoreDao() {
	}

	public static ScoreDao getInstance() {
		if (single == null) {
			single = new ScoreDao();
		}

		return single;
	}
	
	public List<ScoreVo> selectList(){
		List<ScoreVo> scoreList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from score_view";
		
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				ScoreVo vo = new ScoreVo();
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setKorean(rs.getInt("korean"));
				vo.setEnglish(rs.getInt("english"));
				vo.setMath(rs.getInt("math"));
				vo.setTotal(rs.getInt("total"));
				vo.setAverage(rs.getInt("average"));
				scoreList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return scoreList;
	}
	
	public ScoreVo selectOne(int code){
		ScoreVo svo = new ScoreVo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from score where code = ?";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);
			rs = stmt.executeQuery();
			
			rs.next();
			svo.setCode(rs.getInt("code"));
			svo.setName(rs.getString("name"));
			svo.setKorean(rs.getInt("korean"));
			svo.setEnglish(rs.getInt("english"));
			svo.setMath(rs.getInt("math"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return svo;
	}
	
	public void insert(ScoreVo svo){
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into score(name, korean, english, math) values(?, ?, ?, ?)";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, svo.getName());
			stmt.setInt(2, svo.getKorean());
			stmt.setInt(3, svo.getEnglish());
			stmt.setInt(4, svo.getMath());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int code){
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from score where code = ?";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(ScoreVo svo){
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update score set name=?, korean=?, english=?, math=? where code = ?";
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, svo.getName());
			stmt.setInt(2, svo.getKorean());
			stmt.setInt(3, svo.getEnglish());
			stmt.setInt(4, svo.getMath());
			stmt.setInt(5, svo.getCode());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
