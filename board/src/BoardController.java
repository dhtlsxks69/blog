

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;

@WebServlet("/controller")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		
		if(cmd == null || cmd.equals("")){
			response.sendRedirect("index.jsp");
		}else if(cmd.equals("list")){
			
			Board b1 = new Board("jooho", "choi", "ssar@nate.com");
			Board b2 = new Board("donggun", "choi", "ssar@nate.com");
			Board b3 = new Board("love", "choi", "ssar@nate.com");
			
			ArrayList<Board> boards = new ArrayList<>();
			boards.add(b1);
			boards.add(b2);
			boards.add(b3);
			
			request.setAttribute("boards", boards);
			
			RequestDispatcher dis = request.getRequestDispatcher("board/list.jsp");
			dis.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
