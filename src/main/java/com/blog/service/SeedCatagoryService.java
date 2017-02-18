package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.SeedCatagoryDAO;
import com.blog.exception.CatagoryInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.Article;
import com.blog.model.SeedCatagory;
import com.blog.validator.SeedCatagoryValidator;

@Service
public class SeedCatagoryService {
	@Autowired
	SeedCatagoryValidator catagoryValidator = new SeedCatagoryValidator();
	@Autowired
	SeedCatagoryDAO catagoryDAO = new SeedCatagoryDAO();
	public void serviceSave(SeedCatagory catagory) throws ServiceException {
		
		try {
			catagoryValidator.validateSave(catagory);
			catagoryDAO.save(catagory);
		} catch (CatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(SeedCatagory catagory) throws ServiceException {
		
		try {
			catagoryValidator.validateUpdate(catagory);
			catagoryDAO.update(catagory);
		} catch (CatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(SeedCatagory catagory) throws ServiceException {
		
		try {
			catagoryValidator.validateDelete(catagory);
			catagoryDAO.delete(catagory);
		} catch (CatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceListAllCatagories() {
		catagoryDAO.list();
	}
	
	public void serviceArticleByCatagory(SeedCatagory catagory) throws ServiceException{
		
		try {
			catagoryValidator.validateList(catagory);
		    List<Article> a=catagoryDAO.getArticlesByCatagory(catagory);
		    for(Article s:a)
				System.out.println(s.getTitle()+" "+s.getContent());
		} catch (CatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
