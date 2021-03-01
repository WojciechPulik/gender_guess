package pl.wpulik.gender_recognizer.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.wpulik.gender_recognizer.datareader.IFileReader;

@Service
public class AllTokenRecognizer implements IRecognizer{
	
	@Qualifier("CsvFileReader")
	private IFileReader iFileReader;
	
	private static AllTokenRecognizer instance;
	
	@Autowired
	public AllTokenRecognizer(IFileReader iFileReader) {
		this.iFileReader = iFileReader;
	}
	
	@Override
	public void setInstance() {
		instance = this;
	}

	@Override
	public String genderGuessing(String fullname) throws IOException {
		int nFemale = 0;
		int nMale = 0;
		for(String s : fullname.toUpperCase().split(" ")) {
			if(iFileReader.isOnList(s, FEMALE_NAMES))
				nFemale++;
			if(iFileReader.isOnList(s, MALE_NAMES))
				nMale++;
		}
		return resultGender(nFemale, nMale);
	}
	
	private String resultGender(int nFemale, int nMale) {
		if(nFemale>nMale)
			return "FEMALE";
		if(nFemale<nMale)
			return "MALE";
		return "INCONCLUSIVE";		
	}
	
	public static AllTokenRecognizer getInstance() {
		return instance;
	}
	
}
