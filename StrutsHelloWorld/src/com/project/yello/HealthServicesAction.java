package com.project.yello;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.project.controller.HealthServicesManager;
import com.project.geoCoding.AddressConverter;
import com.project.geoCoding.DisplayResult;
import com.project.geoCoding.GoogleResponse;
import com.project.geoCoding.Result;
import com.project.model.HealthServices;
import com.project.model.Restaurants;

public class HealthServicesAction extends ActionSupport {
	 
    private static final long serialVersionUID = 9149826260758390091L;
    private HealthServices restaurants;
    private List<HealthServices> restaurantsList = new ArrayList<HealthServices>();
    private Long res_id;
    private String resName;
    private String resAddress;
    private String resPhoneNo;
    private String resReserveOne;
    private Result convertedAddresses;
 
    private HealthServicesManager restaurantsManager= new HealthServicesManager();
    private AddressConverter addressConverter = new AddressConverter();
    
    private List<Result> allAddressResult = new ArrayList<Result>();
    
    private JSONObject jsonObj  = new JSONObject();
    
    private DisplayResult dispResult;
    int index= 0;
    

	public String convertAddress(){ 
    	
    	restaurantsList = restaurantsManager.getRestaurantsList();
    	
    	
    	for(HealthServices restaurant: restaurantsList){ 
    		
    		String address = restaurant.getResAddress();
    		dispResult = new DisplayResult();
    		String json = null;
    		 try {
				GoogleResponse response = addressConverter.convertToLatLong(address);
				
				if(response.getStatus().equals("OK"))
				  {
				   for(Result result : response.getResults())
				   {
//				    System.out.println("Lattitude of address is :"  +result.getGeometry().getLocation().getLat());
//				    System.out.println("Longitude of address is :" + result.getGeometry().getLocation().getLng());
//				    System.out.println("Location is " + result.getGeometry().getLocation_type());
//				    System.out.println("Value of Formatted Address is " + result.getFormatted_address());
//				    System.out.println("Value of Partial match is " + result.isPartial_match());
				    
				    dispResult.setAddress(restaurant.getResName()+" "+restaurant.getResAddress());
				    dispResult.setLatitude(result.getGeometry().getLocation().getLat());
				    dispResult.setLongitude(result.getGeometry().getLocation().getLng());
				    
				    json = dispResult.getAddress()+"|"+dispResult.getLatitude()+"|"+dispResult.getLongitude();
				   }
				  }
				  else
				  {
				   System.out.println(response.getStatus());
				  }
				jsonObj.put(index+"", json);
				index++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	
    	return SUCCESS;
    }
    
	public List<Result> getAllAddressResult() {
		return allAddressResult;
	}

	public void setAllAddressResult(List<Result> allAddressResult) {
		this.allAddressResult = allAddressResult;
	}


	public Long getRes_id() {
		return res_id;
	}

	public void setRes_id(Long res_id) {
		this.res_id = res_id;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getResPhoneNo() {
		return resPhoneNo;
	}

	public void setResPhoneNo(String resPhoneNo) {
		this.resPhoneNo = resPhoneNo;
	}

	public String getResReserveOne() {
		return resReserveOne;
	}

	public void setResReserveOne(String resReserveOne) {
		this.resReserveOne = resReserveOne;
	}
 
    public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public HealthServices getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(HealthServices restaurants) {
		this.restaurants = restaurants;
	}

	public List<HealthServices> getRestaurantsList() {
		return restaurantsList;
	}

	public void setRestaurantsList(List<HealthServices> restaurantsList) {
		this.restaurantsList = restaurantsList;
	}
  
	
	
}