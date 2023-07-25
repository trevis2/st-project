package srl.ibc.demo.app.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.ibc.demo.app.service.IUserService;
import srl.ibc.demo.app.service.model.User;
import srl.ibc.demo.app.service.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User getUser(Long id) {
		User resp = null;
		try {
			resp = userRepository.findById(id).get();
		} catch (NoSuchElementException e) {

		}
		return resp;
	}

	@Override
	public User insertUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User insertUserAndFlush(User user) {
		return userRepository.saveAndFlush(user);
	}

}
