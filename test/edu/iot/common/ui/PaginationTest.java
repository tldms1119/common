package edu.iot.common.ui;

import java.util.*;
import org.junit.*;

public class PaginationTest {
	
	List<String> list;
	
	@Before
	public void setup() {
		list = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			list.add(i + " 테스트");
		}
	}
	
	@Test
	public void testPagination() throws Exception {
		Pagination<String> page = new Pagination<>(list);
		List<String> pageList = page.getPage();
		
		while(true) {
			for(String str : pageList) {
				System.out.println(str);
			}
			page.printPages();
			
			Prompt prompt = new Prompt();
			String command = prompt.getString("p/n/숫자/q");
			
			if(command.equals("p")) {
				pageList = page.getPage(page.previous());
			} else if(command.equals("n")) {
				pageList = page.getPage(page.next());
			} else if(command.equals("q")) {
				System.out.println("종료합니다");
				break;
			} else {
				pageList = page.getPage(Integer.parseInt(command));
			}
			System.out.println();
		}
	}

}
