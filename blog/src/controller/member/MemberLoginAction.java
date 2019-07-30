package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import util.Utils;

public class MemberLoginAction implements Action{
	
	private static final String TAG = "MemberLoginAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "member/login.jsp";
		
		String rememberMe = Utils.getMyCookie(request);
		
		if(rememberMe != null){
			request.setAttribute("rememberMe", rememberMe);
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}else{
			response.sendRedirect(url);			
		}
	}
}
