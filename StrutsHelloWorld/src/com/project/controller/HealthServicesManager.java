package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.project.model.HealthServices;
import com.project.util.HibernateUtil;

public class HealthServicesManager extends HibernateUtil {
 
	public List<HealthServices> getRestaurantsList()   {

		List<HealthServices> restaurants = new ArrayList<HealthServices>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			StringBuilder queryString = new StringBuilder();
			
			queryString.append(" SELECT res ")
					   .append(" FROM HealthServices AS res ");
			
			Query queryObject = session.createQuery(queryString.toString());
		

			restaurants= (List<HealthServices>) queryObject.list();	
			
			
		}catch(Exception e){
			System.out.println("exception");
		}
		
		return restaurants;
	}
}