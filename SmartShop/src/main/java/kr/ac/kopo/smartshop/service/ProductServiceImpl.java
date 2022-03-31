package kr.ac.kopo.smartshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.smartshop.dao.ProductDao;
import kr.ac.kopo.smartshop.dao.ProductImageDao;
import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.model.ProductImage;
import kr.ac.kopo.smartshop.util.Pager;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Autowired
	ProductImageDao productImageDao;
					
	@Override
	public List<Product> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	@Transactional
	public void add(Product item) {
		dao.add(item);
		
		for(ProductImage image : item.getImages()) {
			image.setProductCode(item.getCode());
			productImageDao.add(image);
		}
	}

	@Override
	public Product item(int code) {
		return dao.item(code);
	}

	@Override
	@Transactional
	public void update(Product item) {
		dao.update(item);
		
		for(ProductImage image : item.getImages() ) {
			image.setProductCode(item.getCode() );
			
			productImageDao.add(image);
		}		
	}

	@Override
	@Transactional
	public void delete(int code) {
		Product item = dao.item(code);
		
		for(ProductImage image : item.getImages()) {
			productImageDao.delete(image.getCode());
		}
		dao.delete(code);
		
	}

	@Override
	public void dummy() {
		for(int index=1; index < 100; index++) {
			Product item = new Product();
			
			item.setName("제품명 " + index);
			item.setSpec("규격 " + index);
			item.setCategory("범주 " + index);
			item.setManufacture("제조사 " + index);
			item.setPrice(index * 1000);
			
			dao.add(item);
			
		}
		
	}

	@Override
	public void init() {
		 Pager pager = new Pager();
		 do {
			 List<Product> list = dao.list(pager);
			 
			 if(list.size() < 1)
				break;
				for(Product item : list)
					dao.delete(item.getCode());
			 
		 }while(true);
			 
		
	}

	@Override    //purchase add에서 리스트를 가져올때 pager가 안된 리스트를 가져오는 코드
	public List<Product> list() {
		Pager pager = new Pager();
		
		int total = dao.total(pager);
		
		pager.setTotal(total);
		pager.setPerPage(total);
		
		return dao.list(pager);
	}

	@Override
	public boolean deleteImage(int code) {
		return productImageDao.delete(code);
	}


}
