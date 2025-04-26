package com.main.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//See the flow from notes

@Component("processor")
public class BookItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("BookItemProcessor.process()");
		if(item.equalsIgnoreCase("COREJAVA")) {
			return item+"-----1(COREJAVA)";
		}else if(item.equalsIgnoreCase("SPRINGBOOT")) {
			return item+"-----2(SPRINGBOOT)";
		}
		else if(item.equalsIgnoreCase("Springsecurity")) {
			return item+"----3(Springsecurity)";
		}
		else if(item.equalsIgnoreCase("Springmvc")) {
			return item+"----4(Springmvc)";
		}
		else if(item.equalsIgnoreCase("Springrest")) {
			return item+"----5(Springrest)";
		}
		else {
		return null;
		}
	}

}
