package com.example.spring_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security.entity.Product;
import com.example.spring_security.entity.UserInfo;
import com.example.spring_security.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
private ProductService service;
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getProducts(){
		return service.getProducts();
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProductById(@PathVariable int id) {
		return service.getProduct(id);
	}
	@PostMapping("/add")
	public String addUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}
}
