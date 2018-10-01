package edu.iot.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.iot.common.database.Session;

public class CrudDaoImpl<M, K> implements CrudDao<M, K> {
	// Mapper의 namespace와 동일하게 구성
	protected String namespace;
	
	public CrudDaoImpl(String name) {
		this.namespace = getClass().getPackage().getName() + "." + name;
	}

	public List<M> getList() throws Exception {
		try(SqlSession session=Session.getSession()) {
			// selectOne/selectList 어느 메소드를 호출하느냐에 따라 list/객체 하나 리턴값이 결정
			return session.selectList(namespace + ".getList"); 
		}
	}

	public M findById(K k) throws Exception {
		try(SqlSession session=Session.getSession()) { 
			return session.selectOne(namespace + ".findById", k); 
		}
	}

	public int insert(M m) throws Exception {
		try(SqlSession session = Session.getSession()){
			int count = session.insert(namespace + ".insert", m);
			session.commit();
			return count;
		}
	}

	public int update(M m) throws Exception {
		try(SqlSession session = Session.getSession()){
			int count = session.update(namespace + ".update", m);
			session.commit();
			return count;
		}
	}

	public int delete(K k) throws Exception {
		try(SqlSession session = Session.getSession()){
			int count = session.delete(namespace + ".delete", k);
			session.commit();
			return count;
		}
	}

	public int count() throws Exception {
		try(SqlSession session=Session.getSession()) { 
			return session.selectOne(namespace + ".count"); 
		}
	}

	@Override
	public List<M> random(int num) throws Exception {
		try (SqlSession session = Session.getSession()){
			return session.selectList(namespace + ".random", num);
		}
	}
	
	@Override
	public List<M> getPage(int start, int end) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		try(SqlSession session = Session.getSession()){
			return session.selectList(namespace + ".getPage", map);
		}
		
	}
}
