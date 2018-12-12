package com.core.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.core.pageModel.PageHelper;

public interface BaseDao<T> {

	public void add(T t);

	public T queryById(Object id);

	public void update(T t);

	public void updateBySelect(T t);

	public void delete(Object id);

	public Long queryCount(@Param("entity") T t);

	public List<T> queryList(@Param("entity") T t,
			@Param("page") PageHelper page);
	
	public List<T> queryByObject(@Param("entity") T t);

}
