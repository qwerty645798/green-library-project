package com.library.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserInfoModificationDto {

	@NotBlank(message = "비밀번호를 입력하지 않았습니다.")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#^*_])[A-Za-z\\d!@#^*_]{8,20}$", message = "비밀번호는 8~20자로 숫자, 영문 대소문자, 특수문자 중 3가지 이상 조합이어야 합니다. 사용 가능한 특수문자는 !@#^*입니다.")
	@Size(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하로 입력해주세요.")
	private String user_pass;
	
	@NotBlank(message = "이메일을 입력하지 않았습니다.")
	@Email
	private String email;
	
	@NotBlank(message = "전화번호를 입력하지 않았습니다.")
	@Pattern(regexp = "^01[016789]-?\\d{3,4}-?\\d{4}$", message = "휴대폰 번호는 '010-1234-5678' 또는 '01012345678' 형식으로 입력해주세요.")
	private String phone;

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}