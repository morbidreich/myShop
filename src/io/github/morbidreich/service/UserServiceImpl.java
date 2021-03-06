package io.github.morbidreich.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.morbidreich.dao.UserDAO;
import io.github.morbidreich.entity.User;
import io.github.morbidreich.utils.SortOptions;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Override
	public List<User> getUsers(SortOptions sortOptions) {
		return userDAO.getUsers(sortOptions);
	}

	@Override
	public void saveUser(User user) {
		userDAO.saveUser(user);

	}

	@Override
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

}
