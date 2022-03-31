package kr.ac.kopo.smartshop.dao;

import kr.ac.kopo.smartshop.model.Member;

public interface MemberDao {

	Member item(Member member);

	void add(Member member);

	int checkId(String id);
	
	
}
