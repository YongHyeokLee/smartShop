package kr.ac.kopo.smartshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.smartshop.model.Partner;
import kr.ac.kopo.smartshop.util.Pager;

@Repository /* 저장소  */
public class PartnerDaoImpl implements PartnerDao {

	@Autowired
	SqlSession sql; 
	/* 마이바티스 세팅을 해야됨     pom-123 삽입 임포트  */
	
	@Override
	public int total(Pager pager) {
		return sql.selectOne("partner.total",pager);
	}

	@Override
	public List<Partner> list(Pager pager) {
		return sql.selectList("partner.list", pager);
	}

	@Override
	public void add(Partner item) {
		sql.insert("partner.add", item);
		  /*partner.xml partner네임스페이스에 id가 add 필요한 정보는 item정보에 들어 있다*/
	}

	@Override
	public Partner item(int code) {
		return sql.selectOne("partner.item", code);
	}

	@Override
	public void update(Partner item) {
	sql.update("partner.update", item);
	}

	@Override
	public void delete(int code) {
		sql.delete("partner.delete", code);
	}

}
