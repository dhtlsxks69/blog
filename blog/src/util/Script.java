package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void back(HttpServletResponse response) throws IOException{  //함수 자체에 try-catch
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("history.back()");
		out.println("</script>");
	}
	
	public static void back(HttpServletResponse response, String msg) throws IOException{  //함수 자체에 try-catch
		PrintWriter out = response.getWriter(); 
		out.println("<script>");
		out.println("alert('"+msg+"')");
		out.println("history.back();");
		out.println("</script>");
	}
	
	public static void info(HttpServletResponse response, String msg, String url) throws IOException{  //함수 자체에 try-catch
		PrintWriter out = response.getWriter(); 
		out.println("<script>");
		out.println("alert('"+msg+"')");
		out.println("location.href='"+url+"'");
		out.println("</script>");
	}
}
