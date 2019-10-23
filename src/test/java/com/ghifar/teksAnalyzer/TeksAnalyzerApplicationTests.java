package com.ghifar.teksAnalyzer;

import com.ghifar.teksAnalyzer.controller.MainController;
import com.ghifar.teksAnalyzer.service.TeksService;
import com.ghifar.teksAnalyzer.service.impl.TeksServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
@ContextConfiguration(classes = {TeksService.class, TeksAnalyzerApplication.class, TeksServiceImpl.class})
public class TeksAnalyzerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testTeksLongerThan255() throws Exception {
		mockMvc.perform(get("/analyze").param("text", "abcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzyabcdefghijklmnopqerstuvwzy"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("error", equalTo(true)));
	}

	@Test
	public void testTeksNotLongerThan255() throws Exception {
		mockMvc.perform(get("/analyze").param("text", "hello world"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("error", equalTo(false)));
	}

	@Test
	public void testCharacterAnalysis1() throws Exception {
		List characters_before= new ArrayList();
		List characters_after= new ArrayList();
		characters_before.add('o');
		characters_before.add('t');
		characters_before.add('c');
		characters_after.add('f');
		characters_after.add('o');
		characters_after.add('s');
		mockMvc.perform(get("/analyze").param("text", "football vs soccer"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("error", equalTo(false)))
				.andExpect(model().attribute("analysis", hasSize(11)));

	}

}
