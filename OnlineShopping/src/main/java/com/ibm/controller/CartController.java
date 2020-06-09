package com.ibm.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.domain.ItemAdd;
import com.ibm.domain.User;
import com.ibm.repository.UserRepo;
import com.ibm.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserRepo userRepo;
	
//	@PostMapping("")
//    public ResponseEntity<Object> addToCart(@Valid ItemAdd itemAdd) {
//		return new ResponseEntity<Object>(cartService.addItem(itemAdd), HttpStatus.OK);
//        		
//    }

    @PostMapping("/checkout")
    public  ResponseEntity<Object> checkout(List<ItemAdd> itemList, Principal principal) throws Exception {
        User user = userRepo.findOne(principal.getName());// Email as username
        if(null== user)
        	throw new Exception("User not registered");
        return new ResponseEntity<Object>(cartService.checkout(user), HttpStatus.OK);
        
    }

    @GetMapping("/remove")
    public ResponseEntity<Object> remove(@RequestParam("product_id") String productId)throws Exception {
        return new ResponseEntity<Object>(cartService.removeItem(productId), HttpStatus.OK);
    }

    @GetMapping("/change")
    public String plus(@RequestParam("product_id") String poductId, @RequestParam("quantity") Integer quantity) throws Exception {
    	cartService.updateQuantity(poductId, quantity);
        return "redirect:" + "/cart";
    }



}
