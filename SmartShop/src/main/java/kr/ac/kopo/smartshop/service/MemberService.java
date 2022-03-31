package kr.ac.kopo.smartshop.service;

import kr.ac.kopo.smartshop.model.Member;

public interface MemberService {

	boolean login(Member member);

	void add(Member member);

	boolean checkId(String id);

}
