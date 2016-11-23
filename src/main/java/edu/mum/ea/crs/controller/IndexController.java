package edu.mum.ea.crs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends GenericController {

	@RequestMapping("/")
	public String welcomePage() {
		return "cars";
	}
	
	@RequestMapping("/showwelcome")
	public String gotowelcomePage(Model model) {
		return getView("welcome", model);
	}
}
