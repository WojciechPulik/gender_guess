package pl.wpulik.gender_recognizer.service;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.wpulik.gender_recognizer.datareader.IFileReader;

@Service
public class GenderService {
	
	@Qualifier("CsvFileReader")
	private IFileReader iFileReader;
	
	@Autowired
	public GenderService(IFileReader iFileReader) {
		this.iFileReader = iFileReader;
	}
	
	public List<String> allGenderTokens(String gender) {
		if(gender.toLowerCase().equals("female"))
			return tokens(IRecognizer.FEMALE_NAMES);
		if(gender.toLowerCase().equals("male"))
			return tokens(IRecognizer.MALE_NAMES);
		else {
			throw new IllegalArgumentException("GENDER NOT FOUND");
		}
	}
	
	private List<String> tokens(String fileName){
		List<String> resultList = new ArrayList<>();
		try {
			resultList = iFileReader.allGenderTokens(fileName);
		}catch(IOException e) {
			System.err.println("FILE READING ERROR " + e.getMessage());
		}
		return resultList;
	}
	
	
	

}
