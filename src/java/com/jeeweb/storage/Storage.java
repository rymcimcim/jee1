package com.jeeweb.storage;

import com.jeeweb.entity.User;
import java.util.HashMap;
import java.util.Map;

public class Storage {
	
	private Map<String, User> users;

	public Storage() {
		this.users = new HashMap<>();
	}

	public Map<String, User> getUsers() {
		return users;
	}
}