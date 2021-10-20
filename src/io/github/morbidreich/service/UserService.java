package io.github.morbidreich.service;


import java.util.List;

import io.github.morbidreich.entity.User;
import io.github.morbidreich.utils.SortOptions;


public interface UserService {
	public User getUser(int id);
	public List<User> getUsers(SortOptions sortOptions);
	public void saveUser(User user);
	public void deleteUser(int id);
}
