package utility;

import java.security.MessageDigest;

public class SecurityPassword {

	
	public static String encoding(String pw) {
		
		String newPw = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			//암호화 하는 패스워드 update() 메서드를 이용하여 전달 
			byte[] encodeData = md.digest();
			//암호화 된 값을 가져와서 바이트 배열로 변환하여 저장
			for(int i=0; i < encodeData.length; i++) {
				newPw += Integer.toHexString(encodeData[i]&0xFF);
				//바이트 데이터를 16진수 문자열로 변환, 문자열에 추가(한번 더 암호화)
				//Integer.toHexString 문자열로 변환 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPw;
	}
	
}
