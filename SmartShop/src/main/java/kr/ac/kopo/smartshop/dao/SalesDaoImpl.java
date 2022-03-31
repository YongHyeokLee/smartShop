package kr.ac.kopo.smartshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.smartshop.model.Sales;
import kr.ac.kopo.smartshop.model.Stock;
import kr.ac.kopo.smartshop.util.Pager;

@Repository
public class SalesDaoImpl implements SalesDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public int total(Pager pager) {
		return sql.selectOne("sales.total", pager);
	}

	@Override
	public List<Sales> list(Pager pager) {
		return sql.selectList("sales.list", pager);
	}

	@Override
	public void add(Sales item) {
		sql.insert("sales.add", item);
	}

	@Override
	public Sales item(int code) {
		return sql.selectOne("sales.item", code);
	}

	@Override
	public void update(Sales item) {
		sql.update("sales.update", item);

	}

	@Override
	public void delete(int code) {
		sql.delete("sales.delete", code);

	}

	@Override
	public List<Stock> stock() {
		return sql.selectList("sales.stock");
	}

}
