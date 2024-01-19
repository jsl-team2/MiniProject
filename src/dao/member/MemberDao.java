package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBmanager;

public class MemberDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int getIdSearch(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select user_id from tbl_user where user_id = ?";
		int result;
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}
		result = 0;
		return result;
	}

	public String emailSend(String email, HttpServletRequest request, HttpServletResponse response) {
		String host = "smtp.naver.com";
	    String user = utility.env.getEmail();
	    String password = utility.env.getPw();

		String to_email = email;

		Properties props = new Properties();
		// Map보다 축소된 기능의 객체. key와 value값에 string만 사용한다
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		StringBuffer temp = new StringBuffer();

		Random rnd = new Random(); // 무작위 10진수

		for (int i = 0; i < 10; i++) {
			int rindex = rnd.nextInt(3); // 0 1 2
			switch (rindex) {
			case 0:
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				// 알파벳 소문자
				break;
			case 1:
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				// 알파벳 대문자
				break;
			case 2:
				temp.append(rnd.nextInt(10));
				// 숫자
				break;
			}
		}

		String AuthenticationKey = temp.toString(); // 인증키
		System.out.println(AuthenticationKey);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			// smtp서버 정보와 사용자 정보를 기반으로 Session 객체 생성
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
				// 사용자를 인정하고 메시지 저장과 전송에 대한 접근을 제어한다
			}
		});

		// 메일 보낼 내용
		try {
			MimeMessage msg = new MimeMessage(session);
			// 제목, 수신자의 이메일 주소, 발송자의 이메일주소, 보낸날짜와 같은 실제 이메일 메세지의 세부사항을 나타낸다
			msg.setFrom(new InternetAddress(user, "GUNTAMS")); // 보내는 사람
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email)); // 받는사람
			msg.setSubject("이메일 인증번호입니다."); // 메일제목
			msg.setText("인증번호 : " + temp + "  >> 복사하여 붙여넣기 하세요");

			Transport.send(msg); // 메세지 전송

			System.out.println("메일전송 완료");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return AuthenticationKey;
	}

	public void setMemberSave(ProjectVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println("sql 전");

		String sql = "insert INTO tbl_user (user_no, user_id, user_pw,user_name,user_phone,user_email,user_address)\r\n"
				+ " VALUES (user_seq.nextval,?,?,?,?,?,?)";

		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getUser_pw());
			pstmt.setString(3, vo.getUser_name());
			pstmt.setString(4, vo.getUser_phone());
			pstmt.setString(5, vo.getUser_email());
			pstmt.setString(6, vo.getUser_address());

			pstmt.executeUpdate();

			System.out.println("업데이트 후");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt);
		}

	}

	public int getMemberLogin(String id, String pw) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select user_id,user_pw from tbl_user where user_id = ?";

		int result = 0; 
			
		try {
			conn = DBmanager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("user_pw") != null && rs.getString("user_pw").equals(pw)) {
					result = 1; // id,pw 같을때
					System.out.println("로그인완료");
				} else {
					result = 0; // pw 같지않을때
					System.out.println("비밀번호가틀렸습니다");
				}
			} else {
				result = -1; // id가 없을때
				System.out.println("id가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getInstance().close(conn, pstmt, rs);
		}

		System.out.println(result);
		return result;
	}

}
//