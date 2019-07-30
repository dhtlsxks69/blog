package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Utils {
	
	public static String getMyCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			if(c.getName().equals("rememberMe")){
				return c.getValue();
			}
		}
		
		return null;
	}
	
	public static String previewText(String content){
		Document doc = Jsoup.parse(content);
		Element p = doc.selectFirst("p");
		if(p != null){
			String result = p.text();
			result = textSlicing(result);
			result = "<p>" + result + "</p>";
//			System.out.println("not null : "+result);
			return result;
		}else {
//			System.out.println("null : "+content);
			return content;
		}

	}
	
	public static String textSlicing(String content) {
		if(content.length() > 40) {
			content = content.substring(0, 40);			
			content += "...";
		}
		return content;
	}
	
	public static String previewImg(String content){
		Document doc = Jsoup.parse(content);
//		select로 찾으면 배열로 리턴이 됨.
//		Elements es = doc.select("p");
//		Element e = es.get(0);
		Element p = doc.selectFirst("img");
		if(p != null){
			String img = p.attr("src");
//			System.out.println(img);
			return img;
		}
//		System.out.println(content);
		return "/blog/img/home-blog/blog-1.jpg";
	}
	
	public static String makeYoutube(String content){
		Document doc = Jsoup.parse(content);	
		Elements el = doc.select("a");
		if(el == null){
			return content;
		}else{
			for(int i=0; i<el.size(); i++){
				String href = el.get(i).attr("href");
				if(href.contains("youtube.com")){
					String sp[] = href.split("=");
					String v = sp[1];
					String iframe = "<iframe src='https://www.youtube.com/embed/"+v+"' allowfullscreen='' width='600px' height='350px'>";
					System.out.println(iframe);
					el.get(i).after(iframe);
				}
			}
		}
		
		return doc.toString();
	}
}
