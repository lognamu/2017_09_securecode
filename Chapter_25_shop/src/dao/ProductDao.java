package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;

public class ProductDao {
	private static ProductDao single;
	private SqlSessionFactory factory;
	

	private ProductDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static ProductDao getInstance() {
		if (single == null) {
			single = new ProductDao();
		}

		return single;
	}
	
	public List<ProductVo> selectList(String category){
		List<ProductVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("product.selectList", category);
		session.close();
		return list;
	}
	
	public void insert(ProductVo vo){
		SqlSession session = factory.openSession(true);
		session.insert("product.insert", vo);
		session.close();
	}

	public ProductVo selectOne(String idx) {
		SqlSession session = factory.openSession();
		ProductVo vo = session.selectOne("product.selectOne", idx);
		session.close();
		return vo;
	}
}
