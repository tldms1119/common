package edu.iot.common.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Prompt {
	
	private Scanner scanner;
	
	public Prompt() {
		scanner = new Scanner(System.in);
	}
	
	public String getString(String prompt) {
		System.out.print(prompt + " : ");
		return scanner.nextLine();
	}
	
	public int getInt(String prompt) {
		String str = getString(prompt);
		return Integer.parseInt(str);
	}
	
	public Date getDate(String prompt) throws ParseException {
		String str = getString(prompt + "(yyyy-MM-dd)");
		if(str.equals("")) {
			return new Date(); // 오늘 날짜
		} 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);	
	}
	
	public Date getDate(String prompt, String pattern) throws ParseException {
		String str = getString(prompt + pattern);
		if(str.equals("")) {
			return new Date(); // 오늘 날짜
		} 
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(str);	
	}
	
	public String getLines(String prompt) {
		System.out.print(prompt + " : ");
		StringBuilder sb = new StringBuilder();

		while(true) {
			String temp = scanner.nextLine();
			if(temp.equalsIgnoreCase("end")) {
				break;
			}
			sb.append(temp + "\r\n");
		}
		return sb.toString();
	}
	
	public <T> int selectList(String prompt, List<T> list) {
		System.out.println("==========================================");
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%2d)%s\n", i, list.get(i).toString());
		}
		System.out.println("==========================================");
		String str = getString(prompt);
		if(str.equals("q")) {
			return -1;
		}
		return Integer.parseInt(str);
	}

}
