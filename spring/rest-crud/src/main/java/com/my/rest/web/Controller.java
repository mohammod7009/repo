package com.my.rest.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.rest.model.Pojo;

@RestController
@RequestMapping("/pojos")
public class Controller {

	/**
	 * CRUD operations
	 * @return
	 */
	@GetMapping("/")
	public List<Pojo> get() {
		List<Pojo> l = new ArrayList<Pojo>();
		Pojo p = new Pojo(1,"Get All 1");
		l.add(p);
		p = new Pojo(2,"Get All 2");
		l.add(p);
		
		return l;
	}
	
	@GetMapping("/{id}")
	public Pojo get(@PathVariable(name="id") int id ) {
		Pojo p = new Pojo(id,"Got");
		return p;
	}
	
	@PostMapping("/")
	public Pojo create(@RequestBody Pojo p) {
		p.setValue("Created " + p.getValue());
		return p;
	}
	
	@PutMapping("/")
	public Pojo update(@RequestBody Pojo p) {
		p.setValue("Updated " + p.getValue());
		return p;
	}
	
	@PatchMapping("/{id}")
	public Pojo patch(@PathVariable(name="id") int id, @RequestBody Pojo p) {
		Pojo p2 = new Pojo(id, "Patched value to: "+ p.getValue());
		return p2;
	}

	@DeleteMapping("/{id}")
	public Pojo delete(@PathVariable(name="id") int id ) {
		Pojo p = new Pojo(id, "Deleted");
		return p;
	}
}
