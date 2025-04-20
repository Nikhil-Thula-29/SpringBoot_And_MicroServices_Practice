package com.nt.writer;




import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class BookInfoItemWriter implements ItemWriter<String> {


	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		System.out.println("BookInfoItemWriter.write()");
        System.out.println("Processed books are:: " + chunk.toString());
		
	}
}

