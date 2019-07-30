package controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.Board;
import repository.BoardRepository;
import util.Script;

public class BoardUpdateProcAction implements Action{
	
	private static final String TAG = "BoardUpdateProcAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "/blog";
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board b = new Board();
		b.setId(id);
		b.setTitle(title);
		b.setContent(content);
		
		BoardRepository br = new BoardRepository();
		int result = br.update(b);
		
		if(result == 1){
			response.sendRedirect(url);
		}else{			
			Script.back(response, "글쓰기 수정에 실패하였습니다.");
		}
	}
}
