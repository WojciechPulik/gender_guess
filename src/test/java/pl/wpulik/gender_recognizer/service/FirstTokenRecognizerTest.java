package pl.wpulik.gender_recognizer.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirstTokenRecognizerTest {
	
	@Autowired
	FirstTokenRecognizer firstTokenRecognizer;
	
	@Test
	public void instanceTest() {
		firstTokenRecognizer.setInstance();
		assertNotNull(FirstTokenRecognizer.getInstance());
	}
	
	@Test
	public void genderGuessingTest()throws IOException {
		String fullname1 = "Wojciech Kowalski";
		String fullname2 = "Anna Kowalska";
		String fullname3 = "Anna Andrzej Kowalski";
		
		assertFalse(!firstTokenRecognizer.genderGuessing(fullname1).equals("MALE"));
		assertFalse(!firstTokenRecognizer.genderGuessing(fullname2).equals("FEMALE"));
		assertFalse(!firstTokenRecognizer.genderGuessing(fullname3).equals("FEMALE"));
	}

}
