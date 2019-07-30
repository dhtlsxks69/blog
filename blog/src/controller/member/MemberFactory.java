package controller.member;

import controller.Action;
import controller.ErrorAction;
import controller.board.BoardListAction;

public class MemberFactory {
	public static Action router(String cmd){
		if (cmd == null || cmd.equals("")){
			//index.jsp
			return new BoardListAction();
		}else if(cmd.equals("login")){
			//board/view.jsp
			return new MemberLoginAction();
			
		}else if(cmd.equals("update")){
			return new MemberUpdateAction();
			
		}else if(cmd.equals("join")){
			return new MemberJoinAction();
			
		}else if(cmd.equals("joinProc")){
			return new MemberJoinProcAction();
			
		}else if(cmd.equals("loginProc")){
			return new MemberLoginProcAction();
			
		}else if(cmd.equals("logout")){
			return new MemberLogoutAction();
			
		}else if(cmd.equals("updateProc")){
			return new MemberUpdateProcAction();
			
		}
		
		return new ErrorAction();
	}
}
