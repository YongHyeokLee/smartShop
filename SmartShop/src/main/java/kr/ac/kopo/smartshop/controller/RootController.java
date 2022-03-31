package kr.ac.kopo.smartshop.controller;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.kopo.smartshop.model.Member;
import kr.ac.kopo.smartshop.service.MemberService;

@Controller   /*어노테이션 컨트롤인것을 알려줌*/
public class RootController {

	@Autowired
	MemberService memberService;
	
	
	@RequestMapping("/")    /**/
	public String index() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@ResponseBody  //
	@GetMapping("/checkId")
	public String checkId(String id) {
		
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(memberService.checkId(id))
			return "OK";
		else
			return "FAIL";
	}
	
	@PostMapping("/signup")
	public String signup(Member member, RedirectAttributes ra) {
		memberService.add(member);
		
		ra.addFlashAttribute("msg", "가입을 축하합니다.");  //세션에 값을 넣어준다   msg을 읽으면 가입하고 넘어감
		return "redirect:.";                            // 새 리퀘스트가 오면 세션이 없어짐  
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		if(memberService.login(member)) {
			session.setAttribute("member", member);
			return "redirect:.";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")   //위치에는 변화가 없다
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:.";
	}
}
