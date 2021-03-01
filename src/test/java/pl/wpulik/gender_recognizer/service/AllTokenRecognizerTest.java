package pl.wpulik.gender_recognizer.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AllTokenRecognizerTest {
	
	@Autowired
	AllTokenRecognizer allTokenRecognizer;
	
	@Test
	public void instanceTest() {
		allTokenRecognizer.setInstance();
		assertNotNull(AllTokenRecognizer.getInstance());
	}
	
	@Test
	public void genderGuessingTest()throws IOException {
		String fullname1 = "Wojciech Andrzej Kowalski";
		String fullname2 = "Anna Maria Kowalska";
		String fullname3 = "Anna Andrzej Kowalski";
		String fullname4 = "Wojciech Andrzej Anna Kowalski";
		
		assertFalse(!allTokenRecognizer.genderGuessing(fullname1).equals("MALE"));
		assertFalse(!allTokenRecognizer.genderGuessing(fullname2).equals("FEMALE"));
		assertFalse(!allTokenRecognizer.genderGuessing(fullname3).equals("INCONCLUSIVE"));
		assertFalse(!allTokenRecognizer.genderGuessing(fullname4).equals("MALE"));
	}

}
