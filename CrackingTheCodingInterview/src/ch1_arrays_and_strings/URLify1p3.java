package ch1_arrays_and_strings;

public class URLify1p3 {
	
	
	public static void main(String[] args) {
		
		String str = "does this work?";
		System.out.println(makeURL(str));
		
		
		str = " ";
		System.out.println(makeURL(str));
		
		str = "";
		System.out.println(makeURL(str));
		
	}
	
	public static String makeURL(String rawStr) {
		
		// count number of spaces
		int spaceCount = 0;
		for (int i = 0; i < rawStr.length(); ++i) {
			if (rawStr.charAt(i) == ' ') {
				++spaceCount;
			}
		}
		
		char[] newStrArr = new char[rawStr.length() + spaceCount * 2];
		int arrIndex = 0;
		for (int i = 0; i < rawStr.length(); ++i) {
			char ch = rawStr.charAt(i);
			if (ch == ' ') {
				newStrArr[arrIndex++] = '%';
				newStrArr[arrIndex++] = '2';
				newStrArr[arrIndex++] = '0';
			} else {
				newStrArr[arrIndex++] = ch;
			}
		}
		
		return new String(newStrArr);
	}
	
	

}
