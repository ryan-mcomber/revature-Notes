package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.ClientMessage;
import com.revature.model.Hero;
import com.revature.service.HeroService;

import static com.revature.util.ClientMessageUtil.*;

// tell Spring MVC that this class is capable of handling HTTP web requests
@Controller
public class HeroControllerImpl implements HeroController{
	
	/*
	 * @RequestMapping - Specifies a URL at which the method is available. Binding a function to a url pattern.
	 * 
	 * @ResponseBody - Specifies what we return to the client (typically in JSON format) -> Java to JSON is called marshalling objects
	 * 
	 * @RequestBody - Specifies the type of information the method is taking in -> Unmarshalling is taking in JSON and transforming to java object
	 */
	
	
	//since our hero controller depends on service layer we need to inject that dependency
	@Autowired
	HeroService heroService;
	
	
	
	
	//GET mapping specifies that if the client sends a get request to this URL, we trigger this response.
	@GetMapping("/findAllHeroes")
	public @ResponseBody List<Hero> findAllHeroes(){ //http://localhost:8080/SpringMVC/findAllHeroes
		// we would have to call the service layer!
		return heroService.getAllHeroes();
	}
	
	@PostMapping("/register") //automatically it generates //http://localhost:8080/SpringMVC/register
	public @ResponseBody ClientMessage registerHero(@RequestBody Hero hero) {
		
		//based on whether the insert operation is succesfull, we'll return a specific ClientMessage
		return heroService.registerHero(hero) ? REGISTRATION_SUCCESFUL : SOMETHING_WRONG;
		
	}
	@GetMapping("/findHero") //http://localhost:8080/SpringMVC/findHero?name=____
	public @ResponseBody Hero findHero(@RequestParam String heroName) {
		// TODO Auto-generated method stub
		return heroService.getHero(heroName);
	}

}
