package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Board;
import util.DBManger;
import util.Utils;

//DAO -> DataAccessObject
public class BoardRepository {
	// conn (스트림), pstmt (질의), rs (결과) --> model
	private PreparedStatement pstmt;
	private ResultSet rs;

	// update(게시물수정)
	public int update(Board b) {

		final String SQL = "UPDATE board SET title = ?, content = ? WHERE id = ?";
		Connection conn = DBConnection.getConnection(); //DB연결
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,b.getTitle());
			pstmt.setString(2,b.getContent());
			pstmt.setInt(3,b.getId());
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
	
	// update(조회수증가)
	public int increaseReadCount(int id) {

		final String SQL = "UPDATE board SET readCount = readCount + 1 WHERE id = ?";
		Connection conn = DBConnection.getConnection(); //DB연결
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,id);
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
	
	// delete(삭제하기)
	public int delete(int id) {

		final String SQL = "DELETE FROM board WHERE id = ?";
		Connection conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,id);
			// rs = pstmt.executeQuery(); //select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
			int result = pstmt.executeUpdate(); // insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
			DBManger.dbClose(conn, pstmt);
		}

		return 0;
	}
	
	// view(상세보기)
	public Board findById(int id) {

		final String SQL = "SELECT id, username, title, content, readCount, createDate FROM board WHERE id = ?";
		Connection conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id); // 문장 완성
			rs = pstmt.executeQuery(); // select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
			// pstmt.executeUpdate(); //insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
			if (rs.next()) {
				Board b = new Board();
				b.setId(rs.getInt("id"));
				b.setUsername(rs.getString("username"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setReadCount(rs.getInt("readCount"));
				b.setCreateDate(rs.getString("createDate"));

				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
			DBManger.dbClose(conn, pstmt, rs);

		}

		return null;
	}

	// list(게시판 목록) //페이지 넘버는 0부터 시작
	public List<Board> findAll(int page) {
		final String SQL = "SELECT id, username, title, content, readCount, createDate FROM board ORDER BY id DESC limit ?, 3";
		Connection conn = DBConnection.getConnection();
		List<Board> boards = new ArrayList<Board>();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, page * 3);
			rs = pstmt.executeQuery(); // select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
			// pstmt.executeUpdate(); //insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
			while (rs.next()) {
				Board b = new Board();
				b.setId(rs.getInt("id"));
				b.setUsername(rs.getString("username"));
				b.setTitle(rs.getString("title"));

				String content = rs.getString("content");
				content = Utils.previewText(content);
				b.setContent(content);

				String previewImg = rs.getString("content");
				previewImg = Utils.previewImg(previewImg);
				b.setPreviewImg(previewImg);

				b.setReadCount(rs.getInt("readCount"));
				b.setCreateDate(rs.getString("createDate"));
				boards.add(b);
				System.out.println(b.getContent());
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
			DBManger.dbClose(conn, pstmt, rs);

		}

		return null;
	}
	
	// list(게시판 목록 3개씩)
	public List<Board> findPopularList() {
		final String SQL = "SELECT id, username, title, content, readCount, createDate FROM board ORDER BY readCount DESC limit 3";
		Connection conn = DBConnection.getConnection();
		List<Board> boards = new ArrayList<Board>();
		try {
			pstmt = conn.prepareStatement(SQL); //쿼리문준비
			rs = pstmt.executeQuery(); // select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
			// pstmt.executeUpdate(); //insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
			while (rs.next()) {
				Board b = new Board();
				b.setId(rs.getInt("id"));
				b.setUsername(rs.getString("username"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));

				String previewImg = rs.getString("content");
				previewImg = Utils.previewImg(previewImg);
				b.setPreviewImg(previewImg);

				b.setReadCount(rs.getInt("readCount"));
				b.setCreateDate(rs.getString("createDate"));
				boards.add(b);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
			DBManger.dbClose(conn, pstmt, rs);

		}

		return null;
	}

	// list(게시판 목록 내림차순)
	public List<Board> findAll() {
		final String SQL = "SELECT id, username, title, content, readCount, createDate FROM board ORDER BY id DESC";
		Connection conn = DBConnection.getConnection();
		List<Board> boards = new ArrayList<Board>();
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery(); // select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
			// pstmt.executeUpdate(); //insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
			while (rs.next()) {
				Board b = new Board();
				b.setId(rs.getInt("id"));
				b.setUsername(rs.getString("username"));
				b.setTitle(rs.getString("title"));

				String content = rs.getString("content");
				content = Utils.previewText(content);
				b.setContent(content);

				String previewImg = rs.getString("content");
				previewImg = Utils.previewImg(previewImg);
				b.setPreviewImg(previewImg);

				b.setReadCount(rs.getInt("readCount"));
				b.setCreateDate(rs.getString("createDate"));
				boards.add(b);
				System.out.println(b.getContent());
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try가 끝나면 혹은 catch가 끝나면 실행 = 무조건 실행!!
			DBManger.dbClose(conn, pstmt, rs);

		}

		return null;
	}

	// view(상세보기)
	public int save(Board b) {

		final String SQL = "INSERT INTO board(username, title, content, readCount, createDate) VALUES(?,?,?,0,now())";
		Connection conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, b.getUsername()); // 문장 완성
			pstmt.setString(2, b.getTitle()); // 문장 완성
			pstmt.setString(3, b.getContent()); // 문장 완성
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