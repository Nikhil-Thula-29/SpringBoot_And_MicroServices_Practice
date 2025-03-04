package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("pinfo")
//@PropertySource("com/nt/commons/myfile.properties")		//It is not best, best is using in xml so that can be used at any where if annotation can be used only in annotations...
public class PersonalInfo {

	//Injecting from property file
	//@Value is mainly used for simple types like String,Long,... but @Autowired is used for objects
	@Value("${per.name}")
	private String name;
	
	@Value("${per.age}")
	private Integer age;
	
	@Value("${per.addrs}")
	private String addrs;
	
	
	//Injecting direct value
	@Value("506002")
	private Long pincode;
	
	//Injecting system property value those value inside will be same names(constant)....
	@Value("${os.name}")		
	private String osName;
	
	@Value("${os.version}")
	private String osVersion;
	
	//Injecting environmental variables
	@Value("${Path}")
	private String pathData;

	@Override
	public String toString() {
		return "PersonalInfo [name=" + name + ", age=" + age + ", addrs=" + addrs + ", pincode=" + pincode + ", osName="
				+ osName + ", osVersion=" + osVersion + ", pathData=" + pathData + "]";
	}
	
	
	
	
}
