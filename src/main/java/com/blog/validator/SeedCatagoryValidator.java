
package com.blog.validator;

import org.springframework.stereotype.Repository;

import com.blog.exception.CatagoryInvalidException;
import com.blog.model.SeedCatagory;

@Repository
public class SeedCatagoryValidator {
	

	public void validateSave(SeedCatagory catagory) throws CatagoryInvalidException {
		if (catagory.getCatagory() == null || "".equals(catagory.getCatagory().trim())) {
			throw new CatagoryInvalidException("Invalid Catagory Name");
		} else if (catagory.getUserId().getId() < 0) {
			throw new CatagoryInvalidException("Invalid ID");
		}

	}

	public void validateUpdate(SeedCatagory catagory) throws CatagoryInvalidException {
		if (catagory.getCatagory() == null || "".equals(catagory.getCatagory().trim())) {
			throw new CatagoryInvalidException("Invalid Catagory Name");
		} else if (catagory.getUserId().getId() < 0) {
			throw new CatagoryInvalidException("Invalid ID");
		}
	}

	public void validateDelete(SeedCatagory catagory) throws CatagoryInvalidException {

		if (catagory.getUserId().getId() < 0) {
			throw new CatagoryInvalidException("Invalid ID");
		}
	}
	
	public void validateList(SeedCatagory catagory) throws CatagoryInvalidException {
		if (catagory.getCatagory() == null || "".equals(catagory.getCatagory().trim())) {
			throw new CatagoryInvalidException("Invalid Catagory Name");
		} 
	}
}
