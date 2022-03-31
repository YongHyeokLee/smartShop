package kr.ac.kopo.smartshop.model;

import kr.ac.kopo.smartshop.util.UploadFile;

public class ProductImage implements UploadFile{

	private int code;
	private String filename;
	private String uuid;
	private int productCode;
	
	

	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
}
