package com.example.demo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ShainForm {
//	notEmptyはから判定
	@NotEmpty(message="社員Noを入れてください")
//	正規表現でのバリデーション設定
	@Pattern(regexp = "\\d{3}", message = "半角数字、3桁で入力してください。")
//	formの値を宣言
	private String number;
	
//	getter,setterを作成する
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

}
