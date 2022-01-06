package model;

public class NoticeDTO {
	private int noticeNo;
	private String category;
	private String title;
	private String content;
	private String fileName;
	private String imgName;
	private String adminName;
	private	String impo;
	private String regDate;
	private String editDate;
	
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public void setImpo(String impo) {
		this.impo = impo;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public String getCategory() {
		return category;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getFileName() {
		return fileName;
	}
	public String getImgName() {
		return imgName;
	}
	public String getAdminName() {
		return adminName;
	}
	public String getImpo() {
		return impo;
	}
	public String getRegDate() {
		return regDate;
	}
	public String getEditDate() {
		return editDate;
	}
}

