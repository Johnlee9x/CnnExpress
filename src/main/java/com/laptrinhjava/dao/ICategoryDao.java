package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.CategoryModel;

public interface ICategoryDao extends GenericDao<CategoryModel> {
	List<CategoryModel> findAll();
}
