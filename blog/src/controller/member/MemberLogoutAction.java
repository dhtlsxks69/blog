package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import repository.MemberRepository;
import util.Script;

public class MemberLogoutAction implements Action{
	
	private static final String TAG = "MemberLogoutAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "/blog";
		
		HttpSession session = request.getSession();
		session.invalidate(); //세션 무효화
//		session.removeAttribute("username");  //특정세션 삭제
		
		response.sendRedirect(url);
	}
}
