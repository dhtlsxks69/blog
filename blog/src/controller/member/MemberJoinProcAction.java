package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.Member;
import repository.MemberRepository;
import util.Script;

public class MemberJoinProcAction implements Action{
	
	private static final String TAG = "MemberJoinProcAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "/blog";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		Member m = new Member();
		m.setUsername(username);
		m.setPassword(password);
		m.setEmail(email);
		
		MemberRepository mr = new MemberRepository();
		int result = mr.save(m);
		
		if(result == 1){
			response.sendRedirect(url);			
		}else {
			Script.back(response);
		}
		
	}
}