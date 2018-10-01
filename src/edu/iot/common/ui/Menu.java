package edu.iot.common.ui;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
public abstract class Menu {
	
	String title;
	List<Menu> menuList;		// Composite 패턴 : 자기 자신을 리스트로 가지는 패턴(recursive)

	public Menu(String title) {
		this.title = title;
	}
	
	public void add(Menu menu) {
		menuList.add(menu);
	}
	
	public abstract void execute() throws Exception;
	
}
