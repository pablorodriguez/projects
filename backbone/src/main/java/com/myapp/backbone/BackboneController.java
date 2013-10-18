package com.myapp.backbone;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("backboneController")
@RequestMapping("VIEW")
public class BackboneController {
	
	@RequestMapping
	public String welcome(RenderRequest request,Model model) throws Exception{	
		return "home";
	}

}
