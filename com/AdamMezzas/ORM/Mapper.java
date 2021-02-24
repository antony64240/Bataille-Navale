package com.AdamMezzas.ORM;

import java.util.Iterator;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.ResultSetDynaClass;
import org.apache.commons.beanutils.converters.DateConverter;



public class Mapper<T>
{
	private String className =null;
	
	public Mapper(String className)
	{
		this.className = className;
                ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	}
	public List<T> get(ResultSet resultSet)
	{
		List<T> liste = new ArrayList<T>();
		try
		{
			ResultSetDynaClass rsdc = new ResultSetDynaClass(resultSet);
			@SuppressWarnings("rawtypes")
			Iterator iterator = rsdc.iterator();
			while(iterator.hasNext())
			{		
				try
				{
					DynaBean row = (DynaBean) iterator.next();
					@SuppressWarnings("rawtypes")
					Class beanClass = Class.forName(className);
					Object beanInstance = beanClass.newInstance();
					BeanUtils.copyProperties(beanInstance, row);
					@SuppressWarnings("unchecked")
					T t = (T) beanInstance;
					liste.add(t);
				} 
				catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e)
				{
					e.printStackTrace();
				} 
			}

		} catch (SQLException e)
		{

			e.printStackTrace();
		}
		return liste;
	}
}

