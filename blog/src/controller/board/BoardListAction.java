package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.Board;
import repository.BoardRepository;
import util.Script;

public class BoardListAction implements Action{
	
	private static final String TAG = "HomeAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "board/list.jsp";
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		//모델에 데이터 담아서 이동!!
		BoardRepository br = new BoardRepository();
		List<Board> boards = br.findAll(page);
		
		//인기게시물 3개 담어서 이동!!
		//조회수가 높은순으로 select
		List<Board> popularList = br.findPopularList();
		if(popularList != null){
			int size = popularList.size();
			int count = 3 - size;
			for (int i = 0; i < count; i++) {
				popularList.add(boards.get(i));
			}
		}
		
		if(boards == null){
			Script.back(response);
		}else {
			if(boards.size() == 0){
				Script.back(response);
			}else {
				request.setAttribute("boards", boards);	
				request.setAttribute("popularList", popularList);	
				
				RequestDispatcher dis = request.getRequestDispatcher(url);
				dis.forward(request, response);
			}
		}		
	}
}
