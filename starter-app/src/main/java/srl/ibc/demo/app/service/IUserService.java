package srl.ibc.demo.app.service;

import srl.ibc.demo.app.service.model.User;

public interface IUserService {
	public User getUser(Long id);

	public User insertUser(User user);

	public User insertUserAndFlush(User user);
}
