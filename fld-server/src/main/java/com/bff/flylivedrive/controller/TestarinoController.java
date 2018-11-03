package com.bff.flylivedrive.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestarinoController {

	@RequestMapping("/testarino")
	public ArrayList<String> testarino() {
		System.out.println("testarino");
		ArrayList<String> test = new ArrayList<>();
		test.add("Kum");
		test.add("Jove");
		test.add("Ja");
		return test;
	}
	
	@RequestMapping("/jove")
	public ArrayList<String> jove() {
		System.out.println("testarino");
		ArrayList<String> test = new ArrayList<>();
		test.add("Jove");
		test.add("debil");
		test.add("veliki");
		return test;
	}
	
	
	
	@RequestMapping("/")
	public String ajmo() {
		System.out.println("ajmo");
		return "ajmo";
	}
}
