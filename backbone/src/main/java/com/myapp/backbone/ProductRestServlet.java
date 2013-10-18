package com.myapp.backbone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/products.do")
public class ProductRestServlet {
	private static final long serialVersionUID = 6748857432950840322L;
	
	@RequestMapping(method = RequestMethod.GET)
	protected void index(HttpServletRequest request,HttpServletResponse response) {
		JSONArray  products = new JSONArray();
		JSONObject product;
		
		PrintWriter writer = null;
		try
		{
		   int count = 15;

		   for (int i=0 ; i<count ; i++)
		   {
			   product = new JSONObject();
			   product.put("name","Tablet-" + i);
			   product.put("brand","Sony-" + i);
			   product.put("price","$ 1.888");
		       products.put(product);
		   }
		  
		}
		catch (JSONException jse){}
		
		try {
			response.setContentType("application/json");
			writer = response.getWriter();		    
		    writer.write(products.toString());
		    writer.flush();
		    response.setStatus(response.SC_OK);
		} catch (IOException ex) {
			//LOG.error("has thrown an exception: " + ex.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected void create(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//LOG.debug("### entered in ProductServlet... POST");
		PrintWriter writer = null;
		try {
		    writer = response.getWriter();
		} catch (IOException ex) {
			//LOG.error("has thrown an exception: " + ex.getMessage());
		}
		writer.print("You call http method POST");
		response.setStatus(response.SC_OK);
	}
}
