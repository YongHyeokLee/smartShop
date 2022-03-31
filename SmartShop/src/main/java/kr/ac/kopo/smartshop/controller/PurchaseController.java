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
import kr.ac.kopo.smartshop.model.Purchase;
import kr.ac.kopo.smartshop.service.PartnerService;
import kr.ac.kopo.smartshop.service.ProductService;
import kr.ac.kopo.smartshop.service.PurchaseService;
import kr.ac.kopo.smartshop.util.Pager;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	final String path ="purchase/";
	
	@Autowired
	PurchaseService service;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	PartnerService partnerService;
	
	@RequestMapping({"/", "list"})
	public String list(Pager pager, Model model) {
		List<Purchase> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
		
	}
	
	@GetMapping("/add")
	  // Model - view에 넘겨줄때 사용
	public String add(Model model, @SessionAttribute Member member) {
		                                      //list에 pager를 넣어주면 perpage가 싷행되서 전체 품목을 볼수 없어서
		List<Product> listProduct = productService.list(); // service로 만들어준다
				
		List<Partner> listPartner = partnerService.list();
		
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listPartner", listPartner);
		model.addAttribute("user", member.getId());
		
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Purchase item, @SessionAttribute Member member) {
		item.setId(member.getId());
		
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{code}")
	public String update(@PathVariable int code, Model model) {
		Purchase item = service.item(code);
		
		List<Product> listProduct = productService.list();
		model.addAttribute("listProduct", listProduct);
		
		List<Partner> listPartner = partnerService.list();
		model.addAttribute("listPartner", listPartner);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{code}")
	public String update(@PathVariable int code, Purchase item) {
		service.update(item);
		
		return "redirect:../list";
		
	}
	
	@GetMapping("/delete/{code}")
	public String delete(@PathVariable int code) {
		service.delete(code);
		
		return "redirect:../list";
	}
}
