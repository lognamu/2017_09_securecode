package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import util.DBConnector;
import vo.VisitVo;

public class VisitDao {
	private static VisitDao single = null;
	public SqlSessionFactory factory;

	private VisitDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static VisitDao getInstance() {
		if (single == null) {
			single = new VisitDao();
		}

		return single;
	}

	public List<VisitVo> selectList() {
		List<VisitVo> list = new ArrayList<>();
		SqlSession ss = factory.openSession();
		list = ss.selectList("visit.selectList");
		ss.close();
		return list;
	}

	public void insert(VisitVo vo) {
		int res = 0;
		SqlSession ss = factory.openSession();
		res = ss.insert("visit.insert", vo);
		if(res == 1){
			ss.commit();
		}
		ss.close();
	}

	public void delete(int idx) {
		int res = 0;
		SqlSession ss = factory.openSession(true);
		res = ss.delete("visit.delete", idx);
		ss.close();
	}

	public VisitVo selectOne(int idx) {
		VisitVo vo = new VisitVo();
		SqlSession ss = factory.openSession();
		vo = ss.selectOne("visit.selectOne", idx);
		ss.close();
		
		return vo;
	}

	public void update(VisitVo vo) {
		int res = 0;
		SqlSession ss = factory.openSession();
		res = ss.update("visit.update", vo);
		if(res == 1){
			ss.commit();
		}
		
		ss.close();
		
	}

	
}
