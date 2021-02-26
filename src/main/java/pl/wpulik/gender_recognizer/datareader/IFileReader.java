package pl.wpulik.gender_recognizer.datareader;

import java.io.IOException;

public interface IFileReader {
	
	boolean isOnList(String token, String fileName)throws IOException;

}
