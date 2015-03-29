package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


import com.project.model.Contact;
import com.project.model.Restaurants;
import com.project.util.HibernateUtil;

public class RestaurantsManager extends HibernateUtil {
 
	public List<Restaurants> getRestaurantsList()   {

		List<Restaurants> restaurants = new ArrayList<Restaurants>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			StringBuilder queryString = new StringBuilder();
			
			queryString.append(" SELECT res ")
					   .append(" FROM Restaurants AS res ");
			
			Query queryObject = session.createQuery(queryString.toString());
		

			restaurants= (List<Restaurants>) queryObject.list();	
			
			
		}catch(Exception e){
			System.out.println("exception");
		}
		
		return restaurants;
	}
}