package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import repository.DBConnection;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "BoardController : ";
	
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(TAG+"진입(GET)");
		doJoin(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(TAG+"진입(POST)");
		doJoin(request, response);
	}
	
	protected void doJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); //응답 한글처리
		System.out.println(TAG+"한글처리완료(UTF-8)");
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+cmd+"요청옴");
		Action action = BoardFactory.router(cmd);
		action.execute(request, response);
	}

}
