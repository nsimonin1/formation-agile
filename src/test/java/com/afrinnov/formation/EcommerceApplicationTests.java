package com.afrinnov.formation;

import com.afrinnov.formation.controller.ProductAddController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class EcommerceApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	void contextLoads(@Autowired ProductAddController controller) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product-increment")
				.param("product","toto")
				.param("quantity", "3"))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection());

	}

}
