package pl.wpulik.gender_recognizer.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.wpulik.gender_recognizer.datareader.IFileReader;

@Service
public class FirstTokenRecognizer implements IRecognizer{
	
	@Qualifier("CsvFileReader")
	private IFileReader iFileReader;
	
	private static FirstTokenRecognizer instance;
	
	@Autowired
	public FirstTokenRecognizer(IFileReader iFileReader) {
		this.iFileReader = iFileReader;
	}
	
	@Override
	public void setInstance() {
		instance = this;
	}
	
	@Override
	public String genderGuessing(String fullname)throws IOException {
		String token = getFirstName(fullname).toUpperCase();
		String gender = "INCONCLUSIVE";
		if(iFileReader.isOnList(token, MALE_NAMES))
			gender = "MALE";
		if(iFileReader.isOnList(token, FEMALE_NAMES))
			gender = "FEMALE";
		return gender;
	}
	
	private String getFirstName(String fullname) {
		return fullname.split(" ")[0];
	}
	
	public static FirstTokenRecognizer getInstance() {
		return instance;
	}

}
