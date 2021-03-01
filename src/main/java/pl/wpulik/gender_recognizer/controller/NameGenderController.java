package pl.wpulik.gender_recognizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.wpulik.gender_recognizer.service.RecognizerVariants;

@RestController
@RequestMapping("/gender")
public class NameGenderController {
	
	private RecognizerVariants recognizerVariants;
	
	@Autowired
	public NameGenderController(RecognizerVariants recognizerVariants) {
		this.recognizerVariants = recognizerVariants;
	}

	@PostMapping("/guess")
	public String genderGuessing(@RequestParam int variant, @RequestParam String fullname) {
		String resultGender = recognizerVariants.chooseVariantGuessing(variant, fullname);
		return resultGender;
	}
	

}
