package edu.iot.common.app;

import edu.iot.common.command.Command;
import edu.iot.common.ui.Menu;
import edu.iot.common.ui.MenuGroup;
import edu.iot.common.ui.MenuItem;

public class TestApp extends Application {

	@Override
	public void createMenu(Menu menu) {
		MenuGroup fileMenu = new MenuGroup("File");
		MenuGroup printMenu = new MenuGroup("Print");
		
		printMenu.add(new MenuItem("Page Setup", null));
		printMenu.add(new MenuItem("Print", null));
		
		fileMenu.add(new MenuItem("Open", null));
		fileMenu.add(new MenuItem("Save", null));
		fileMenu.add(printMenu);
		fileMenu.add(new MenuItem("Exit", new Command() {
			@Override
			public void execute() throws Exception {
				System.out.println("종료합니다");
				System.exit(0);
			}			
		}));
		
		menu.add(fileMenu);
		menu.add(new MenuItem("Help", new Command() {
			@Override
			public void execute() throws Exception {
				System.out.println("TestApp은 도움말이 없습니다");
			}
		}));
		menu.add(new MenuItem("About", new Command() {
			@Override
			public void execute() throws Exception {
				System.out.println("TestApp Ver 0.1");
				System.out.println("created by sieun");
			}
		}));
	}
	
	public static void main(String[] agrs) {
		TestApp app =  new TestApp();
		app.run();
	}

}
