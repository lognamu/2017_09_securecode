package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import util.MyBatisConnector;
import vo.BbsVo;

public class BbsDao {
	private static BbsDao single;
	private SqlSessionFactory factory;
	private BbsDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static BbsDao getInstance() {
		if (single == null) {
			single = new BbsDao();
		}

		return single;
	}
	
	public List<BbsVo> selectList(Map<String, Object> map){
		List<BbsVo> list = null;
		SqlSession session = factory.openSession(true);
		list = session.selectList("bbs.selectList", map);
		session.close();
		return list;
	}

	public void insert(BbsVo vo) {
		SqlSession session = factory.openSession(true);
		session.insert("bbs.insert", vo);
		session.close();
	}

	public BbsVo selectOne(int idx) {
		BbsVo vo = null;
		SqlSession session = factory.openSession(true);
		vo = session.selectOne("bbs.selectOne", idx);
		session.close();
		return vo;
	}

	public void delete(int idx) {
		SqlSession session = factory.openSession(true);
		session.delete("bbs.delete", idx);
		session.close();
	}

	public void update(BbsVo vo) {
		SqlSession session = factory.openSession(true);
		session.update("bbs.update", vo);
		session.close();
		
	}
	
	public void updateStep(BbsVo baseVo) {
		SqlSession session = factory.openSession(true);
		session.update("bbs.updateStep", baseVo);
		session.close();
	}
	
	public void reply(BbsVo vo) {
		SqlSession session = factory.openSession(true);
		session.insert("bbs.reply", vo);
		session.close();
		
	}

	public int rowCount(Map<String, Object> map) {
		SqlSession session = factory.openSession(true);
		int rowCount = session.selectOne("bbs.rowCount", map);
		session.close();
		return rowCount;
	}

	
}
