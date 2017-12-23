package com.handson.medrep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebController {
	
	@Autowired
	private MedrepRepository medRepRepository;
	
	MedrepModel fetchMedrep;
 
    // GET operation for fetching details of a single representative
    @GetMapping("/get")
    public MedrepModel getMethod(@RequestParam("ID") int ID) {
    	
    	try
    	{
    	fetchMedrep=medRepRepository.findBymedrepid(ID);
    	System.out.println(fetchMedrep);
    	}
    	catch(Exception e){
    		
    		e.printStackTrace();
    	}
    	return fetchMedrep;
    }
    
    // GET operation for fetching list of all representatives
    @GetMapping("/getall")
    public  List<MedrepModel>  getallMethod() {
    	
    	List<MedrepModel> medrep=new ArrayList<MedrepModel>();
    	try
    	{
    	medrep=medRepRepository.findAll();
    	}
    	catch(Exception e){
    		
    		e.printStackTrace();
    		System.out.println("Query Not executed");
    	}
        
		return medrep;
    }
 
    // POST operation for creating a representative
    @PostMapping("/post")
    public MedrepModel postMethod(@RequestBody MedrepModel medrep) {
    	
    	try
    	{   
    		System.out.println(medrep);
    		medRepRepository.save(medrep);
    		
    		System.out.println("Value successfully posted");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("Value not successfully posted");
    	}
        return medrep;
        
    }
 
    // PUT operation for editing or updating details of a representative
    @PutMapping("/put/{ID}")
    public MedrepModel putMethod(@PathVariable int ID, @RequestBody MedrepModel medrep) {
        
        try{
        	fetchMedrep=medRepRepository.findBymedrepid(ID);
        	medRepRepository.delete(fetchMedrep);
        	medRepRepository.save(medrep);
        }
        catch(Exception e){
        	e.printStackTrace();
            return null;
        }

        return medrep;
    }
 
    // DELETE operation for deleting details of a representative
    @DeleteMapping("/delete/{ID}")
    public String deleteMethod(@PathVariable int ID) {
        try {
        	
        	fetchMedrep=medRepRepository.findBymedrepid(ID);
        	medRepRepository.delete(fetchMedrep);	
        } 
        
        catch (Exception e) {
        	e.printStackTrace();
            return "Error";
        }
 
        return "Done";
    }
 
}
