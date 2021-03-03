package pl.wpulik.gender_recognizer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class NameGenderControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void guessGenderTestVariantOneMale() throws Exception {
		mvc.perform(post("/gender/guess").param("variant", "1").param("fullname", "Wojciech Anna Nowak"))
				.andExpect(status().isFound()).andExpect(content().string("MALE"));
	}
	
	@Test
	public void guessGenderTestVariantOneFemale() throws Exception {
		mvc.perform(post("/gender/guess").param("variant", "1").param("fullname", "Anna Wojciech Nowak"))
				.andExpect(status().isFound()).andExpect(content().string("FEMALE"));
	}
	
	@Test
	public void guessGenderTestVariantOneInconclusive() throws Exception {
		mvc.perform(post("/gender/guess").param("variant", "1").param("fullname", "incorrect value"))
				.andExpect(status().isFound()).andExpect(content().string("INCONCLUSIVE"));
	}

	@Test
	public void guessGenderTestVariantTwoMale() throws Exception {
		mvc.perform(post("/gender/guess").param("variant", "2").param("fullname", "Wojciech Kazimierz Anna Nowak"))
				.andExpect(status().isFound()).andExpect(content().string("MALE"));
	}
	
	@Test
	public void guessGenderTestVariantTwoFemale() throws Exception {
		mvc.perform(post("/gender/guess").param("variant", "2").param("fullname", "Helena Anna Nowak"))
				.andExpect(status().isFound()).andExpect(content().string("FEMALE"));
	}
	
	@Test
	public void guessGenderTestVariantTwoInconclusive() throws Exception {
		mvc.perform(post("/gender/guess").param("variant", "2").param("fullname", "Kazimierz Anna Nowak"))
				.andExpect(status().isFound()).andExpect(content().string("INCONCLUSIVE"));
	}

}
