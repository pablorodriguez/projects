package com.myapp;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("myAppController")
@RequestMapping("VIEW")
public class MyAppController {
	
	@RequestMapping
	public String welcome(RenderRequest request,Model model) throws Exception{	
		return "home";
	}

}
