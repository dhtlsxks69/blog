package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import model.Board;
import repository.BoardRepository;
import util.Script;

public class BoardWriteProcAction implements Action{
	
	private static final String TAG = "BoardWriteProcAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "/blog";
		
		//input태그의 name값
		String title = request.getParameter("title");
		//textArea태그의 name값
		String content = request.getParameter("content");
		
		//DB에 반영 (id, username, title, content, readCount, createDate)
		//DB에 실제로 반영할 데이터 (username, title, content)
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		if(username == null){
			Script.info(response, "로그인 후 글쓰기가 가능합니다.", "member/login.jsp");
			return;
		}
		Board b = new Board();
		b.setUsername(username);
		b.setTitle(title);
		b.setContent(content);
		
		BoardRepository br = new BoardRepository();
		//(result == 1) 정상, (result == 2 or -1) 비정상
		int result = br.save(b);
		
		if(result == 1){
			response.sendRedirect(url);
		}else {
			Script.back(response);
		}
		
	}
}
