package com.viewnext.practica_spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.viewnext.practica_spring.models.Product;
import com.viewnext.practica_spring.repos.ProductRepository;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/swagger-ui/index.html#/");
    }
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
	
		Product product = productRepo.findById(id).get();
		
		if (product != null) {
	        return ResponseEntity.ok(product);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/products/save")
	public ResponseEntity<Product> saveProducts(@Valid @RequestBody Product product){
		return ResponseEntity.ok(productRepo.save(product));
	}
	
	@PutMapping("/products/update/{id}")
	public String updateUser(@PathVariable long id,@RequestBody Product product) {
		Product updatedProduct = productRepo.findById(id).get();
		updatedProduct.setName(product.getName());
		updatedProduct.setDescription(product.getDescription());
		updatedProduct.setPrice(product.getPrice());
		updatedProduct.setStock(product.getStock());
		productRepo.save(updatedProduct);
		return "Product updated.";
	}
	
	@DeleteMapping("/products/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		Product deleteProduct = productRepo.findById(id).get();
		productRepo.delete(deleteProduct);
		return "Deleted product with id: "+id;
	}
	
}
