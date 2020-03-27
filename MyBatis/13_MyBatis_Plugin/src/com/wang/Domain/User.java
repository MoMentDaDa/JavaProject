package com.wang.Domain;

public class User extends UserKey {
    private String name;

    private String password;

    private Integer userType;

    public String getName() {
        return name;
    }

    @Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", userType=" + userType + "]";
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}