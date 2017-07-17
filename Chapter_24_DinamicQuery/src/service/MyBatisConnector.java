package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnector {
	SqlSessionFactory factory = null;
	private static MyBatisConnector connector;
	
	private MyBatisConnector() {
		try{
			Reader reader = Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static MyBatisConnector getInstance(){
		if(connector == null){
			connector = new MyBatisConnector();
		}
		return connector;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
}
