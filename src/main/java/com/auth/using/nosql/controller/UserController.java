package com.auth.using.nosql.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth.using.nosql.entity.User;
import com.auth.using.nosql.repository.MongoRep;
import com.auth.using.nosql.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	MongoRep mongoRep;
	
	@PostMapping(value ="/create")
	 public Map<String, Object> create(@RequestBody User user) {
		user = userRepo.save(user);
	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  dataMap.put("message", "user created successfully");
	  dataMap.put("status", "1");
	  dataMap.put("user", user);
	     return dataMap;
	 }

	@PostMapping(value ="/userById")
	 public Map<String, Object> getUser(@RequestBody User user) {
		Optional<User> user1= userRepo.findById(user.getId());
	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  dataMap.put("message", "user taken successfully");
	  dataMap.put("status", "1");
	  dataMap.put("user", user1);
	     return dataMap;
	 }
	
	@GetMapping(value ="/getAllUser")
	 public List<User> getAllUser() {
		List<User> userList= userRepo.findAll();
	     return userList;
	 }
	
	@GetMapping(value ="/getAllUserSort")
	 public List<User> getAllUserSort() {
		List<User> userList= userRepo.findAll(new Sort(Sort.Direction.ASC, "username"));
	     return userList;
	 }
	
	@PostMapping(value ="/getAllUserById")
	 public List<User> getAllUserById(@RequestBody Test test) {
		List<User> userList = (List<User>)userRepo.findAllById(test.getListn());
	     return userList;
	 }
	
	@PostMapping(value ="/deleteUserById")
	 public String deleteUserById(@RequestBody User user) {
		userRepo.deleteById(user.getId());
	     return "deleted";
	 }
	@PostMapping(value ="/deleteAll")
	 public String deleteAll() {
		userRepo.deleteAll();
	     return "deleted";
	 }
	
	@PostMapping(value ="/userByEmail")
	 public User getUserByMail1(@RequestBody User user) {

		   return mongoRep.findOneByName(user.getUsername());
	 }

}

class Test{
	private List<Integer> listn;

	public List<Integer> getListn() {
		return listn;
	}

	public void setListn(List<Integer> listn) {
		this.listn = listn;
	}
	
}
class IterUser{
	private List<User> listUser;

	public List<User> getListn() {
		return listUser;
	}

	public void setListn(List<User> listn) {
		this.listUser = listn;
	}
	
}
