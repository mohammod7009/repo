package com.my.restapi.web;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.my.restapi.exception.UserNotFoundException;
import com.my.restapi.model.User;
import com.my.restapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class Controller {

	/**
	 * CRUD operations
	 * get all
	 * get by ID
	 * create
	 * update by put
	 * update by patch
	 * delete
	 * @return
	 */
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public List<User> get() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable(name="id") int id ) {
		User u = userService.findUser(id);
		if (u == null) {
			throw new UserNotFoundException("No user with ID="+id);		
		}				
		return new ResponseEntity<User>(u, HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> create(@Valid @RequestBody User u) {
		User existingUser = userService.findUser(u.getId());
		if (existingUser != null) {
			throw new RuntimeException("User already exists with ID="+u.getId());		
		}				
		userService.save(u);
		return new ResponseEntity<Object>(u, HttpStatus.CREATED);
	}

//	@PostMapping("/hateos/")
//	public ResponseEntity<Object> createHATEOS(@Valid @RequestBody User u) {
//		User existingUser = userService.findUser(u.getId());
//		if (existingUser != null) {
//			throw new RuntimeException("User already exists with ID="+u.getId());		
//		}				
//		userService.save(u);
//		
//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(u.getId()).toUri();
//		
//		return ResponseEntity.created(location).build();
//	}
	
	@PutMapping("/")
	public ResponseEntity<User> update(@RequestBody User iu) {
		boolean isUpdated = false;
		if (iu!=null) {
			User u = userService.findUser(iu.getId());			
			if (u == null) {
				throw new UserNotFoundException("No user with ID="+iu.getId());		
			}				
			u.setName(iu.getName());
			isUpdated = true;
		}		
		return new ResponseEntity<User>(iu, isUpdated ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<User> patch(@PathVariable(name="id") int id, @RequestBody User iu) {
		boolean isUpdated = false;
		if (iu!=null) {
			User u = userService.findUser(id);			
			if (u == null) {
				throw new UserNotFoundException("No user with ID="+id);		
			}				
			u.setName(iu.getName());
			isUpdated = true;
		}				
		return new ResponseEntity<User>(iu, isUpdated ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> delete(@PathVariable(name="id") int id ) {
		User u = userService.findUser(id);
		if (u == null) {
			throw new UserNotFoundException("No user with ID="+id);		
		}				
		userService.remove(u);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
}
