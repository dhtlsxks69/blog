package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import model.Member;
import repository.MemberRepository;
import util.Script;

public class MemberUpdateAction implements Action{
	
	private static final String TAG = "MemberUpdateAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "member/update.jsp";
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		MemberRepository mr = new MemberRepository();
		Member m = mr.findByUsername(username);
		
		if(m != null){
			request.setAttribute("member", m);
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}else{
			Script.back(response, "회원정보를 찾지 못했습니다.");
		}
	}
}
