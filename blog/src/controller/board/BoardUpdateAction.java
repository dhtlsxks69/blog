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

public class BoardUpdateAction implements Action{
	
	private static final String TAG = "BoardUpdateAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "board/update.jsp";
		
		int id = Integer.parseInt(request.getParameter("id"));
		BoardRepository br = new BoardRepository();
		Board b = br.findById(id);
		
		if(b == null){
			Script.back(response, "게시물을 가져오는데 실패하였습니다.");
		}else{
			request.setAttribute("board", b);
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}
	}
}
