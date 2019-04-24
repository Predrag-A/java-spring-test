package com.example.SpringBootDemo.classes;

public class User {

	private String name;
	private long id;
	private boolean alive;

	public User(String name, long id, boolean alive) {
		this.name = name;
		this.id = id;
		this.alive = alive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
