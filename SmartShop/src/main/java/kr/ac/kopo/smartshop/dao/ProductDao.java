package kr.ac.kopo.smartshop.dao;

import java.util.List;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.util.Pager;

public interface ProductDao {

	List<Product> list(Pager pager);

	void add(Product item);

	Product item(int code);

	void update(Product item);

	void delete(int code);

	int total(Pager pager);

}
