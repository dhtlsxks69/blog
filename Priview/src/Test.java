public class Test {

	public static void main(String[] args) {
		String content = "안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하세요 Hello안녕하";
		int len = content.length();
		int byteLen = content.getBytes().length;
		int koreanLen = byteLen - len;
		int englishLen = len - koreanLen;
		System.out.println("길이 : "+len);
		System.out.println("바이트 : "+byteLen);
		System.out.println("한글 : "+ koreanLen);
		System.out.println("영어 : "+ englishLen);
	}

}

