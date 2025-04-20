package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hotel")
public class HotelInfo {

	@Value("${hotel.name}")
	private String name;
	@Value("${hotel.id}")
	private Integer id;
	@Value("${hotel.location}")
	private String location;
	
	
	@Value("${cust.name}")
	private String custname;
	@Value("#{menu.dosaprice+menu.idlyprice+menu.pohaprice+menu.vadaprice}")	//SPEL for Arithmetic
	private Float bill;
	@Value("${cust.discount}")
	private Float discount;
	//Here bill and discount is of same so spel is not allowing it will allow only outside this class(error).
	//@Value("#{hotel.bill-(hotel.bill*hotel.discount/100)}")
	private Float finalamt;
	
	
	//gets system property value
	@Value("${os.name}")
	private String osName;
	//get env variable value
	@Value("${Path}")
	private String pathData;
	
	
	public Float caldis(float minAmount) {
		if(bill>=minAmount) {
			finalamt=bill-(bill*discount/100f);
		}else {
			finalamt=bill;
		}
		return finalamt;
	}
	
	@Override
	public String toString() {
		return "HotelInfo [name=" + name + ", id=" + id + ", location=" + location + ", custname=" + custname
				+ ", bill=" + bill + ", discount=" + discount + ", osName=" + osName
				+ ", pathData=" + pathData + "]";
	}
	
	
	
}
