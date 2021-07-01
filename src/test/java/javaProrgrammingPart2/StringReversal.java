package javaProrgrammingPart2;

public class StringReversal {

	public static void main(String[] args) {
		
		String str = "I am Dipin";
		
		for(int i = str.length()-1; i>=0; i--) 
			System.out.print(str.charAt(i));
		
		System.out.println();
		
		// OR
		String[] ch = str.split("");
		for(int i = ch.length-1; i>=0; i--) 
			System.out.print(ch[i]);
		
		System.out.println();
		
//		for(String s: ch)
//			System.out.print(s);

	}

}
