package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

public class PageController
{
	@RequestMapping("/hello")
	public String index ()
	{
		return "hello";
	}
	
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping(value = {"/perkalian"})
	public String perkalian (@RequestParam(value = "a", required = false, defaultValue = "0") int angka1, @RequestParam(value = "b", required = false, defaultValue = "0") int angka2, Model model) {
		model.addAttribute("a", angka1);
		model.addAttribute("b", angka2);
		
		int hasil = angka1 * angka2;
		model.addAttribute("hasil", hasil);
		
		return "perkalian";
	}
}
