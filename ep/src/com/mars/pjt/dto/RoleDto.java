package com.mars.pjt.dto;

public class RoleDto {
	private String rolecd;
	private String role;

	public String getRolecd() {
		return rolecd;
	}
	public void setRolecd(String rolecd) {
		this.rolecd = rolecd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "RoleDto [rolecd=" + rolecd + ", role=" + role + "]";
	}
}
