package com.selenium;

public class Interview_Program {

	public static void main(String[] args) {

		String str = "This is an Interview";
		System.out.println("Given String: "+str);
		char ch;
		String rstr = "";
		
		for (int i = 0; i < str.length(); i++) {
			
			ch = str.charAt(i);
			rstr = ch + rstr;
			
		}
		
		System.out.println("Reversed String: "+rstr);
		
	}

}
