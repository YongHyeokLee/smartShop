package kr.ac.kopo.smartshop.dao;

import java.util.List;

import kr.ac.kopo.smartshop.model.Partner;
import kr.ac.kopo.smartshop.util.Pager;

public interface PartnerDao {

	int total(Pager pager);

	List<Partner> list(Pager pager);

	void add(Partner item);

	Partner item(int code);

	void update(Partner item);

	void delete(int code);

}
