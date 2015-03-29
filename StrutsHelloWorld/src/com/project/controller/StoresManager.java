package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.project.model.Stores;
import com.project.util.HibernateUtil;

public class StoresManager extends HibernateUtil {
 
	public List<Stores> getRestaurantsList()   {

		List<Stores> restaurants = new ArrayList<Stores>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			StringBuilder queryString = new StringBuilder();
			
			queryString.append(" SELECT res ")
					   .append(" FROM Stores AS res ");
			
			Query queryObject = session.createQuery(queryString.toString());
		

			restaurants= (List<Stores>) queryObject.list();	
			
			
		}catch(Exception e){
			System.out.println("exception");
		}
		
		return restaurants;
	}
}