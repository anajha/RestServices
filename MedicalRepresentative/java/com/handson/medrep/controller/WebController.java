package com.handson.medrep.controller;

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

import com.handson.medrep.model.Medrep;
import com.handson.medrep.reposervices.MedrepRepository;


@RestController
public class WebController {
	
	/*Autowiring ensures that the object of the service repository below
	is automatically created by Spring framework*/
	@Autowired
	private MedrepRepository medRepRepository;
	
    Medrep fetchMedrep;
 
    // GET operation for fetching details of a single representative
    @GetMapping("/get")
    public Medrep getMethod(@RequestParam("ID") String ID) {
    	
    	
    	fetchMedrep=medRepRepository.findByrepresentativeEmployeeId(ID);
    	return fetchMedrep;
    }
    
    // GET operation for fetching list of all representatives
    @GetMapping("/getall")
    public  List<Medrep>  getallMethod() {
    	List<Medrep> medrep=medRepRepository.findAll();
        return medrep;
    }
 
    // POST operation for creating a representative
    @PostMapping("/post")
    public Medrep postMethod(@RequestBody Medrep medrep) {
    	
    	medRepRepository.save(medrep);
        return medrep;
        
    }
 
    // PUT operation for editing or updating details of a representative
    @PutMapping("/put/{ID}")
    public Medrep putMethod(@PathVariable String ID, @RequestBody Medrep medrep) {
        
        try{
        	fetchMedrep=medRepRepository.findByrepresentativeEmployeeId(ID);
        	medRepRepository.delete(fetchMedrep);
        	medRepRepository.save(medrep);
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }

        return medrep;
    }
 
    // DELETE operation for deleting details of a representative
    @DeleteMapping("/delete/{ID}")
    public String deleteMethod(@PathVariable String ID) {
        try {
        	
        	fetchMedrep=medRepRepository.findByrepresentativeEmployeeId(ID);
        	medRepRepository.delete(fetchMedrep);	
        } 
        
        catch (Exception e) {
            return "Error";
        }
 
        return "Done";
    }
 
}
