package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import util.MyBatisConnector;
import vo.CommentVo;

public class CommentDao {
	private static CommentDao single;
	private SqlSessionFactory factory;
	private CommentDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static CommentDao getInstance() {
		if (single == null) {
			single = new CommentDao();
		}

		return single;
	}
	
	public void insert(CommentVo vo){
		SqlSession session = factory.openSession(true);
		session.insert("comment.insert", vo);
		session.close();
	}
}
