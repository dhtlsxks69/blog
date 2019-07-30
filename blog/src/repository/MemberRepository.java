package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Board;
import model.Member;
import util.DBManger;

//DAO -> DataAccessObject
public class MemberRepository {
	//conn (스트림), pstmt (질의), rs (결과) --> model
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// login(로그인)
	public int findByUsernameAndPassword(String username, String password) {
		final String SQL = "SELECT count(id) FROM member WHERE username = ? AND password = ?";
		Connection conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, username); // 문장 완성
			pstmt.setString(2, password); // 문장 완성
			rs = pstmt.executeQuery(); // select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
			// pstmt.executeUpdate(); //insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
			if (rs.next()) {
				//인증완료
				int result = rs.getInt(1);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
			DBManger.dbClose(conn, pstmt, rs);
		}
		return -1;
	}
	
	// join(회원가입)
		public int save(Member m){
			
			final String SQL = "INSERT INTO member(username, password, email, createDate) VALUES(?,?,?,now())";
			Connection conn = DBConnection.getConnection();
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, m.getUsername()); //문장 완성
				pstmt.setString(2, m.getPassword()); //문장 완성
				pstmt.setString(3, m.getEmail()); //문장 완성
//				rs = pstmt.executeQuery(); //select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
				int result = pstmt.executeUpdate(); //insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			} finally { //try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
				DBManger.dbClose(conn, pstmt);
			}
			
			return -1;
		}
		
		// update(회원정보수정페이지)
		public Member findByUsername(String username){
			
			final String SQL = "SELECT username, password, email FROM member WHERE username = ?";
			Connection conn = DBConnection.getConnection();
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, username); // 문장 완성
				rs = pstmt.executeQuery(); //select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
//				int result = pstmt.executeUpdate(); //insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
				if(rs.next()){
					Member m = new Member();
					m.setUsername(rs.getString("username"));
					m.setPassword(rs.getString("password"));
					m.setEmail(rs.getString("email"));
					
					return m;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally { //try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
				DBManger.dbClose(conn, pstmt, rs);
			}
			
			return null;
		}
		
		// update(회원정보수정)
		public int update(Member m) {

			final String SQL = "UPDATE member SET password = ?, email = ? WHERE username = ?";
			Connection conn = DBConnection.getConnection(); //DB연결
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, m.getPassword());
				pstmt.setString(2, m.getEmail());
				pstmt.setString(3, m.getUsername());
				// rs = pstmt.executeQuery(); //select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
				int result = pstmt.executeUpdate(); // insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			} finally { // try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
				DBManger.dbClose(conn, pstmt);
			}

			return -1;
		}
}
