package pl.wpulik.gender_recognizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.wpulik.gender_recognizer.service.GenderService;
import pl.wpulik.gender_recognizer.service.RecognizerVariants;

@RestController
@RequestMapping("/gender")
public class NameGenderController {
	
	private RecognizerVariants recognizerVariants;
	private GenderService genderService;
	
	@Autowired
	public NameGenderController(RecognizerVariants recognizerVariants, GenderService genderService) {
		this.recognizerVariants = recognizerVariants;
		this.genderService = genderService;
	}

	@PostMapping("/guess")
	public String genderGuessing(@RequestParam int variant, @RequestParam String fullname) {
		String resultGender = recognizerVariants.chooseVariantGuessing(variant, fullname);
		return resultGender;
	}
	
	@PostMapping("/tokens")
	public List<String> availableTokens(@RequestParam String gender) {
		List<String> resultList = genderService.allGenderTokens(gender);
		return resultList;
	}
	

}
