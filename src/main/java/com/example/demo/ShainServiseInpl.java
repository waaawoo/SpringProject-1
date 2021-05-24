package com.example.demo;

public class ShainServiseInpl implements ShainServise {

//	オーバーライドする
	@Override
	public String findByNo(String Number) {
//		リポジトリから社員を選択
		ShainRepository shainRepository = new ShainRepositoryImpl();
		String name = shainRepository.selectByNo(Number);
		return name;
	}

}
