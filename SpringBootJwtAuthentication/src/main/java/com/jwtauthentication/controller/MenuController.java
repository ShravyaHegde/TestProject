package com.jwtauthentication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtauthentication.Dao.MenuDAO;
import com.jwtauthentication.model.Menu;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/showmenu")
public class MenuController {
	
	@Autowired
	MenuDAO menuDAO;
	
	/*Save an menu*/
	
	@PostMapping("/menus")
	public Menu createMenu(@Valid @RequestBody Menu menu1) {
		return menuDAO.save(menu1);
	}
	
	/*get all menus*/
	
	@GetMapping("/menus")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Menu> getAllMenus(){
		return menuDAO.findAll();
		
	}
		
	/*update all menuid*/
	@PutMapping("/menus/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable(value="id") Long menuid,@Valid @RequestBody Menu menuDetails){
		
		Menu menu=menuDAO.findOne(menuid);
		if(menu==null)
		{
			return ResponseEntity.notFound().build();
		}
		menu.setName(menuDetails.getName());
		menu.setParentid(menuDetails.getParentid());
		
		Menu updateMenu=menuDAO.save(menu);
		return ResponseEntity.ok().body(updateMenu);
	}
	
	/*Delete an menu1id*/
	@DeleteMapping("/menus/{id}")
	public ResponseEntity<Menu> deleteMenu(@PathVariable(value="id") Long menuid){
		
		Menu menu=menuDAO.findOne(menuid);
		if(menu==null)
		{
			return ResponseEntity.notFound().build();
		}
		menuDAO.delete(menu);
		
		return ResponseEntity.ok().build();
	}
	
}
