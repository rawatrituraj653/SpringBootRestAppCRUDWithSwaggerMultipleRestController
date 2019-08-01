package com.st.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.model.Item;
import com.st.service.IItemService;

@RestController
@RequestMapping("/rest/item")
public class ItemRestController {

	@Autowired
	private IItemService iservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Item item) {
		Integer id=iservice.itemSave(item);
		ResponseEntity<String> resp=new ResponseEntity<String>(
			"Customer Saved with id :"+id,HttpStatus.OK	);
			return resp;	
	}
	
	@GetMapping("/all")
	public  ResponseEntity<?> getAllCust(){
		ResponseEntity<?> res=null;
		List<Item> list=iservice.getAllItem();
		if(list!=null && !list.isEmpty()) {
			res=new ResponseEntity<List<Item>>(list,HttpStatus.OK);
		}
		else {
			res=new ResponseEntity<String>("No Data Found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOneCust(@PathVariable Integer id){
		ResponseEntity<?> resp=null;
		try {
			Item item= iservice.getOneItem(id);
			resp=new ResponseEntity<Item>(item,HttpStatus.OK);
		}catch(Exception e) {
			resp=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> doUpdate(@RequestBody Item item){
		ResponseEntity<String> resp=null;
		try {
		Integer id=iservice.updateItem(item);
		resp=new ResponseEntity<String>(
			"Updated with id :"+id,HttpStatus.OK	
				);
		}catch (Exception e) {
			resp=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Integer id){

		
		ResponseEntity<String> response=null;
		try {
		iservice.deleteItem(id);
		response=new ResponseEntity<String>("item Deleted with id"+id,HttpStatus.OK);
		}
		catch(Exception e) {
			response=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}

	
}
