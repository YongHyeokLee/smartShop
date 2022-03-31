package kr.ac.kopo.smartshop.dao;

import kr.ac.kopo.smartshop.model.ProductImage;

public interface ProductImageDao {

	void add(ProductImage image);

	boolean delete(int code);

}
