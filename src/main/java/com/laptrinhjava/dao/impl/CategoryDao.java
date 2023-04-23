package com.laptrinhjava.dao.impl;

import java.util.List;

import com.laptrinhjava.dao.ICategoryDao;
import com.laptrinhjava.mapper.CategoryMapper;
import com.laptrinhjava.model.CategoryModel;

public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao {
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	
}
