package com.nt.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.Flipkart;
import com.nt.ston.Printer;

/**
 * Hello world!
 */
public class StratergyDPTest {
    public static void main(String[] args) {
    	//relative Path(relative to eclipse)
        //FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");		//relative Path
        
    	//(or)
    	
    	//Absolute Path(Full adress-->alt+enter)
    	//FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("F:\\Nikhil Spring Boot and Microservices Projects\\SpringCore\\IOCProj06_StratergyDP-FactoryDP-UsingSpring\\src\\main\\java\\com\\nt\\cfgs\\applicationContext.xml");
       
    	//In classpath already src/main/java is included so no need to write check in build path->source
    	//We can make com.nt.cfgs as src file by right click on package build path make as source.
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    	
    	Flipkart flip=(Flipkart) ctx.getBean("fp");
    	Flipkart flip1=(Flipkart) ctx.getBean("fp");
        String res=flip.shopping(new String[] {"kurtha,pan,shirt,sweets"}, new double[] {2000,500,1000,200});
        System.out.println(res);
        System.out.println(flip.hashCode()+" "+flip1.hashCode());
        
        System.out.println("=======================");
        
        //Here singleton scope is broken because of two ids 
        //By keeping factory-method="getInstance" in xml bean tag  will make to single ton
        
        Printer prn1=ctx.getBean("p1",Printer.class);
        Printer prn2=ctx.getBean("p2",Printer.class);
        System.out.println(prn1.hashCode()+" "+prn2.hashCode());
        
    }
}
