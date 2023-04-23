package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.model.NewModel;

public interface INewService {
	List<NewModel>findByCategoryId(Long categoryId);
	NewModel save (NewModel newModle);
	NewModel update(NewModel updateNew);
	void delete(long[] ids);
}
