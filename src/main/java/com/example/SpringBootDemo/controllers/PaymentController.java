package com.example.SpringBootDemo.controllers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBootDemo.classes.SignGenerator;

@Controller
public class PaymentController {

	public static String MERCHANT_ID = "1100017889";
	public static String MERCHANT_HEX = "0b0d3f5d90c5fbda67291f3b89436800d0b4d8932e6b595ed97fd79960c6a0eb2f9112a934f4b19e4fd0a8ab9b612ce53b1203100bb65c7e0a32d90b2c261fb8";
	public static String REFNO = "123456789";

	@PostMapping(value = "/payment")
	public String confirmPayment(@RequestParam(value = "amount", required = true) double amount, Model model)
			throws InvalidKeyException, IllegalArgumentException, NoSuchAlgorithmException {

		int actual = (int) (amount * 100);
		String value = SignGenerator.getHexaSHA256Signature("", MERCHANT_HEX, MERCHANT_ID, String.valueOf(actual),
				"CHF", REFNO);
		model.addAttribute("displayAmount", amount);
		model.addAttribute("merchantID", MERCHANT_ID);
		model.addAttribute("amount", actual);
		model.addAttribute("sign", value);
		model.addAttribute("refno", REFNO);
		return "payment";
	}
}
