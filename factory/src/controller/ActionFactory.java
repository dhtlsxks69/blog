package controller;

public class ActionFactory {
	//싱글톤 패턴
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action router(String cmd){
		if(cmd == null || cmd.equals("")){
			return new HomeAction();
		}else if(cmd.equals("list")){
			return new BoardListAction();
		}else if(cmd.equals("view")){
			return new BoardViewAction();
		}
			return new ErrorAction();
	}
}
