package pl.wpulik.gender_recognizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> genderGuessing(@RequestParam int variant, @RequestParam String fullname) {
		String resultGender = recognizerVariants.chooseVariantGuessing(variant, fullname);
		if(!resultGender.isEmpty())
			return new ResponseEntity<>(resultGender, HttpStatus.FOUND);
		else
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/tokens")
	public ResponseEntity<List<String>> availableTokens(@RequestParam String gender) {
		List<String> resultList = genderService.allGenderTokens(gender);
		if(!resultList.isEmpty())
			return new ResponseEntity<>(resultList, HttpStatus.FOUND);
		else
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
