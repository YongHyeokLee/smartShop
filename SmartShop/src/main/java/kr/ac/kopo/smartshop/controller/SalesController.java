package kr.ac.kopo.smartshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.smartshop.model.Member;
import kr.ac.kopo.smartshop.model.Partner;
import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.model.Sales;
import kr.ac.kopo.smartshop.model.Stock;
import kr.ac.kopo.smartshop.service.PartnerService;
import kr.ac.kopo.smartshop.service.ProductService;
import kr.ac.kopo.smartshop.service.SalesService;
import kr.ac.kopo.smartshop.util.Pager;

@Controller
@RequestMapping("/sales")
public class SalesController {
	final String path = "sales/";
	
	@Autowired             //SalesService 인터페이스를 service에 넣어줌
	SalesService service;
	
	@Autowired
	PartnerService partnerService;
	
	@RequestMapping({"/","/list"})
	public String list(Pager pager, Model model) {
		List<Sales> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
		
	}
	
	@GetMapping("/add")
	public String add(Model model, @SessionAttribute Member member) {
		List<Stock> StockList = service.stock();    //autowired
		model.addAttribute("listProduct", StockList);    // jsp 고치기 싫어서
		
		List<Partner> partnerlist = partnerService.list();
		model.addAttribute("listPartner", partnerlist);
		
		model.addAttribute("user", member.getId());
		
		return path + "add";        //servlet-context 사용
	}
	
	@PostMapping("/add")
	public String add(Sales item, @SessionAttribute Member member) {
		item.setId(member.getId());
		service.add(item);
		
		return "redirect:list";
	}
	
	
	@GetMapping("/update/{code}")    //객체를만들고  값을 리퀘스트 get파라미터 ,  set
	public String update(@PathVariable int code, Model model) {
		Sales item = service.item(code);
		List<Stock> StockList = service.stock();    //autowired
		model.addAttribute("listProduct", StockList);    // jsp 고치기 싫어서
		
		List<Partner> partnerlist = partnerService.list();
		model.addAttribute("listPartner", partnerlist);
		model.addAttribute("item", item);

		return path + "update";
		
	}
	
	@PostMapping("/update/{code}")
	public String update(@PathVariable int code, Sales item) {
		service.update(item);	
		return "redirect:../list";
		
	}
	
	@RequestMapping("/delete/{code}")
	public String delete(@PathVariable int code) {
		service.delete(code);
		return "redirect:../list";
		
	}
}
