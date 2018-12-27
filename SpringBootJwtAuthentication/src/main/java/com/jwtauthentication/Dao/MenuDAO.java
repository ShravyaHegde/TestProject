package com.jwtauthentication.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtauthentication.model.Menu;
import com.jwtauthentication.repository.MenuRepository;




@Service
public class MenuDAO {
	@Autowired
	MenuRepository menuRepository;
	
/*to save an menus*/
	
	public Menu save(Menu menu1) {
		return menuRepository.save(menu1);
	}
	
	
	/*search all menu elements by id*/
	public List<Menu> findAll(){
		return menuRepository.findAll();
	}
	
	
	
	/*get an elements in menus*/
	public Menu findOne(Long menuid) {
		return menuRepository.findOne(menuid);
	}
	
	
	/*delete a menu by object*/
	public void delete(Menu menu1) {
		menuRepository.delete(menu1);
	}

}
