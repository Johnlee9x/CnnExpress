package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.NewModel;



public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel news = new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			return news;
		} catch (SQLException e) {
			return null;
		}
	}

}
