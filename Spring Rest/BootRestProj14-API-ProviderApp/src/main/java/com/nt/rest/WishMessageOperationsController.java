package com.nt.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/wish-api")
public class WishMessageOperationsController {

	@GetMapping("/wish")
	public ResponseEntity<String> showWishMessage(){
		return new ResponseEntity<String>("Good Night",HttpStatus.OK);
	}
	
	
	@GetMapping("/wish1/{id}/{name}")
	public ResponseEntity<String> showWishMessage1(@PathVariable Integer id,@PathVariable String name){
		return new ResponseEntity<String>("Good Night.. "+id+"......"+name,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){//@RequestBody converts the post method json body to actor object
		return new ResponseEntity<String>(actor.toString(),HttpStatus.CREATED);	//response as string
	}
	
	
	@GetMapping("/report")
	public ResponseEntity<Actor> showReport(){
		Actor actor=new Actor(1001,"raja","hyd",65623.0);
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	
	@GetMapping("/reportAll")
	public ResponseEntity<List<Actor>> showAllReports(){
		Actor actor1=new Actor(1001,"raja","hyd",65623.0);
		Actor actor2=new Actor(1002,"kiran","wgl",36552.0);
		Actor actor3=new Actor(1003,"ganesh","kgr",9851.0);
		Actor actor4=new Actor(1004,"venkat","ald",7846.0);
		List<Actor> list=List.of(actor1,actor2,actor3,actor4);
		return new ResponseEntity<List<Actor>>(list,HttpStatus.OK);
	}
}
