package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristManagementService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tourist-api")
public class TouristOperationsController {

	@Autowired
	private ITouristManagementService serv;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveTourist(@RequestBody Tourist tourist){
		try {
			String resultMsg=serv.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> showReport(){
		try {
			List<Tourist> list=serv.showAllTourist();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report/{start}/{end}")
	public ResponseEntity<?> showReportByBudget(@PathVariable double start,@PathVariable double end){
		try {
		List<Tourist> list=serv.showTouristByBudgetRange(start,end);
		return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report/{id}")
	@Operation(summary = "Get item by id", description = "Fetches a item by id")
	public ResponseEntity<?> displayTouristById(@PathVariable Integer id){
		try {
			Tourist tourist=serv.showTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		try {
			String msg=serv.modifyTourist(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/pudate/{id}/{percentage}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable int id,@PathVariable double percentage){
		try {
			String msg=serv.modifyTouristBudgetById(id, percentage);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable int id){
		try {
			String msg=serv.removeTouristById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/remove/{type}")
	public ResponseEntity<String> deleteTouristById(@PathVariable String type){
		try {
			String msg=serv.removeTouristsByPackageType(type);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
