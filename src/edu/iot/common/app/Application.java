package edu.iot.common.app;

import edu.iot.common.ui.Menu;
import edu.iot.common.ui.MenuGroup;

public abstract class Application {

	Menu menu;
	
	public Application() {
		menu = new MenuGroup();			// 최상위 메인 메뉴
		createMenu(menu);
	}
	
	abstract public void createMenu(Menu menu);
	
	public void init() {}
	
	public void run() {					// Template 패턴 사용
		init();
		while(true) {					// 하위 클래스의 모든 execute() 실행이 끝나면 다시 최상위 메뉴 보여주는 loop
			try {
				menu.execute();			// MenuGroup의 execute() 호출(메뉴 보여주기 & 선택)
			} catch (Exception e) {
				System.out.println("명령 실행 에러 : " + e.getMessage());
				//e.printStackTrace();
			}
		}
	}
	
}
