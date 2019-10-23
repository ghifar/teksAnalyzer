package com.ghifar.teksAnalyzer;

import com.ghifar.teksAnalyzer.controller.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
public class TeksAnalyzerApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void testTeksLongerThan255() throws Exception {
		mockMvc.perform(get("/analyze").param("text", "abcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzy"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("error", equalTo(true)));
	}

}
