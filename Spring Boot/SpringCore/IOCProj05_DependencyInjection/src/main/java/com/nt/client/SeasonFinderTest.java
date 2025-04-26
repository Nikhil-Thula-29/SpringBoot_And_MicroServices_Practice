package com.nt.client;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.SeasonFinder;

public class SeasonFinderTest {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
        SeasonFinder sf=(SeasonFinder) ctx.getBean("sf");
        String res=sf.findseason("Nikhil Thula");
        System.out.println(res);
        
    }
}
