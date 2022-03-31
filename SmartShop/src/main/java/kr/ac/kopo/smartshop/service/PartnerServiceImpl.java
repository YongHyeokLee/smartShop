package kr.ac.kopo.smartshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.smartshop.dao.PartnerDao;
import kr.ac.kopo.smartshop.model.Partner;
import kr.ac.kopo.smartshop.util.Pager;

@Service
public class PartnerServiceImpl implements PartnerService {
	
	@Autowired
	PartnerDao dao;
	/* 인터페이스      */
	
	
	@Override
	public List<Partner> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
		
	}

	@Override
	public void add(Partner item) {
	dao.add(item);
		
	}

	@Override
	public Partner item(int code) {
		return dao.item(code);
	}

	@Override
	public void update(Partner item) {
		dao.update(item);
		
	}

	@Override
	public void delete(int code) {
		dao.delete(code);
		
	}

	@Override
	public List<Partner> list() {
		Pager pager = new Pager();
		
		int total = dao.total(pager);
		
		pager.setTotal(total);
		pager.setPerPage(total);
		return dao.list(pager);
	}

	@Override
	public void init() {
		 Pager pager = new Pager();
		 do {
			 List<Partner> list = dao.list(pager);
			 
			 if(list.size() < 1)
				break;
				for(Partner item : list)
					dao.delete(item.getCode());
			 
		 }while(true);
			 
		
	}

	@Override
	public void dummy() {
		for(int index=1; index < 100; index++) {
			Partner item = new Partner();
			
			item.setName("거래처 " + index);
			item.setTel("전화번호 " + index);
			item.setAddress("주소 " + index);

			
			dao.add(item);
			
		}
		
	}

}
