
import java.util.*;

public class Viginere
 {
	ArrayList<ArrayList<Character>> viginereSquare;
	public String coder(String message,
						String codeWord,
						int action){
		String value = "";		
		int breaker = 0;
		
		for (int c = 65; c <= 90; c++) {
			System.out.println((char)c);		
			if((char)c == 'Z'){
				breaker = breaker + 1;
				if(breaker == 26){
					break;
				}
				c = 65;
				System.out.println();
				System.out.println((char)c);
			}	
		}

/*
		for (int c = 65; c <= 90; c++) {
			System.out.println((char)c);
			
		}
		*/
		return value;
	}
	
}
