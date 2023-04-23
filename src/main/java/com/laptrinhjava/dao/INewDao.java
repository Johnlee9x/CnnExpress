package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.NewModel;

public interface INewDao extends GenericDao<NewModel> {
	List<NewModel>findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	NewModel findOne(Long id);
	void update(NewModel updateNew);
	void delete(long id);
}
