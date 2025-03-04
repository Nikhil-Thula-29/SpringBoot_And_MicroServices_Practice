package com.nt.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Flipkart;

/**
 * Hello world!
 */
public class StratergyDPTest {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
    	Flipkart flip=(Flipkart) ctx.getBean("fp");
        String res=flip.shopping(new String[] {"kurtha,pan,shirt,sweets"}, new double[] {2000,500,1000,200});
        System.out.println(res);
        
    }
}
