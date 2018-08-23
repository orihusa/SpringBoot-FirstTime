package com.example.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import com.example.service.LoginUserDetails;

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
	String create(
				@Validated	// 送信されたフォームの情報の入力チェックを行う
					CustomerForm form,
					BindingResult result,
					Model model,
				@AuthenticationPrincipal	// ログイン中のLoginUserDetailsオブジェクトが取得できる
					LoginUserDetails userDetails
				) {
		if (result.hasErrors()) {	// 入力チェックの結果を確認し、エラーの場合は一覧画面表示に戻る
			return list(model);
		}
		Customer customer = new Customer();
		BeanUtils.copyProperties(form, customer);
		customerService.create(customer, userDetails.getUser());
		return "redirect:/customers";	// 正常終了時、一覧画面表示にリダイレクトする 
	}

	@GetMapping(path="edit", params="form")
	String editForm(@RequestParam	// 特定のリクエストパラメータをマッピング
					Integer id,		// リクエストパラメータのidをマッピング
					CustomerForm form) {
		Customer customer = customerService.findOne(id);
		BeanUtils.copyProperties(customer, form);
		return "customers/edit";		// 顧客情報編集画面
	}
	
	@PostMapping(path="edit")
	String edit(@RequestParam
					Integer id,
					@Validated CustomerForm form,
					BindingResult result,
					@AuthenticationPrincipal	// ログイン中のLoginUserDetailsオブジェクトが取得できる
					LoginUserDetails userDetails
					) {
		if (result.hasErrors()) {
			return editForm(id, form);
		}
		
		// 送信されたCustomerFormをCustomerにコピーする
		Customer customer = new Customer();
		BeanUtils.copyProperties(form, customer);
		// 更新処理を実施
		customer.setId(id);
		customerService.update(customer, userDetails.getUser());
		return "redirect:/customers";	// 処理が完了したら一覧表示画面にリダイレクトする
	}
	
	@PostMapping(path="edit", params="goToTop")
	String goToTop() {
		return "redirect:/customers";
	}

	@PostMapping(path="delete")
	String delete(@RequestParam Integer id) {
		customerService.delete(id);
		return "redirect:/customers";	// 処理が完了したら一覧表示画面にリダイレクトする
	}
}
