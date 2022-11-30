package wordMatchingGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {

	
	public static String askInput() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try{
			return input.readLine();
		} catch (Exception e) {
			return "";
		}
	}
	
}
