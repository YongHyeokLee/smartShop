package kr.ac.kopo.smartshop.dao;

import java.util.List;

import kr.ac.kopo.smartshop.model.Sales;
import kr.ac.kopo.smartshop.model.Stock;
import kr.ac.kopo.smartshop.util.Pager;

public interface SalesDao {

	int total(Pager pager);

	List<Sales> list(Pager pager);

	void add(Sales item);

	Sales item(int code);

	void update(Sales item);

	void delete(int code);

	List<Stock> stock();

}
