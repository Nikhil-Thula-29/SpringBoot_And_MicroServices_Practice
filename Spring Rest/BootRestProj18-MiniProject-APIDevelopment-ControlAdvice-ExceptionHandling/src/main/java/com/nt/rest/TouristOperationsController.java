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

@RestController
@RequestMapping("/tourist-api")
public class TouristOperationsController {

	@Autowired
	private ITouristManagementService serv;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveTourist(@RequestBody Tourist tourist)throws Exception{
			String resultMsg=serv.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);

	}
	
	@GetMapping("/report")
	public ResponseEntity<?> showReport()throws Exception{
			List<Tourist> list=serv.showAllTourist();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/report/{start}/{end}")
	public ResponseEntity<?> showReportByBudget(@PathVariable double start,@PathVariable double end)throws Exception{
		
		List<Tourist> list=serv.showTouristByBudgetRange(start,end);
		return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/report/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable Integer id)throws Exception{
			Tourist tourist=serv.showTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist)throws Exception{
			String msg=serv.modifyTourist(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/pudate/{id}/{percentage}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable int id,@PathVariable double percentage)throws Exception{
			String msg=serv.modifyTouristBudgetById(id, percentage);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable int id)throws Exception{
			String msg=serv.removeTouristById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{type}")
	public ResponseEntity<String> deleteTouristById(@PathVariable String type)throws Exception{

			String msg=serv.removeTouristsByPackageType(type);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
