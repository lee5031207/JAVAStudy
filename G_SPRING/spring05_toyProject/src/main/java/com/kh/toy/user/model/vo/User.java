package com.kh.toy.user.model.vo;

public class User {

	private String userId;
	private String userPw;
	private String userName;
	private String userType;
	private String userPhone;
	private String userEmail;
	private String userRegDate;
	private String userLeaveDate;
	
	public User() {
		
	}

	public User(String userId, String userPw, String userName, String userType, String userPhone, String userEmail,
			String userRegDate, String userLeaveDate) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userType = userType;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userRegDate = userRegDate;
		this.userLeaveDate = userLeaveDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRegDate() {
		return userRegDate;
	}

	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}

	public String getUserLeaveDate() {
		return userLeaveDate;
	}

	public void setUserLeaveDate(String userLeaveDate) {
		this.userLeaveDate = userLeaveDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userType=" + userType
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", userRegDate=" + userRegDate
				+ ", userLeaveDate=" + userLeaveDate + "]";
	}
	
	
	
}
