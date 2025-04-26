package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("petrol")
@Lazy	//Even thought we wrote @lazy it will inject when we use it when we are not using it will initiate lazyly.
public class PetrolEngine implements Engine {
	
	public PetrolEngine() {
		System.out.println("0-param Petrol Engine");
	}

	@Override
	public void start() {
		System.out.println("Petrol Engine has Started");

	}

	@Override
	public void stop() {
		System.out.println("Petrol Engine has Stopped");

	}

}
