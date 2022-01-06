package model;

public class AdminDTO {
	private String adminId;
	private String adminPw;
	private String adminName;
	
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminId() {
		return adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public String getAdminName() {
		return adminName;
	}
}
