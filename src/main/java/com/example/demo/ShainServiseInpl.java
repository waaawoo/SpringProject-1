package com.example.demo;

import org.springframework.stereotype.Service;

// サービス層のDI化に必要な記述　条件
@Service
public class ShainServiseInpl implements ShainServise {
	
//	使用するファイルの宣言
	private final ShainRepository shainRepository;
//	DI化
	public ShainServiseInpl(ShainRepository shainRepository) {
		this.shainRepository = shainRepository;
	}

//	オーバーライドする
	@Override
	public String findByNo(String Number) {
//		リポジトリから社員を選択
//		ShainRepository shainRepository = new ShainRepositoryImpl();
//		DI化することでshainRepositoryが実装していなくても使用できる
		String name = shainRepository.selectByNo(Number);
		return name;
	}

}
