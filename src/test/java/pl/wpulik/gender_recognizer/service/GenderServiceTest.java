package pl.wpulik.gender_recognizer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenderServiceTest {
	
	@Autowired
	GenderService genderService;
	
	@Test
	public void allGenderTokensTest() throws IOException, IllegalArgumentException{
		String gender1 = "female";
		String gender2 = "male";
		assertNotNull(genderService.allGenderTokens(gender1));
		assertNotNull(genderService.allGenderTokens(gender2));
	}
	
	@Test
	public void allGenderTokensExceptionTest() throws IOException, IllegalArgumentException{
		try {
			genderService.allGenderTokens("incorrect value");
			fail("Exception wasn't thrown");
		}catch(IllegalArgumentException e) {
			assertEquals("GENDER NOT FOUND", e.getMessage());
		}
	}

}
