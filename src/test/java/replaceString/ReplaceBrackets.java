package replaceString;

import java.time.LocalDateTime;

public class ReplaceBrackets {

	public static void main(String[] args) {
		
		String str = "[1,2,3]";
		System.out.println(str.replaceAll("[\\[\\]]", ""));
		
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now().toString().replaceAll("\\W", "_"));

	}

}
