package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//　以下二つのアノテーションの記述はSpringBootの機能を使ったテストを行う宣言
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WebTest {

//	Webサーバーを起動しなくても擬似的にその状態を作ってくれるクラス
	private MockMvc mockMvc;

//	ターゲットクラスを指定する
	@Autowired
	ShainController target;

//	デプロイすることなく再現する
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(target).build();
	}

//	実行する記述
	@Test
	public void isStatusTest() throws Exception {
		// /inputでアクセスして、statusがOKになるかのテスト isOkは正常の場合OK isNotFoundの場合ページがない場合正常の判定をする
		mockMvc.perform(get("/input")).andExpect(status().isOk());
	}

}