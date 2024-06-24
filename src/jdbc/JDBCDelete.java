package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCDelete {

	public static void main(String[] args) {
		//delete도 똑같음 - id를 입력받아서, 아이디에 해당하는 데이터를 delete하는 jdbc코드를 작성
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //접속주소
		String uid = "HR"; //계정명
		String upw = "HR"; //비밀번호
		
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디> ");
		String id = scan.next();
		
		String sql = "DELETE FROM MEMBER WHERE ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("딜리트 성공");
			} else {
				System.out.println("딜리트 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e2) {
			}
		}
	}
}
