package io.github.morbidreich.dao;

import java.util.List;

import io.github.morbidreich.entity.User;

public interface UserDAO {
	public User getUser(int id);
	public List<User> getUsers();
	public void saveUser(User user);
	public void deleteUser(int id);
}
