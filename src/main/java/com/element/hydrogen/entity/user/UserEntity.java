package com.element.hydrogen.entity.user;


import lombok.Data;

@Data
public class UserEntity {

    private String userId;
    private String userName;
    private String sex;
	private String nickName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "UserEntity{" +
				"userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", sex='" + sex + '\'' +
				", nickName='" + nickName + '\'' +
				'}';
	}
}
