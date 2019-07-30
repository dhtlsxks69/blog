public class Test2 {

	public static void main(String[] args) {
		//Max length()는 영어기준 198
		//Max length()는 한글기준 69
			
		String content = "안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하";

		int index = 69;
		while(true){
			if(content.getBytes().length > 198){
				content = content.substring(0, index);
				index--;
			}else{
				content += "...";
				break;
			}
		}

		int len = content.length();
		int byteLen = content.getBytes().length;
		int koreanLen = byteLen - len;
		int englishLen = len - koreanLen;
		System.out.println("길이 : "+len);
		System.out.println("바이트 : "+byteLen);
		System.out.println("한글 : "+ koreanLen);
		System.out.println("영어 : "+ englishLen);
		
		System.out.println(content);
	}

}

