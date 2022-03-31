package kr.ac.kopo.smartshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.service.ProductService;
import kr.ac.kopo.smartshop.util.Pager;

@RequestMapping("/api")
@RestController    //Controller + ResponseBody
public class ApiController {

	@Autowired
	ProductService service;
	
	@GetMapping
	public Map<String, Object> list(Pager pager) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", service.list(pager));
		map.put("pager", pager);
		
		return map;
	}
	
	@GetMapping("/{code}")
	public Product item(@PathVariable int code) {
		return service.item(code);
	}
	
	@PostMapping
	public void add(@RequestBody Product item) {
		service.add(item);
		
	}
	
	@PutMapping
	public void update(@RequestBody Product item) {
		service.update(item);
	}
	
	@DeleteMapping("/{code}")
	public void delete(@PathVariable int code) {
		service.delete(code);
	}
	
	
	
	
	
	
}
