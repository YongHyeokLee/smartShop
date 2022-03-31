package kr.ac.kopo.smartshop.dao;

import java.util.List;

import kr.ac.kopo.smartshop.model.Purchase;
import kr.ac.kopo.smartshop.util.Pager;

public interface PurchaseDao {

	int total(Pager pager);

	List<Purchase> list(Pager pager);

	void add(Purchase item);

	Purchase item(int code);

	void update(Purchase item);

	void delete(int code);

}
