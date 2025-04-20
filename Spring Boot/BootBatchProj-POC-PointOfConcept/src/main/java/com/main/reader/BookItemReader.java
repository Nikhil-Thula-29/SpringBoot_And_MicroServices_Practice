package com.main.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;


@Component("reader")
public class BookItemReader implements ItemReader<String>{		//rem itemreader

	
	private String[] books=new String[] {"COREJAVA","SPRINGBOOT","Springsecurity","Springmvc","Springrest"};
	int count=0;
	
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("BookItemReader.read()");		
		if(count<books.length) {
			return books[count++];
			
		}else {
			return null;
		}
	}

}
