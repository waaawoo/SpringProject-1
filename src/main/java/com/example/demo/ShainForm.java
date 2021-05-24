package com.example.demo;

import javax.validation.constraints.NotEmpty;

public class ShainForm {
//	notEmptyはから判定
	@NotEmpty(message="社員Noを入れてください")
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
