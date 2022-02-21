package model;

public class QnaDTO {
	
	private int qnaNo;
	private String qnaCategory;
	private String secret;
	private String title;
	private String content;
	private String id;
	private String qnaPw;
	private int qnaRef;
	private int qnaLev;
	private int qnaSeq;
	private int readCount;
	private String regDate;
	private String editDate;
	
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public void setQnaCategory(String qnaCategory) {
		this.qnaCategory = qnaCategory;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setQnaPw(String qnaPw) {
		this.qnaPw = qnaPw;
	}
	public void setQnaRef(int qnaRef) {
		this.qnaRef = qnaRef;
	}
	public void setQnaLev(int qnaLev) {
		this.qnaLev = qnaLev;
	}
	public void setQnaSeq(int qnaSeq) {
		this.qnaSeq = qnaSeq;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	
	public int getQnaNo() {
		return qnaNo;
	}
	public String getQnaCategory() {
		return qnaCategory;
	}
	public String getSecret() {
		return secret;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getId() {
		return id;
	}
	public String getQnaPw() {
		return qnaPw;
	}
	public int getQnaRef() {
		return qnaRef;
	}
	public int getQnaLev() {
		return qnaLev;
	}
	public int getQnaSeq() {
		return qnaSeq;
	}
	public int getReadCount() {
		return readCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public String getEditDate() {
		return editDate;
	}
}
