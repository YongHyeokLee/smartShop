package kr.ac.kopo.smartshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.util.Pager;

@Repository
public class ProductDaoImpl implements ProductDao {

	
	@Autowired
	SqlSession sql;
	
	
	@Override
	public List<Product> list(Pager pager) {
		return sql.selectList("product.list", pager);
	}                          /*product.list  product.xml*/

	@Override
	public void add(Product item) {
		sql.insert("product.add", item);
	}

	@Override
	public Product item(int code) {
		return sql.selectOne("product.item", code);
	}

	@Override
	public void update(Product item) {
		sql.update("product.update", item);
		
	}

	@Override
	public void delete(int code) {
		sql.delete("product.delete", code);
		
	}

	@Override
	public int total(Pager pager) {
		return sql.selectOne("product.total", pager);
	}
	//리턴 타입이 객체면  리턴 널   인트면 기본값 0
}
