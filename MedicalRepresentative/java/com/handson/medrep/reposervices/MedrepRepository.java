package com.handson.medrep.reposervices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.handson.medrep.model.Medrep;

/*This is the service repository interface containing methods to ease the CRUD operations
using Hibernate*/
@Repository
@Transactional
public interface MedrepRepository extends JpaRepository<Medrep, String>{
	
	
	public Medrep findByrepresentativeEmployeeId(String representativeEmployeeId);

	public List<Medrep> findAll();
}
