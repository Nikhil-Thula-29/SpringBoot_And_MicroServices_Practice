package com.nt.runner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Medal;
import com.nt.document.Player;
import com.nt.document.Sport;
import com.nt.service.IOneToManyAssociationService;

@Component
public class OneToManyTestRunner implements CommandLineRunner {

	@Autowired
	private IOneToManyAssociationService serv;
	
	@Override
	public void run(String... args) throws Exception {
		Player player=new Player(1001,"Nikhil Thula","India",25);
		Sport sport1=new Sport(101,"cricket","outdoor",new String[] {"Bat","Ball","Shoes"});
		Sport sport2=new Sport(102,"BasketBall","Indoor",new String[] {"Ball","Basket"});
		Sport sport3=new Sport(103,"FootBall","outdoor",new String[] {"Shoes","Shirts","Ball","GoalNet"});
		Set<Sport> sports=new HashSet<>();
		sports.add(sport1);
		sports.add(sport2);
		sports.add(sport3);
		Set<Medal> medals=new HashSet<>();
		Medal medal1=new Medal(1,"Gold");
		Medal medal2=new Medal(2,"Bronze");
		medals.add(medal1);
		medals.add(medal2);
		player.setSportsInfo(sports);
		player.setMedalsInfo(medals);
		String msg=serv.saveDataUsingPerson(player);
		System.out.println(msg);
	}

}
