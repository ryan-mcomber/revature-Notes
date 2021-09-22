package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Hero;
import com.revature.repository.HeroRepository;

public class HeroServiceImpl implements HeroService{
	
	@Autowired
	HeroRepository heroRepository;

	public boolean registerHero(Hero hero) {
		int pk = heroRepository.insert(hero);
		return (pk>0)?true:false;
	}

	public List<Hero> getAllHeroes() {
		// TODO Auto-generated method stub
		return heroRepository.findAll();
	}

	public Hero getHero(String name) {
		// TODO Auto-generated method stub
		return heroRepository.findByName(name);
	}
	
	

}
