package com.laptrinhjava.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.ICategoryDao;
import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.service.ICategoryService;

public class CategoryService implements ICategoryService {
	//nhung categoryDao vao trong service;
	/*public ICategoryDao categoryDao;
	public CategoryService(){
		categoryDao = new CategoryDao();
	}*/
	@Inject
	public ICategoryDao categoryDao;//nhung categoryDao vao trong CategoryService
	@Override
	public List<CategoryModel> findAll(){
		return categoryDao.findAll();
	}
}
