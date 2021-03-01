package pl.wpulik.gender_recognizer.datareader;

import java.io.IOException;
import java.util.List;

public interface IFileReader {
	
	boolean isOnList(String token, String fileName)throws IOException;
	
	List<String> allGenderTokens(String fileName)throws IOException;

}
