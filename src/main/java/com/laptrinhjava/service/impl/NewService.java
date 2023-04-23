package com.laptrinhjava.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjava.dao.INewDao;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.service.INewService;

public class NewService implements INewService{
	@Inject
	private INewDao newDao;
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}
	@Override
	public NewModel save(NewModel newModle) {
		newModle.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModle.setCreatedBy("");
		Long newId = newDao.save(newModle);
		return newDao.findOne(newId);
	}
	@Override
	public NewModel update(NewModel updateNew) {
		// TODO Auto-generated method stub
		NewModel oldNew = newDao.findOne(updateNew.getId());
		// những cái dữ liệu mới nằm trog updateNew, nhưng còn những fields khác nằm ở oldNew;
		//set lại những fields cũ cho fields mới
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}
	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			newDao.delete(id);
		}
		
	}
	

}
