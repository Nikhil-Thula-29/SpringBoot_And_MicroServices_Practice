package com.main.writer;

import java.util.Iterator;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;


@Component("writer")
public class BookItemWriter implements ItemWriter<String> {

	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		System.out.println("BookItemWriter.write()");
		System.out.println("processed Item: ");
		chunk.forEach(item->{
			System.out.println(item+" ");
		});
		
		
	}

}
