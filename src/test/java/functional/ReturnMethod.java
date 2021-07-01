package functional;

public class ReturnMethod {

	public static void main(String[] args) {
		System.out.println(addB(1,1));
	}

	public static int add(int i, int j) {
		return i + j;
	}
	
	public static int addB(int i, int j) {
		return add(i,j);
	}

}
