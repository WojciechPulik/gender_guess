package pl.wpulik.gender_recognizer.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecognizerVariants {
	
	private FirstTokenRecognizer firstTokenRecognizer;
	private AllTokenRecognizer allTokenRecognizer;
	
	@Autowired
	public RecognizerVariants(FirstTokenRecognizer firstTokenRecognizer, 
			AllTokenRecognizer allTokenRecognizer) {
		this.firstTokenRecognizer = firstTokenRecognizer;
		this.allTokenRecognizer = allTokenRecognizer;
	}
	
	public String chooseVariantGuessing(int variant, String fullname)throws IOException {
		switch(variant) {
			case 1:
				return firstTokenRecognizer.genderGuessing(fullname);
			case 2:
				return allTokenRecognizer.genderGuessing(fullname);
			default:
				return "VARIANT NOT FOUND";
		}
	}
	
	
	

}
