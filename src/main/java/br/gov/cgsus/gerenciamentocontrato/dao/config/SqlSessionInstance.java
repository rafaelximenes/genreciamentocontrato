package br.gov.cgsus.gerenciamentocontrato.dao.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionInstance {
	
	private static SqlSessionInstance instance = null;
	private SqlSession session;
	
	protected SqlSessionInstance() {
		 
	}
	
	public static SqlSessionInstance getInstace(){
		if(instance == null) {
			instance = new SqlSessionInstance();
		}
		return instance;
	}
	
	public SqlSession getInstanceSession() {
		String resource = "org/mybatis/config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		session = sqlSessionFactory.openSession();
		return session;
	}
	
	public void closeInstance() {
		session.close();
	}

}
