package edu.iot.common.ui;

import org.junit.Test;

public class PromptTest {
	
	@Test
	public void testGetLines() throws Exception {
		Prompt prompt = new Prompt();
		String lines = prompt.getLines("입력");
		System.out.println(lines);
	}

}
