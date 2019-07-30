package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//상세보기
public class BoardViewAction implements Action{
	private static final String TAG = "BoardViewAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(TAG+"진입");
		String url = "board/view.jsp";
		response.sendRedirect(url);
	}
}
