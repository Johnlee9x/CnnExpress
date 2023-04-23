package com.laptrinhjava.dao.impl;

import java.util.List;

import com.laptrinhjava.dao.INewDao;
import com.laptrinhjava.mapper.NewMapper;
import com.laptrinhjava.model.NewModel;

public class NewDao extends AbstractDao<NewModel> implements INewDao {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid=?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news(title, content,");
		sql.append("categoryid, shortdescription, thumbnail, createddate, createdby)");
		sql.append("VALUES ( ?,?,?,?,?,?,?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), newModel.getCategoryId(),
				newModel.getShortDescription(),newModel.getThumbnail(),
				newModel.getCreatedDate(),newModel.getCreatedBy());
	}
	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id=?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty()?null:news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append("shortdescription = ?, content = ?, categoryid = ?,");
		sql.append("createddate = ?, createdby = ?, modifieddate=?, modifiedby = ?  WHERE id= ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(),
				updateNew.getShortDescription(), updateNew.getContent(), updateNew.getCategoryId(),
				updateNew.getCreatedDate(),updateNew.getCreatedBy(),updateNew.getModifiedDate(),updateNew.getModifiedBy(),updateNew.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id );
		
	}
}
