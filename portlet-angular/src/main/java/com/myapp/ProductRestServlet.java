package com.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/products")
public class ProductRestServlet {
	private static final long serialVersionUID = 6748857432950840322L;
	
	private static JSONArray  products = new JSONArray();
	static{
		JSONObject product;
		Random rand = new Random();		
		try{
		   int count = 15;
		   for (int i=0 ; i<count ; i++){
			   product = new JSONObject();
			   product.put("age",rand.nextInt(100));
			   product.put("name","Tablet-" + i);
			   product.put("brand","Sony-" + i);
			   product.put("price",1000 + rand.nextInt(999));			   
		       products.put(product);
		   }		  
		}catch (JSONException jse){}
	}
	
	protected List<Product> generateProducts(){
		List<Product> prds = new ArrayList<Product>();
		Random rand = new Random();
		int count = 15;
		for (int i=0 ; i<count ; i++){
			Product prd = new Product();
		   prd.setAge(rand.nextInt(100));
		   prd.setName("Tablet-" + i);		   
		   prd.setBrand("Sony-" + i);
		   prd.setPrice(1000D + rand.nextInt(999));			   
		   prds.add(prd);
		}			
		return prds;		
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	protected void index(HttpServletRequest request,HttpServletResponse response) {		
		ObjectMapper map = new ObjectMapper();
		try {
			response.setContentType("application/json");
			map.writeValue(response.getOutputStream(),generateProducts());
		    response.setStatus(response.SC_OK);
		} catch (IOException ex) {
			//LOG.error("has thrown an exception: " + ex.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected void create(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//LOG.debug("### entered in ProductServlet... POST");
		String name = request.getParameter("name");
		JSONObject product =new JSONObject();

		Random rand = new Random();
		
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		} catch (Exception e) { /*report an error*/ }
		
		try{		
			product =new JSONObject(jb.toString());			
			product.put("age",rand.nextInt(100));
			product.put("name",product.getString("name"));
			product.put("brand","Sony-" + product.getString("name"));
			product.put("price",1000 + rand.nextInt(999));				   		 
		}catch (JSONException jse){
			jse.printStackTrace();
		}
		
		PrintWriter writer = null;
		try {
			response.setContentType("application/json");
			writer = response.getWriter();		    
		    writer.write(product.toString());
		    writer.flush();
		    response.setStatus(response.SC_OK);
		} catch (IOException ex) {
			//LOG.error("has thrown an exception: " + ex.getMessage());
		}
	}
}
