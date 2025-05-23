package com.nt.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class BookInfoItemReader implements ItemReader<String> {
	
	private String books[]=new String[] {"TIJ","CRJ","EJ","BBJ","HFJ"};	//Source Repository
	int count=0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("BookInfoItemReader.read()");
		if(count<books.length) {
			return books[count++];
		}
		else {
			return null;
		}
	}

}
