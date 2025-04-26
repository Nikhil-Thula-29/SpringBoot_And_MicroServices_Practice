package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("tourist")
@ConfigurationProperties(prefix="trst.info")
@Data
public class Tourist {

	private Integer tid;
	private String tname;
	private String fromplace;
	private String toplace;
	private Double budget;
	private String packageType;
	
}
