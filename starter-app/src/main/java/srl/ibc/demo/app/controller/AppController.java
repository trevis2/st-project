package srl.ibc.demo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import srl.ibc.demo.app.service.IUserService;
import srl.ibc.demo.app.service.model.User;

@RestController
public class AppController {

	@Autowired
	private IUserService userService;

	@GetMapping("/user")
	public User getUser(@RequestParam Long id) {
		return userService.getUser(id);
	}

	@PostMapping("/user")
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
}
