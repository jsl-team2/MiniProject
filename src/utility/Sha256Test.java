package utility;

public class Sha256Test {

	public static void main(String[] args) {
		
		String pw = "abc1234";
	      String crypt = SecurityPassword.encoding(pw);
	      System.out.println(crypt);

	}

}
