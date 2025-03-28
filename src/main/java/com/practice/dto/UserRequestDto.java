package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String userName;
    private int tierType;
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTierType() {
		return tierType;
	}

	public void setTierType(int tierType) {
		this.tierType = tierType;
	}

	@Override
	public String toString() {
		return "UserRequestDto [userName=" + userName + ", tierType=" + tierType + "]";
	}
    
}
