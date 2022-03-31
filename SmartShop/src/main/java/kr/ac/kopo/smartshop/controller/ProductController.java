package kr.ac.kopo.smartshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.standard.PrinterMakeAndModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.model.ProductImage;
import kr.ac.kopo.smartshop.service.ProductService;
import kr.ac.kopo.smartshop.util.Pager;
import kr.ac.kopo.smartshop.util.Uploader;
import kr.ac.kopo.smartshop.util.Uploader;

@Controller
@RequestMapping("/product")     /*  Get post 둘다 받을때  */
public class ProductController {
	final String path= "product/";
	final String uploadPath ="D:upload/";
	
	@Autowired
	ProductService service;
	/* 인터페이스     */
	
	@ResponseBody
	@GetMapping("/image/delete/{code}") 
		public boolean deleteImage(@PathVariable int code) {
		
		return service.deleteImage(code);
		
	}
	
	@GetMapping("/view/{code}")
	public String view(@PathVariable int code, Model model) {
		Product item = service.item(code);
		
		model.addAttribute("item", item);
		
		return path + "view";
	}
	
	
	
	@RequestMapping("/init")
	public String init() {
		service.init();
		
		return "redirect:list";   
		
	}
	
	
	@RequestMapping("/dummy")
	public String dummy() {
		service.dummy();
		
		return "redirect:list";
	}

	
	
	@RequestMapping({"/", "/list"})    /* 위에있는 rm과 결합됨    */
	public String list(Pager pager, Model model) {
		List<Product> list = service.list(pager);
		/*제품 목록 가져옴  list 자바 util 임포트  List<Product>  Product model */
		/* list = service.list(pager);        */
		
		model.addAttribute("list", list);
		
		return path + "list";
		
	}
	
	
	/*  GetMapping =리퀘스트 매핑  */
	
	
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Product item, @RequestParam("productImage") List<MultipartFile> productImage) {
		//ProductImage 객체를 만들고  multipartFile  file이름으로 가져온다
		//isEmpty() size()=0 값이 존재하지 않는다,  파일을 올리지 않은 경우 무시
		try {			
				Uploader<ProductImage> uploader = new Uploader<>();
			
				List<ProductImage> images = uploader.makeList(productImage, ProductImage.class);
					 
				item.setImages(images);			
		
				service.add(item);
		} catch (Exception e) {
				e.printStackTrace();
				System.out.println("실패");
		}	
		System.out.println("성공");
		return "redirect:list";   /*  .= 현재 경로   */	
	}
	
	@GetMapping("/update/{code}")    
	/*  code 받아옴   Model선언    주소에다가 변수값 {code} 사용
	 * update/1 경로 ?code=1파라미터 로처리한다   /update/ 밑에 있는 {code}값을   int code, Model model와 매칭해 쓰겠다 @PathVariable  */
	public String update(@PathVariable int code, Model model) {
		Product item = service.item(code);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{code}")   
	public String update(@PathVariable int code, @RequestParam("productImage") List<MultipartFile> productImage, Product item) {
		item.setCode(code);  /*  폼에 코드 값을 안넣고    */
		
		try {
			Uploader<ProductImage> uploader = new Uploader<>();
		
			List<ProductImage> images = uploader.makeList(productImage, ProductImage.class);
			
			item.setImages(images);
		
			service.update(item);
		} catch (Exception e) {
				e.printStackTrace();
		}	
		
		service.update(item);
		
		return "redirect:..";  /*  ..=상위폴더   */
		
	}
	
	@GetMapping("/delete/{code}")
	public String delete(@PathVariable int code) {
		service.delete(code);
		
		return "redirect:..";
		
	}
	
	
	

}



