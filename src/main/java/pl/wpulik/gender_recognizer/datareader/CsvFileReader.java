package pl.wpulik.gender_recognizer.datareader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class CsvFileReader implements IFileReader{

	@Override
	public boolean isOnList(String token, String fileName) throws IOException{
		
		var reader = new BufferedReader(new FileReader(fileName));
		String line = "";
		boolean isNext = true;
		while(isNext) {
			line = reader.readLine();
			if(token.equals(line)) {
				reader.close();
				return true;
			}	
			if(line==null)
				isNext = false;
		}
		reader.close();
		return false;
	}

}
