package pl.wpulik.gender_recognizer.service;

import java.io.IOException;

public interface IRecognizer {
	
	String FEMALE_NAMES = "src/main/resources/static/datafiles/female_names.csv";
	String MALE_NAMES = "src/main/resources/static/datafiles/male_names.csv";
	
	String genderGuessing(String fullname)throws IOException;
	
	void setInstance();

}
