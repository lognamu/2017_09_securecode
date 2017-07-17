package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVo;

public class CartDao {
	private static CartDao single;
	private SqlSessionFactory factory;
	private CartDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static CartDao getInstance() {
		if (single == null) {
			single = new CartDao();
		}

		return single;
	}
	
	public List<CartVo> selectList(int u_idx){
		List<CartVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("cart.selectList", u_idx);
		session.close();
		
		return list;
	}

	public CartVo selectOne(CartVo vo) {
		CartVo resVo = null;
		SqlSession session = factory.openSession();
		resVo = session.selectOne("cart.selectOne", vo);
		session.close();
		return resVo;
	}
	
	public void insert(CartVo vo){
		SqlSession session = factory.openSession();
		session.insert("cart.insert", vo);
		session.commit();
		session.close();
	}

	public void delete(int idx) {
		SqlSession session = factory.openSession();
		session.delete("cart.delete", idx);
		session.commit();
		session.close();
	}

	public void update(CartVo vo) {
		SqlSession session = factory.openSession(true);
		session.update("cart.update", vo);
		session.close();
	}
}
