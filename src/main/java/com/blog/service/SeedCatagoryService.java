package com.blog.service;

import java.util.List;

import com.blog.dao.SeedCatagoryDAO;
import com.blog.exception.CatagoryInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.Article;
import com.blog.model.SeedCatagory;
import com.blog.validator.SeedCatagoryValidator;

public class SeedCatagoryService {
	public void serviceSave(SeedCatagory catagory) throws ServiceException {
		SeedCatagoryValidator catagoryValidator = new SeedCatagoryValidator();
		SeedCatagoryDAO catagoryDAO = new SeedCatagoryDAO();
		try {
			catagoryValidator.validateSave(catagory);
			catagoryDAO.save(catagory);
		} catch (CatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(SeedCatagory catagory) throws ServiceException {
		SeedCatagoryValidator catagoryValidator = new SeedCatagoryValidator();
		SeedCatagoryDAO catagoryDAO = new SeedCatagoryDAO();
		try {
			catagoryValidator.validateUpdate(catagory);
			catagoryDAO.update(catagory);
		} catch (CatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(SeedCatagory catagory) throws ServiceException {
		SeedCatagoryValidator catagoryValidator = new SeedCatagoryValidator();
		SeedCatagoryDAO catagoryDAO = new SeedCatagoryDAO();
		try {
			catagoryValidator.validateDelete(catagory);
			catagoryDAO.delete(catagory);
		} catch (CatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceListAllCatagories() {
		SeedCatagoryDAO catagoryDAO = new SeedCatagoryDAO();
		catagoryDAO.list();
	}
	public void serviceArticleByCatagory(SeedCatagory catagory) throws ServiceException{
		SeedCatagoryValidator catagoryValidator = new SeedCatagoryValidator();
		SeedCatagoryDAO seedCatagoryDAO = new SeedCatagoryDAO();
		try {
			catagoryValidator.validateList(catagory);
		    List<Article> a=seedCatagoryDAO.getArticlesByCatagory(catagory);
		    for(Article s:a)
				System.out.println(s.getTitle()+" "+s.getContent());
		} catch (CatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
