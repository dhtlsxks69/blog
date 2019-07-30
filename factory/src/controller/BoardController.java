package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8000/factory/board
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String TAG = "BoardController : ";
	
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(TAG+"사용자 요청이 시작되었습니다.");
		request.setCharacterEncoding("UTF-8");
		System.out.println(TAG+"한글 처리 완료됨.");
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+cmd+"요청옴.");
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.router(cmd);
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
