package com.example.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@Controller							// 画面遷移用のコントローラ
@RequestMapping("customers")		// URLの接頭辞
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@ModelAttribute
	CustomerForm setUpForm() {
		return new CustomerForm();
	}
	
	@GetMapping						// listメソッドがURLにマッピングされるようにする
	String list(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customers/list";
	}
	
	// 画面の情報はCustomerFormで表現し、コントローラで変換する
	@PostMapping(path = "create")
	String create(@Validated	// 送信されたフォームの情報の入力チェックを行う
					CustomerForm form,
					BindingResult result,
					Model model			
				) {
		if (result.hasErrors()) {	// 入力チェックの結果を確認し、エラーの場合は一覧画面表示に戻る
			return list(model);
		}
		Customer customer = new Customer();
		BeanUtils.copyProperties(form, customer);
		customerService.create(customer);
		return "redirect:/customers";	// 正常終了時、一覧画面表示にリダイレクトする 
	}
}
