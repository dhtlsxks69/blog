package controller.board;

import controller.Action;
import controller.ErrorAction;

public class BoardFactory {
	public static Action router(String cmd){
		if (cmd == null || cmd.equals("") || cmd.equals("list")){
			//index.jsp
			return new BoardListAction();
		}else if(cmd.equals("view")){
			//board/view.jsp
			return new BoardViewAction();
			
		}else if(cmd.equals("update")){
			return new BoardUpdateAction();
			
		}else if(cmd.equals("write")){
			//글쓰기 페이지로 이동
			return new BoardWriteAction();
			
		}else if(cmd.equals("writeProc")){
			//글쓰기로 DB에 반영
			return new BoardWriteProcAction();
			
		}else if(cmd.equals("delete")){
			return new BoardDeleteAction();
			
		}else if(cmd.equals("updateProc")){
			return new BoardUpdateProcAction();
		}
		
		return new ErrorAction();
	}
}
