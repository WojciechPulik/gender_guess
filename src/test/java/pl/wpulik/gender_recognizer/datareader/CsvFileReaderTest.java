package pl.wpulik.gender_recognizer.datareader;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pl.wpulik.gender_recognizer.service.IRecognizer;

@SpringBootTest
public class CsvFileReaderTest {
	
	String maleFileName = IRecognizer.MALE_NAMES;
	String femaleFileName = IRecognizer.FEMALE_NAMES;
	
	@Autowired
	CsvFileReader csvFileReader;
	
	@Test
	public void isOnListTest() throws IOException {
		String maleName = "ANDRZEJ";
		String femaleName = "TOLA";
		String notName = "XYZnonExistingFirstName";
			
		assertFalse(!csvFileReader.isOnList(maleName, maleFileName));
		assertFalse(!csvFileReader.isOnList(femaleName, femaleFileName));
		assertFalse(csvFileReader.isOnList(notName, femaleFileName));		
	}
	
	@Test
	public void allGenderTokensTest()throws IOException {
		assertNotNull(csvFileReader.allGenderTokens(femaleFileName));
		assertNotNull(csvFileReader.allGenderTokens(maleFileName));
		assertFalse(csvFileReader.allGenderTokens(femaleFileName).isEmpty());
		assertFalse(csvFileReader.allGenderTokens(maleFileName).isEmpty());
	}

}
