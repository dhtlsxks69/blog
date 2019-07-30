package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import repository.MemberRepository;
import util.Script;
import util.Utils;

public class MemberLoginProcAction implements Action{
	
	private static final String TAG = "MemberLoginProcAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(TAG+"진입");
		String url = "/blog";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//DB연결해서 username, password 동일한 것이 있는지 확인
		MemberRepository mr = new MemberRepository();
		int result = mr.findByUsernameAndPassword(username, password);
		
		//쿠키 체크 확인
		String rememberMe = request.getParameter("rememberMe");
		System.out.println(TAG +"rememberMe : "+rememberMe);
		
		//쿠키 저장
		if(result == 1 && rememberMe != null){
			Cookie c = new Cookie("rememberMe", username);
			c.setMaxAge(6000); //100분
			response.addCookie(c);
		}else{
			//쿠키 삭제
			Cookie c = new Cookie("rememberMe", null);
			c.setMaxAge(0);
			response.addCookie(c);
		}
		
		//인증!! => 세션에 등록
		if(result == 1){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect(url);
		}else{
			Script.back(response, "로그인에 실패하였습니다.");
		}
	}
}
