package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("menu")
public class HotelMenu {

	@Value("${menu.dosa}")
	public Float dosaprice;
	@Value("${menu.idly}")
	public Float idlyprice;
	@Value("${menu.poha}")
	public Float pohaprice;
	@Value("${menu.vada}")
	public Float vadaprice;
	@Override
	
	
	public String toString() {
		return "HotelMenu [dosaprice=" + dosaprice + ", idlyprice=" + idlyprice + ", pohaprice=" + pohaprice
				+ ", vadaprice=" + vadaprice + "]";
	}
	
	
	
}
