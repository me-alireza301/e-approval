package com.fairfield.dao;

import com.fairfield.rules.models.User;

public interface UserDao {
	User getUserByName(String name);
}
