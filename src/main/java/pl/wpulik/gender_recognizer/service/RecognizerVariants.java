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
	
	public String chooseVariantGuessing(int variant, String fullname){
		setInstances();
		IRecognizer instance = Variants.setVariant(variant).getInstance();
		try {
			return instance.genderGuessing(fullname);
		} catch (IOException e) {
			System.err.println("FILE READING ERROR " + e.getMessage());
			return "INCONCLUSIVE";
		}	
	}
	
	private void setInstances() {
		firstTokenRecognizer.setInstance();
		allTokenRecognizer.setInstance();
	}
	
	

}
