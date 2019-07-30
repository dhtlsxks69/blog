

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//라우팅 임무를 하는 서블릿
@WebServlet("/board")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//스트림에 버퍼를 연결한 것
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<h1> URI ACCESS </h1>");
//		out.println("</body>");
//		out.println("</html>");
//		int number = 10;
//		response.sendRedirect("board.jsp");   // <- 라우팅(분배) 역할
		
//		String uri = request.getRequestURI();
//		String queryString = request.getQueryString();
//		System.out.println(uri);   //uri = /last/board
//		System.out.println(queryString);
//		//1. 자바 결과를 .jsp로 어떻게 넘기는가?
//		//2. 라우팅한다고 했는데 한군데 밖에 안가진다.
//		String arr[] = queryString.split("=");
//		String cmd = arr[1];
//		System.out.println(cmd); //index
		
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("insert")){
			RequestDispatcher dis = request.getRequestDispatcher("board/insert.jsp");
			String name = "JOOHO";
			request.setAttribute("name", name);
			dis.forward(request, response);
//			response.sendRedirect("board/insert.jsp");
		}else if(cmd.equals("delete")){
			response.sendRedirect("board/delete.jsp");
		}else if(cmd.equals("update")){
			response.sendRedirect("board/update.jsp");
		}else if(cmd.equals("select")){
			RequestDispatcher dis = request.getRequestDispatcher("board/select.jsp"); //RequestDispatcher는 톰켓에 있는 request, response를 담고 이동
			int number = 10;
			request.setAttribute("number", number);
			dis.forward(request, response);
//			response.sendRedirect("board/select.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
