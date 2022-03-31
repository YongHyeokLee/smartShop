package kr.ac.kopo.smartshop.util;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page = 1;
	private int perPage = 10;
	private int perGroup = 5;    //화면에 몇개씩 보여줄건지
	private float total; 		 
	
	// ? = 쿼리스트링   kv  key value  page=2   page=key   2=value
	//  프로토콜   localhost= 도메인 주소  :80번 사용 포트  /kopo/product=uri
	
	
	
	private int search = 0;
	private String keyword;
	
	public String getQuery() {
		if(search < 1)
			return null;
		
		return "search=" + search + "&keyword=" + keyword;
	}
	
	
	
	public int getSearch() {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPrev() {       
		return page <= perGroup ? 1 : (((page-1) / perGroup) - 1) * perGroup + 1;
	}   //page가 1-9까지면  1이다          이전 그룹의 첫번째
	
	public int getNext() {
		int next = (((page-1) / perGroup) + 1) * perGroup + 1;
		int last = getLast();
		
		return next < last ? next : last;
	} //  getPrev()의 page <= perGroup 와 비슷   마지막 페이지가 라스트가 넘으면 라스트 값으로 가라
	
	         //자바 util list 
	public List<Integer> getList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int startPage = (((page-1) / perGroup) + 0) * perGroup + 1;
		
		for(int index=startPage; index < (startPage + perGroup) && index <= getLast(); index++)
			list.add(index);   
		
		if(list.isEmpty())   //데이터가 하나도 없을때
			list.add(1);
		
		return list;
	}  
	
	 
	public int getLast() {
		int last = (int) Math.ceil(total / perPage);       // Math.ceil 나눈 값을 올림해줌  (int)= 정수 값으로 형변환
		return last < 1 ? 1: last;   // 라스트 값이 1이면 1 아니면 라스트값  값이 없을떄 라스트를 누르면 키값이0이 되기 떄문에
	}                     
	
	public int getPerGroup() {
		return perGroup;
	}

	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getOffset() {
		return (page -1) * perPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

}
