package io.github.morbidreich.service;


import java.util.List;

import org.springframework.stereotype.Service;

import io.github.morbidreich.entity.User;

@Service
public interface UserService {
	public User getUser(int id);
	public List<User> getUsers();
	public void updateUser(User user);
	public void deleteUser(int id);
}
