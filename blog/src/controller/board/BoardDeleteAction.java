package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.Board;
import repository.BoardRepository;
import util.Script;

public class BoardDeleteAction implements Action{
	
	private static final String TAG = "BoardDeleteAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "/blog";
		
		//request로 받기
		int id = Integer.parseInt(request.getParameter("id"));
		
		//DB접속해서 삭제!! ==> return 1이면 정상, 2or-1이면 오류
		BoardRepository br = new BoardRepository();
		int result = br. delete(id);
		
		//if문 필요!!
		if(result == 1){
			//이동(성공)
			response.sendRedirect(url);			
		}else{
			//이동(실패)
			Script.back(response, "글쓰기에 실패하였습니다.");
		}
		
	}
}
