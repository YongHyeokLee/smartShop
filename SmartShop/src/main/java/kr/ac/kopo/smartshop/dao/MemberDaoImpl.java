package kr.ac.kopo.smartshop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.smartshop.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public Member item(Member member) {
		return sql.selectOne("member.login", member);
	}

	@Override
	public void add(Member member) {
		sql.insert("member.add", member);
	}

	@Override
	public int checkId(String id) {
		return sql.selectOne("member.check_id", id);
	}

	
		
	

}
