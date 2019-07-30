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
import util.Utils;

public class BoardViewAction implements Action{
	
	private static final String TAG = "BoardViewAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "board/view.jsp";
		
		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println(TAG+"id : "+id);
		
		BoardRepository br = new BoardRepository();
		Board b = br.findById(id);
		
		if(b != null){
			int result = br.increaseReadCount(id);
			if(result != 1){
				Script.back(response);
				return;
			}
		}
		
		//유투브 띄우기
		String content = b.getContent();
		content = Utils.makeYoutube(content);
		b.setContent(content);
		
		request.setAttribute("board", b);
		
		//조회수증가
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}
