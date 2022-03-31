package kr.ac.kopo.smartshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.smartshop.dao.SalesDao;
import kr.ac.kopo.smartshop.model.Sales;
import kr.ac.kopo.smartshop.model.Stock;
import kr.ac.kopo.smartshop.util.Pager;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	SalesDao dao;
	
	@Override
	public List<Sales> list(Pager pager) {
	int total = dao.total(pager);
	
	pager.setTotal(total);
	
	return dao.list(pager);
	}

	@Override
	public void add(Sales item) {
		dao.add(item);

	}

	@Override
	public Sales item(int code) {
		return dao.item(code);
	}

	@Override
	public void update(Sales item) {
		dao.update(item);

	}

	@Override
	public void delete(int code) {
		dao.delete(code);

	}

	@Override
	public List<Stock> stock() {
		return dao.stock();
		
	}

}
