package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShainController {
	
//	ControllerのBean化
	private final ShainServise shainServise;
//	shainServiseのDI化
	public ShainController(ShainServise shainServise) {
		this.shainServise = shainServise;
	}
	
	
//	モデルの初期化　リクエストマッピングの前に記述する
	@ModelAttribute
	public ShainForm setUpForm() {
		return new ShainForm();
	}
	
	
	@RequestMapping("/input")
	public String index() {
		return "index.html";
	}
	
//	ShainFormにしたがってバリデーションをする
	@RequestMapping("/output")
	public String result(@Validated ShainForm shainForm, BindingResult bindingResult, Model model) {
//		バリデーションの結果がエラーならindex.htmlへ遷移
		if(bindingResult.hasErrors()) {
			return "index.html";
		}
		
//		社員フォームからデータを取得する
		String number = shainForm.getNumber();
		
//		サービス層から社員を検索
//		ShainServise shainService = new ShainServiseInpl();
		
//		DI化した変数からデータを取得するようにする
		String name = shainServise.findByNo(number);
//		String name = "コントロ";
		model.addAttribute("number", number);
		model.addAttribute("name", name);
		return "output.html";
	}
}
