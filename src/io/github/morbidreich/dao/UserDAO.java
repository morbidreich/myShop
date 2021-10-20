package io.github.morbidreich.dao;

import java.util.List;

import io.github.morbidreich.entity.User;
import io.github.morbidreich.utils.SortOptions;

public interface UserDAO {
	public User getUser(int id);
	public List<User> getUsers(SortOptions sortOptions);
	public void saveUser(User user);
	public void deleteUser(int id);
}
